#Comando Maven para gerar o Jar
FROM maven:3.8.5-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Dockerfile e o OpenJDK para uma aplicação Java
FROM openjdk:11
# Onde eu quero que seja criado o meu arquivo jar
WORKDIR /app
# Copy serve para copiar o arquivo e o segundo parametro para renomear para "app.jar"
# Copy direto do build do jar
COPY --from=build ./app/target/*.jar ./app.jar
# Comando para expor na porta xxxx
EXPOSE 8761
# Especifica um comando que será sempre executado ao iniciar o container
ENTRYPOINT java -jar -Dspring.profiles.active=production app.jar
