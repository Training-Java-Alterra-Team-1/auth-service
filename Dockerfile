FROM openjdk:8
EXPOSE 8082
COPY target/auth-service.jar auth-service.jar
ENTRYPOINT ["java", "-jar", "/auth-service.jar"]