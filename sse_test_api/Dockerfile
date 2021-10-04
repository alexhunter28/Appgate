FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appgate.jar
ENTRYPOINT ["java","-jar","/appgate.jar"]