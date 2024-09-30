from fastapi import FastAPI, Request, Body
from openai import OpenAI
from fastapi.middleware.cors import CORSMiddleware
import os
from dotenv import load_dotenv



load_dotenv()

API_KEY = os.getenv("OPENAI_API_KEY")


client = OpenAI(api_key=API_KEY)
app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["https://my-frontend-app.herokuapp.com"],
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/")
async def read_root():
    return {"Message": "Welcome to the Threat Engine API"}
##Add cors in place so it can take in specific IP addrs
@app.post("/arch_data")
async def arch_data(request: Request):
    arch_data = await request.json()
    # return arch_data

    prompt = f"""
        You are an expert cybersecurity analyst. Based on the following JSON data from Lucidchart:

        {arch_data}

        I need you to generate a comprehensive threat model report containing the following sections:

        1. **Threat Summary:** Provide a high-level summary of the identified threats within this architecture.

        2. **Threat Objectives:** Outline the key security objectives for protecting this architecture.

        3. **Components and Connections Table:** Create a table listing all components and their connections in the architecture.

        4. **Threat Scenarios:** For each component and connection, describe possible threat scenarios in a table format.

        5. **Threat Agents and Actors Table:** List all the threat agents, actors, and their roles in potential attacks.

        6. **STRIDE-LM Mapping:** Map each threat scenario to the STRIDE-LM categories (Spoofing, Tampering, Repudiation, Information Disclosure, Denial of Service, Elevation of Privilege, and Lateral Movement).

        7. **Likelihood Rating:** Assign a likelihood rating to each threat scenario.

        8. **Impact on Confidentiality, Integrity, and Availability:** Describe the potential impact of each threat on confidentiality, integrity, and availability (CIA).

        9. **Controls and Mitigations:** For each threat scenario, map the appropriate controls and mitigations that reduce risk.

        10. **Likelihood vs Impact:** Visualize the threat likelihood versus impact mapping (if possible, use a table or describe the distribution).

        11. **Conclusion - Threat Report Summary:** Provide a final summary of the key takeaways from the threat model and any suggested actions.

        Format the report clearly and use tables for all necessary sections. Each section should be labeled appropriately. Be as thorough as possible given the provided data.
        """

    completion = client.chat.completions.create(
        model="gpt-4o-mini", messages=[{"role": "user", "content": prompt}]
    )

    response_content = completion.choices[0].message.content

    print(completion.choices[0].message.content)
    return {"response": response_content}


# change to env variable
# turn this openai call to a class to be resued
