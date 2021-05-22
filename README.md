Este projeto tem como objetivo exemplificar o envio e consumo de mensagens via rabbitmq. Para este teste utilizamos a imagem docker rabbitmq:3-management. Para utiliza-la rodando o seguinte comando

docker run -d --hostname localhost --name local-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

Isso subirá em sua máquina um rabbit na porta 15672 que pode ser acessada pela url http://localhost:15672/, usuário/senha guest/guest





This project aims to exemplify the sending and consumption of messages via rabbitmq. For this test we used the image docker rabbitmq:3-management. To use it by running the following command

docker run -d --hostname localhost --name local-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

This will upload a rabbit to your machine at port 15672 which can be accessed via the url http://localhost:15672/, user/password guest/guest