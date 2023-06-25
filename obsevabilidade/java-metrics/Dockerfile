FROM openjdk:17-alpine

WORKDIR /app
COPY ./target/java-metrics-0.0.1-SNAPSHOT.jar ./app.jar

ENV SERVER_PORT 80
ENV POSTGRES_HOST none
ENV POSTGRES_PORT 5432
ENV POSTGRES_SCHEMA none
ENV POSTGRES_USER none
ENV POSTGRES_PASSWORD nome

EXPOSE 80

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]