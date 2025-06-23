FROM openjdk:17-jdk-slim

WORKDIR /app

COPY task-exposition/target/task-exposition-*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
