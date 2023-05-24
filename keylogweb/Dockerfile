FROM openjdk:8
EXPOSE 80
ADD target/key-logger-rest.jar key-logger-rest.jar
ENTRYPOINT ["java","-jar","/key-logger-rest.jar"]