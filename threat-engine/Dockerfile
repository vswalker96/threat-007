FROM python:3.11

WORKDIR /app

# Install JDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Copy and install Python dependencies
COPY requirements.txt /app/requirements.txt
RUN pip install --upgrade pip setuptools
RUN pip install --no-cache-dir --upgrade -r /app/requirements.txt

# Copy the Python application files
COPY . /app

# Expose port for FastAPI
EXPOSE 8000

# Start the FastAPI application
CMD ["uvicorn", "threat_engine:app", "--host", "0.0.0.0", "--port", "8000"]