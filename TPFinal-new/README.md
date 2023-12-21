# Bem-vindo

##### Neste guia estão descritas todas as informações necessárias para puder executar o projeto criado por Diogo Almeida, Rodrigo Nogueira e Sofia Condesso.

Este repositório pode ser encontrado no [github](https://github.com/sofiafernandescd/cd_meim2324/tree/main/TPFinal).

### Requisitos

* Na máquina pessoal:
* Ter o java instalado (Versão 11.0.20.1)
* Ter o Maven (Versão 3.9.6)


* Na máquina virtua do GCP:
* Ter uma conta GCP
* Instância req. min. - Tipo e2-medium (2 vCPU, 1 core, 4 GB memory)
* Ter o GCC (Versão 9.4.0)
* Ter o Spread (Versão 5.00.01)
* Ter o Glusterd (Versão 7.9)
* Ter o Docker (Versão 24.0.7)

### Guia

###### 1. Iniciar o servidor de RabbitMQ

`sudo docker run -d --hostname rabbithost --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management`

###### 2. Iniciar o gluster

`sudo service glusterd start`

###### 3. Iniciar Spread

`/usr/local/sbin/spread -c /usr/local/etc/vmsSpread.conf > /tmp/spreadlogs 2>&1 &`

###### 4. Iniciar o Broker 

`java -jar Broker-1.0-jar-with-dependencies.jar <IP externo da VM> 5672`

###### 5. Iniciar PointOfSale 

`java -jar PointOfSale-1.0-jar-with-dependencies.jar <IP externo da VM>`

###### 6. Iniciar Worker

`java -jar Worker-1.0-jar-with-dependencies.jar <IP externo da VM> <ID> <Categoria (ALIMENTAR OU CASA)> 
<IP interno da VM>`

###### 7. Iniciar Servidor Manager

`java -jar Manager-1.0-jar-with-dependencies.jar <IP interno da VM>`

###### 8. Iniciar UserApp

`java -jar UserApp-1.0-jar-with-dependencies.jar`


**Nota:** Para informações com mais detalhe sobre as instalações, consultar o [ficheiro](/Ficheiro com comandos de InstalaçãoConfiguração de VMsFile.txt).