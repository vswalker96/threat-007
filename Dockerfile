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

RUN cat /app/requirements.txt

RUN pip install --no-cache-dir --upgrade -r /app/requirements.txt

#COPY threat-engine /app
#include the whole project under threat-engine
COPY threat-007 /app

EXPOSE 8000
EXPOSE $PORT

#CMD ["uvicorn", "threat_engine:app", "--host", "0.0.0.0", "--port", "8000"]
#Dynamically adding the port
#CMD ["uvicorn", "threat_engine:app", "--host", "0.0.0.0", "--port", "$PORT"]
CMD ["sh", "-c", "uvicorn threat_engine:app --host 0.0.0.0 --port $PORT"]
