FROM openjdk:17-oracle

WORKDIR /app

COPY target/*.jar producer.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "producer.jar"]