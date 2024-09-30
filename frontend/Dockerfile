FROM node:18 as builder

WORKDIR /frontend

# Copy the frontend project files
COPY frontend/threat-007 /frontend

# Install dependencies and build the frontend application
RUN npm install --legacy-peer-deps
RUN npm run build --prod

# Stage 2: Serve the frontend application using a simple HTTP server
FROM node:18

WORKDIR /frontend

# Copy the built frontend application from the builder stage
COPY --from=builder /frontend/dist /frontend

# Install a simple HTTP server
RUN npm install -g http-server

# Expose port for the HTTP server
EXPOSE 80

# Start the HTTP server
CMD ["http-server", "/frontend", "-p", "80"]