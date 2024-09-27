from fastapi import FastAPI, Request, Body
from openai import OpenAI


API_KEY = ""
client = OpenAI(api_key=API_KEY)
app = FastAPI()


##Add cors in place so it can take in specific IP addrs
@app.post("/arch_data")
async def arch_data(request: Request):
    arch_data = await request.json()
    # return arch_data

    prompt = f"Conduct a light weight threat model and give the necessary controls that need to be in place from the following data {arch_data}"
    completion = client.chat.completions.create(
        model="gpt-4o-mini", messages=[{"role": "user", "content": prompt}]
    )

    print(completion.choices[0].message.content)


# change to env variable
# turn this openai call to a class to be resued
