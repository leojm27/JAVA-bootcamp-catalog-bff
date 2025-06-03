FROM azul/zulu-openjdk:21-jre

WORKDIR /app

COPY target/catalog-bff-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]