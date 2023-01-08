FROM openjdk:11.0.16-jre-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} pim-service.jar
ENTRYPOINT ["java","-jar","/pim-service.jar"]