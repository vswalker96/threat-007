# Stage 1: Build the Spring Boot application
FROM maven:3.9.0-eclipse-temurin-17 as builder

WORKDIR /backend

# Copy the backend project files
COPY backend/threat-007/pom.xml /backend/pom.xml
COPY backend/threat-007/src /backend/src

# Build the Spring Boot application
RUN mvn clean install -DskipTests

# Stage 2: Build the Python application and include JDK 17
FROM python:3.11 as python_builder

WORKDIR /app

# Install JDK 17 in the second stage (Python stage)
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Copy and install Python dependencies (including uvicorn)
COPY threat-engine/requirements.txt /app/requirements.txt
RUN pip install --upgrade pip setuptools
RUN pip install --no-cache-dir --upgrade -r /app/requirements.txt

# Copy the Python application files
COPY threat-engine /app

# Stage 3: Build the Angular frontend application
FROM node:18 as frontend_builder

WORKDIR /frontend

# Copy the frontend project files
COPY frontend/threat-007 /frontend

# Clear npm cache
RUN npm cache clean --force

# Install dependencies and build the frontend application
RUN npm install --legacy-peer-deps
RUN npm run build --prod

# Stage 4: Create the final image
FROM nginx:alpine

# Copy the built frontend application from the frontend_builder stage to serve with Nginx
COPY --from=frontend_builder /frontend/dist /usr/share/nginx/html

# Copy the built Spring Boot application from the builder stage
COPY --from=builder /backend/target/*.jar /app/backend.jar

# Copy the built Python application from the python_builder stage
COPY --from=python_builder /app /app

# Copy custom Nginx config file
COPY nginx.conf /etc/nginx/nginx.conf

# Install JDK 17 and Python dependencies for backend
RUN apk add --no-cache openjdk17 python3 py3-pip build-base libffi-dev

# Create a virtual environment and install uvicorn
RUN python3 -m venv /app/venv
RUN /app/venv/bin/pip install uvicorn

# Expose port for Heroku
EXPOSE 80

# Start both applications (Spring Boot and Python FastAPI) and Nginx
#CMD sh -c "/app/venv/bin/uvicorn threat_engine:app --host 0.0.0.0 --port $PORT & java -jar /app/backend.jar --server.port=$PORT --spring.profiles.active=dev & nginx -g 'daemon off;'"
# Copy the entrypoint script
COPY entrypoint.sh /app/entrypoint.sh

# Make the script executable
RUN chmod +x /app/entrypoint.sh

# Use the entrypoint script to start services
ENTRYPOINT ["/app/entrypoint.sh"]
