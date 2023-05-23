# Pelada-Futebol-Microservice
Gerenciador de Peladas de Futebol

Este projeto tem como objetivo ser um gerenciador de peladas de futebol, permitindo o cadastro de usuários, campos de futebol, partidas e jogadores para as partidas, como também a função para poder sortear os times. Foi desenvolvido utilizando Java, Spring Boot, Spring Cloud, Netflix Eureka, H2 database, Docker, KeyCloak e OpenApi/Swagger. Tudo isso em uma arquitetura de microserviços!

Acesse a URL http://localhost:8761 para acessar o nosso service discovery(Será necessário inserir um login, o mesmo está no final do README) e descobrir as portas random dos nossos microserviços.

Após visualizar a porta de um serviço, basta acessar a seguinte URL: http://localhost:(Aqui vc deve inserir o n° porta)/swagger-ui/index.html para acessar a documentação da API

*Autenticação* 

O projeto utiliza o KeyCloak para autenticação e autorização. Iremos rodar o KeyCloak em um container do Docker usando o seguinte comando no cmd:
      
      "docker run -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.1.1 start-dev"
     




iremos liberar na porta 8081, espelhando a 8080 do docker, pois já temos o nosso Gateway rodando na porta 8080. Para acessar os endpoints, é necessário informar um token JWT válido e para isso iremos ter que configurar o nosso KeyCloak acessando a URL http://localhost:8081, após configurar é só obter o Token diretamente da sua ferramenta de testes de requisições, utilizei o Postman e depois é so inserir o Token no "Authorization" - Type "Bearer Token" e ser feliz hahaha!

Para proteger o Service Discovery, utilizei o Spring Security, pois não desejamos que nenhum outro serviço se registre no nosso Netflix Eureka,     
      
      name: mseureka-user
      password: mea-sueresurk

