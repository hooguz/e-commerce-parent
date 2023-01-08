FROM openjdk:11.0.16-jre-slim-buster
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} om-service.jar
ENTRYPOINT ["java","-jar","/om-service.jar"]