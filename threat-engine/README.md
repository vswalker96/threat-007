# Threat Engine

This is a Threat Agent AI bot that consumes the Lucidchart API, analyzes application architecture flow charts using OpenAI, and generates a threat analysis report in PDF format.

## Prerequisites

- Python 3.8 or above installed
- An API key for OpenAI
- Lucidchart API access (if applicable)

## Installation and Setup

Follow the steps below to set up and run the Threat Engine.

### Step 1: Clone the Repository

```bash
git clone <repository_url>
cd <repository_name>
```

### Step 2: Create and Activate a Virtual Environment
 - Create virtual environment \
    - ```bash
    python -m venv venv
    ```
 - Activate Virtual env
    - ```bash
    venv\Scripts\activate
    ```

### Step 3: Install requiresd packages
- ```bash
pip install -r requirements.txt
```
- pip install fastapi uvicorn openai

### Run the application
- ```bash
uvicorn threat_engine:app --host 0.0.0.0 --port 8000
```

