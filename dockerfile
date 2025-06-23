# ---- Stage 1: Build the JAR ----
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ---- Stage 2: Run the JAR ----
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/task-exposition/target/task-exposition-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
