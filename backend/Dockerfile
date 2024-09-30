# Stage 1: Build the Spring Boot application
FROM maven:3.9.0-eclipse-temurin-17 as builder

WORKDIR /backend

# Copy the backend project files
COPY threat-007/pom.xml /backend/pom.xml
COPY threat-007/src /backend/src

# Build the Spring Boot application
RUN mvn clean install -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built Spring Boot application from the builder stage
COPY --from=builder /backend/target/*.jar /app/backend.jar

# Expose port for Spring Boot
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "/app/backend.jar", "--spring.profiles.active=dev"]