# Threat007

**Threat007** is an intelligent AI-powered agent designed to detect and analyze potential security threats within cloud architectures. Inspired by the stealth and precision of 007, it consumes application architecture flowcharts from Lucidchart, uses OpenAI to perform threat analysis, and generates detailed PDF reports. The platform enables users to stay ahead of vulnerabilities and ensure the security of their systems.

- **Video Demo**: https://youtu.be/KubLZvZFTwQ
- Contributors LinkedIn:
   - https://www.linkedin.com/in/victoria-s-walker/
   - https://www.linkedin.com/in/louisarnold/    

## **Table of Contents**
- [Project Overview](#project-overview)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)

## **Project Overview**

Threat007 is composed of three main components:
- **Backend (Spring Boot)**: Acts as the orchestrator, handling communication between the frontend, Lucidchart API, and the Python microservice.
- **Python Microservice**: Processes the threat analysis using OpenAI and generates PDF reports.
- **Frontend (Angular)**: Provides a user-friendly interface to trigger analyses and view/download reports.

## **Architecture**

The system is designed as a microservice architecture with the following data flow:

1. **Frontend (Angular)** sends a request to the Spring Boot backend to fetch Lucidchart data or trigger a threat analysis.
2. **Spring Boot** retrieves the Lucidchart JSON, forwards it to the Python microservice, and stores the generated PDF report in the database.
3. **Python Microservice** communicates with the OpenAI API for threat analysis, converts the report into a PDF, and returns it to the backend.
4. The **Frontend** displays the reports and allows users to download them.

## **Technologies Used**

- **Frontend:** Angular
- **Backend:** Java Spring Boot
- **Microservice:** Python (Flask or FastAPI)
- **Database:** PostgreSQL or MySQL
- **AI Processing:** OpenAI API
- **PDF Generation:** Python libraries (`ReportLab`, `PDFKit`)
- **Cloud Storage:** (Optional) AWS S3 or similar

## **Getting Started**

### Prerequisites
- Java 17+
- Python 3.8+
- Node.js 16+ and npm
- PostgreSQL/MySQL
- Lucidchart API Key and OpenAI API Key

### **Installation**

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/threat-007.git
   cd threat-007
