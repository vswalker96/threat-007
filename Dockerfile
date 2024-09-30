# Use a multi-stage build to keep the final image size small

# Stage 1: Build the Spring Boot application
FROM maven:3.9.0-eclipse-temurin-17 as builder

WORKDIR /backend

# Copy the backend project files
COPY backend/threat-007/pom.xml /backend/pom.xml
COPY backend/threat-007/src /backend/src

# Install JDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Build the Spring Boot application
RUN mvn clean install -DskipTests

# Stage 2: Build the Python application and include JDK 17
FROM python:3.11

WORKDIR /app



COPY threat-engine/requirements.txt /app/requirements.txt

RUN pip install --upgrade pip setuptools

RUN apt-get update && apt-get install -y \
    build-essential \
    libssl-dev \
    libffi-dev \
    python3-dev \
    && rm -rf /var/lib/apt/lists/*

RUN pip install --no-cache-dir --upgrade -r /app/requirements.txt

COPY threat-engine /app

# Copy the built Spring Boot application from the builder stage
COPY --from=builder /backend/target/*.jar /app/backend.jar

# Expose ports for both applications
EXPOSE 8000
EXPOSE 8080

# Set environment variables for MongoDB
ENV MONGO_USERNAME=your_mongo_username
ENV MONGO_PASSWORD=your_mongo_password

# Start both applications
CMD ["sh", "-c", "uvicorn threat_engine:app --host 0.0.0.0 --port $PORT & java -jar /app/backend.jar --spring.profiles.active=dev"]