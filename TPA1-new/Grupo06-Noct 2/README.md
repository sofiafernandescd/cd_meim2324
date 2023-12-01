# Bem-vindo

# Computação Distribuída 2324 Noturno - TPA1 - Grupo 06

##### Este README tem como objetivo explicar as decisões de arquitetura do sistema ImageMarks, bem como os passos necessários para executar as várias aplicações.
##### Na implementação entregue é pressuposto que os Servers se registem no Register, existindo a possibilidade de incremento do número de Servers que o Register tem registados e a possibilidade de decrimento, caso exista a informação de que um dos Servers falhou.

Este é o  repositório onde o projeto está alocado [project](https://github.com/sofiafernandescd/cd_meim2324)

## RegisterApp:

A aplicação do Register inicia-se sempre no porto 8005 num determinado endereço IP que, depende da VM no qual corre a aplicação, e implementa dois serviços: 
- `RegisterServerServiceImpl`
- `ClientRegisterServiceImpl`

O serviço `RegisterServerServiceImpl` implementa o contrato entre o Server e o Register. A implementação do registo de um Server no Register é feita com a operação:
- `registServer` 

Esta operação e todas as operações feitas dentro do `Register`necessitam de aceder à informação do Register e para tal existe a classe `RegisterInfo` que guarda uma lista com os Servers.

O serviço `ClientRegisterServiceImpl` implementa o contrato relativo ao Client e o Register. 
Possui duas operações: 
- A obtenção de um Server para o Client (`getServerEndpoint`);
- A informação por parte do Client que um Server falhou (`failInform`);

Como referido nas FAQs do TPA1, o Register utiliza uma distribuição Round Robin para responder ao Client que pretende obter um Server. 
A lista é populada no momento do registo dos Servers e cada vez que um Client faz um pedido ao Register é devolvido um Server que se encontra num índice que o Register vai mantendo.

**Uso:** `java -jar RegisterApp-1.0-jar-with-dependencies.jar <IP do Register>`

**Para sair:** `q`


## ServerApp:

Ao executar a aplicação Server, é feito um pedido de registo ao Register sendo recebido como resposta uma confirmação. O Server fica depois na lista de servidores disponíveis guardada em `RegisterInfo`.

A aplicação Server implementa um serviço, `ProcessImageServiceImpl` que, diz respeito ao contrato entre o Client e o Server e implementa as operações de upload, check status e download (por id ou keywords).

Cada Server possui um atributo `ImagesInfo` que guarda um `HashMap<String, ImageBlock>`, onde a `String` é o ID da imagem e o `ÌmageBlock` é a imagem guardada para download posterior.

**Uso:** `java -jar ServerApp-1.0-jar-with-dependencies.jar <Server IP> <Server Port> <Register IP>`

**Para sair:** `q`

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

**Uso:** `java -jar ClientApp-1.0-jar-with-dependencies.jar <Register IP> <RegisterPort>`

**Podem ser utilizadas as imagens da pasta deste projeto**
Quando o Client se liga a um Server através do Register, aparece um menu com as seguintes opções: 

**Caso 1** - Processar uma imagem para ser marcada:<br>
`Nome do ficheiro da imagem:` <br>
`lena.jpg` <br>
`Insere as Keywords:` <br>
`lena girl` <br>

**Caso 2** - Ver estado da imagem:<br>
`Inserir ID da imagem para ver o estado:` <br>
`<ID da Imagem>` <br>

**Caso 3** - Procurar uma imagem pelo seu Id:<br>
`Inserir o ID da imagem para fazer download:` <br>
`<ID da Imagem>` <br>

**Caso 4** - Procurar uma imagem pelas suas keywords:<br>
`Inserir keywords para fazer download de imagem:` <br>
`<Keywords separadas por espaço>` <br>

**Caso 0** - Termina o Cliente.

## Pressupostos:
Para obter os ficheiros `.jar` do `ClientApp`, `ServerApp` e o `RegisterApp` usando o Maven, tem que fazer "Package" e de seguida "Install".

## Nota:
Nesta versão de implementação não foi utilizado Docker para lançar os servidores gRPC.