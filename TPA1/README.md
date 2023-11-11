# Computação Distribuída 2324 Noturno - TPA1 - Grupo 06

Este documento tem como objetivo explicar as decisões de arquitetura 
 do sistema, bem como os passos necessários para executar as várias aplicações. 

Na implementação entregue é pressuposto que existem apenas três 
Servers, sem a possibilidade de incremento, mas com a possibilidade de 
decrimento, caso exista a informação de que um dos Servers falhou.

## RegisterApp:

A aplicação do Register inicia-se sempre no porto 8000 num determinado endereço IP,
que depende da VM no qual corre a aplicação) e implementa dois serviços: o `RegistServerServiceImpl` e o `GetServerServiceImpl`.

O serviço `RegisterServiceImpl` diz respeito à comunicação entre o kvServer e o ring manager, ou seja, implementa o contrato que possui a operação de registo do kvServer no ring manager, a operação para o kvServer obter o seu sucessor e a operação para informar a falha do sucessor do kvServer ao ring manager. Todas estas operações necessitam de aceder à informação do anel e para tal existe a classe `RingInfo` que guarda uma lista com os kvServers bem como o número de kvServers que o anel suporta (na nossa implementação N = 3).

As operações em si têm que garantir que não existem problemas de concorrência, por exemplo quando adicionamos servidores à lista. Para tal, as operações possuem a keyword `synchronized` que garante que apenas uma thread do gRPC altera em determinado momento a lista dos servidores.

O serviço `GetServerServiceImpl` implementa o contrato relativo ao cliente e o ring manager. Apenas possui uma operação, a obtenção de um kvServer. Tal como pedido no enunciado, o ring manager usa uma distribuição Round Robin para responder ao cliente que pretende obter um kvServer. Como foi dito anteriormente, existe uma lista que é populada no momento do registo dos kvServers e cada vez que um cliente faz um pedido ao ring manager é devolvido um servidor que se encontra num índice que o ring manager vai mantendo.

**Uso:** `java -jar RingManagerApp-1.0-SNAPSHOT-jar-with-dependencies.jar`

## kvServer:

Ao executar a aplicação kvServer, é feito um pedido de registo ao ring manager sendo recebido como resposta uma confirmação. Após isso é feito um novo pedido para obter um sucessor. Se o anel ainda não estiver formado (menos de 3 kvServers registados) reenvia esse mesmo pedido de 10 em 10 segundos até receber uma resposta (significando que o anel se formou).
Esta não é a melhor forma de cumprir o requisito de o manager só enviar o sucessor ao kvServer registado após a formação do anel, pois recorre a muitos pedidos desnecessários não sendo uma solução com escalabilidade. Uma forma mais elegante de cumprir este requisito seria através do uso de java futures.

A aplicação kvServer à semelhança do ring manager implementa dois serviços, o `BaseServiceImpl` e o `RingServiceImpl`. O primeiro diz respeito ao contrato entre o cliente e o kvServer, implementando as operações de writeUpdate e read que podem ser invocadas pelo cliente. Já o segundo serviço é relativo à comunicação entre os kvServers que constituem o anel, sendo implementadas as operações writeNext e readNext.
O código relativo a estas operações é extenso e poderia ser fatorizado numa implementação futura. Existem bastantes comentários, mas de forma resumida, o writeUpdate escreve localmente o par KeyValue e posteriormente tenta propagar o pedido para o seu sucessor. O sucessor fará o mesmo. Caso não consiga obter resposta do sucessor o kvServer informa o ring manager e obtém como resposta um novo sucessor. É então feita a propagação do write para o novo sucessor.
A operação read segue a mesma lógica, mas em vez de escrever o par KeyValue, apenas tentar ler o valor correspondente à key recebida no request.

A propagação do read e write mencionada anteriormente é implementada no `RingServiceImpl` pelas operações readNext e writeNext. O servidor que recebe um pedido de um cliente cria um request no qual coloca a sua informação (endereço IP e porto) e envia este pedido para o seu sucessor. O sucessor verifica se a informação do servidor que iniciou o pedido é a dele e caso não seja propaga o pedido para a frente. A razão pela qual fazemos a verificação ao receber o pedido em vez de antes de enviar para o sucessor relaciona-se com a necessidade de verificar se o sucessor está ativo ou não.
A falha do sucessor é detetada ao tentar criar um canal entre um kvServer e o seu sucessor. Caso seja lançada uma exceção recorremos à operação failInform mencionada no ring manager.

**Nota:** Ao executar a aplicação do kvServer é pressuposto que existe um contentor Docker a correr uma imagem [REDIS](https://redis.io/) na mesma máquina que o kvServer.

**Uso:** `java -jar KvServerApp-1.0-SNAPSHOT-jar-with-dependencies.jar <kvServer IP> <kvServer Port>  <ring manager IP> <REDIS Port>`

## Cliente:

A aplicação cliente é muito simples, ao ser executada liga-se ao ring manager e caso o anel estiver formado, faz um pedido para obter um kvServer. Seguindo a lógica do registo do kvServer no ring manager, se o anel não estiver formado o cliente faz um pedido de 10 em 10 segundos para obter o kvServer. Com uma resposta ao pedido anterior, o cliente liga-se ao kvServer e é apresentado um menu com opções para fazer uma escrita de um par KeyValue, para fazer uma leitura de um valor ou para terminar a aplicação.
A operação de escrita pede ao utilizador que insira um valor no formato JSON e como chave é gerado um hash aleatório. Este valor pode ser consultado posteriormente através da operação de leitura que recebe como parâmetro o hash gerado anteriormente.

Na nossa implementação é feito o pressuposto que cada cliente apenas comunica com um e só um kvServer, sendo impossível comutar para outro servidor sem reiniciar a aplicação cliente.

**Uso:** `java -jar ClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar <ring manager IP>`

## Introdução de novos kvServers no anel:

De forma a adicionar novos servidores ao anel, uma abordagem seria criar um quinto contrato, entre os kvServers e o ring manager, que possua uma operação que ao receber um novo pedido de registo verifica se o número de kvServers definido inicialmente foi alcançado e caso aconteça, envia uma mensagem contendo um novo servidor sucessor para todos os kvServers, incluindo o do novo registo.
Esta solução pressupõe que não existem pedidos a circular no anel no momento do novo registo, pois isso levaria a inconsistências. Em caso de falha de um servidor, acreditamos que a implementação entregue consegue lidar com este tipo de ocorrências.