# Computação Distribuída 2324 Noturno - TPA1 - Grupo 06

Este README tem como objetivo explicar as decisões de arquitetura 
 do sistema ImageMarks, bem como os passos necessários para executar as várias aplicações. 

Na implementação entregue é pressuposto que o Register regista todos os Servers
no ínicio, sem a possibilidade de incremento, mas com a possibilidade de 
decrimento, caso exista a informação de que um dos Servers falhou.

## RegisterApp:

A aplicação do Register inicia-se sempre no porto 8000 num determinado endereço IP,
que depende da VM no qual corre a aplicação) e implementa dois serviços: 
o `RegistServerServiceImpl` e o `GetServerServiceImpl`.

O serviço `RegisterServiceImpl` implementa o contrato entre o Server e o Register. Implementa duas operações: 
- O registo de um Server no Register (`registServer`); 
- A operação para o Register obter o Server seguinte (`getNextServer`).

Todas estas operações necessitam de aceder à informação do Register e para tal existe a classe `RegisterInfo` 
que guarda uma lista com os Servers.

As operações possuem a keyword `synchronized` para garantir que apenas uma thread do gRPC altera, em determinado momento,
a lista dos servidores.

O serviço `GetServerServiceImpl` implementa o contrato relativo ao Client e o Register. 
Possui duas operações: 
- A obtenção de um Server para o Client (`getServerEndpoint`);
- A informação por parte do Client que um Server falhou (`failInform`);

Como referido nas FAQs do TPA1, o Register utiliza uma distribuição Round Robin para 
responder ao Client que pretende obter um Server. 
A lista é populada no momento do registo dos Servers e cada vez que um Client faz um pedido ao 
Register é devolvido um Server que se encontra num índice que o Register vai mantendo.

**Uso:** `java -jar RegisterApp-1.0-jar-with-dependencies.jar`



## ServerApp:

Ao executar a aplicação Server, é feito um pedido de registo ao Register sendo recebido como resposta uma confirmação. 

A aplicação Server (à semelhança do Register) implementa dois serviços, o `BaseServiceImpl` e o `RingServiceImpl`. O primeiro diz respeito ao contrato entre o cliente e o kvServer, implementando as operações de writeUpdate e read que podem ser invocadas pelo cliente. Já o segundo serviço é relativo à comunicação entre os kvServers que constituem o anel, sendo implementadas as operações writeNext e readNext.
O código relativo a estas operações é extenso e poderia ser fatorizado numa implementação futura. Existem bastantes comentários, mas de forma resumida, o writeUpdate escreve localmente o par KeyValue e posteriormente tenta propagar o pedido para o seu sucessor. O sucessor fará o mesmo. Caso não consiga obter resposta do sucessor o kvServer informa o ring manager e obtém como resposta um novo sucessor. É então feita a propagação do write para o novo sucessor.
A operação read segue a mesma lógica, mas em vez de escrever o par KeyValue, apenas tentar ler o valor correspondente à key recebida no request.

A propagação do read e write mencionada anteriormente é implementada no `RingServiceImpl` pelas operações readNext e writeNext. O servidor que recebe um pedido de um cliente cria um request no qual coloca a sua informação (endereço IP e porto) e envia este pedido para o seu sucessor. O sucessor verifica se a informação do servidor que iniciou o pedido é a dele e caso não seja propaga o pedido para a frente. A razão pela qual fazemos a verificação ao receber o pedido em vez de antes de enviar para o sucessor relaciona-se com a necessidade de verificar se o sucessor está ativo ou não.
A falha do sucessor é detetada ao tentar criar um canal entre um kvServer e o seu sucessor. Caso seja lançada uma exceção recorremos à operação failInform mencionada no ring manager.

**Nota:** Ao executar a aplicação do kvServer é pressuposto que existe um contentor Docker a correr uma imagem [REDIS](https://redis.io/) na mesma máquina que o kvServer.

**Uso:** `java -jar ServerApp-1.0-jar-with-dependencies.jar <Server IP> <Server Port>  <Register IP> <Volume Port>??`

## Client:

A aplicação Client, ao ser executada conecta-se ao Register e faz um pedido para obter um Server. 
Com uma resposta ao pedido anterior, o Client liga-se ao Server e é apresentado um menu com opções para fazer 
- Processar uma imagem para ser marcada (`ProcessImageToServer`);
- Ver estado da imagem (`CheckImageStatus`);
- Procurar uma imagem pelo seu Id(`DownloadMarkedImageById`);
- Procurar uma imagem pelas suas keywords(`DownloadMarkedImageByKeywords`);
- Terminar a aplicação;

Na nossa implementação é feito o pressuposto que cada Client apenas comunica com um e só um Server, sendo impossível 
comutar para outro servidor sem reiniciar a aplicação Client.

**Uso:** `java -jar ClientApp-1.0-jar-with-dependencies.jar <Register IP>`

