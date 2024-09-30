#!/bin/sh

# Replace placeholder with the actual port for Nginx
sed -i "s/listen 80;/listen $PORT;/" /etc/nginx/nginx.conf

# Use $PORT for Nginx, a unique port for Spring Boot, and a different port for Uvicorn (FastAPI)
uvicorn threat_engine:app --host 0.0.0.0 --port 8000 &  # FastAPI on port 8000
java -jar /app/backend.jar --server.port=8080 --spring.profiles.active=dev &  # Spring Boot on port 8080
nginx -g 'daemon off;'
