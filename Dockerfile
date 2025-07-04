FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
WORKDIR /home/app/gerenciador-contatos-back
COPY . .
RUN mvn -v
RUN mvn clean package

FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /home/app/gerenciador-contatos-back/target/*.jar /usr/local/lib/gerenciador-contatos-back.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/gerenciador-contatos-back.jar"]
