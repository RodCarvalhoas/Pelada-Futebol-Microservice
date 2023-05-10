# Pelada-Futebol-Microservice
Gerenciador de Peladas de Futebol

Este projeto tem como objetivo ser um gerenciador de peladas de futebol, permitindo o cadastro de usuários, campos de futebol, partidas e jogadores para as partidas, como também a função para poder sortear os times. Foi desenvolvido utilizando Java, Spring Boot, Spring Cloud, Netflix Eureka, Docker, KeyCloak e OpenApi/Swagger. Tudo isso em uma arquitetura de microserviços!

Acesse a URL http://localhost:8761 para acessar o nosso service discovery e descobrir as portas random dos nossos microserviços.

Após visualizar a porta de um serviço, basta acessar a seguinte URL: http://localhost:(Aqui vc deve inserir o n° porta)/swagger-ui/index.html para acessar a documentação da API

Autenticação
O projeto utiliza o KeyCloak para autenticação e autorização. Para acessar os endpoints, é necessário informar um token JWT válido.

