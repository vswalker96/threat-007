# Use the official Node.js image as the base
FROM node:18 as builder

# Set the working directory in the container
WORKDIR /frontend

# Copy package.json and package-lock.json to install dependencies first (faster builds)
COPY /threat-007/package*.json /frontend/

# Install dependencies
RUN npm install --legacy-peer-deps

# Copy the rest of the Angular project files
COPY /threat-007 /frontend

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Expose the port for the Angular development server
EXPOSE 4200

# Start the Angular development server with ng serve
CMD ["ng", "serve", "--host", "0.0.0.0", "--port", "4200"]