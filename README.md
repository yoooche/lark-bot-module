# Lark Data Transformer Bot

## Introduction
Lark Data Transformer Bot is an enterprise-grade automation tool designed to handle high-throughput data mapping and transformation within the Lark ecosystem.

The bot allows users to upload source and target files (.xlsx / .csv), defines mapping logic through an interactive UI, and leverages LLMs to generate highly flexible transformation scripts. These scripts are executed within a secure GraalVM sandbox on the backend, ensuring zero-trust security while processing up to 500,000+ rows of data using streaming I/O.
## System Architecture

### Component Diagram
(Pending)

### Sequence Diagram
(Pending)

## Key Features
- Streaming Processing: Capable of handling 500k+ rows without memory overflow.
- AI-Powered Mapping: Automatically generates complex JS transformation logic based on user requirements.
- Security First: All third-party scripts run in an isolated GraalVM context with restricted I/O and network access.
- Interactive UI: Seamless mapping experience via Lark Web App (H5).

## Tech Stack

### Backend
- Java 21: Leveraging Virtual Threads for high-concurrency I/O operations.
- Spring Boot 3: The core framework for handling Webhooks and RESTful APIs.
- GraalVM: Used as a high-performance Polyglot Sandbox to execute LLM-generated JavaScript mapping logic securely.
- LangChain4j: Orchestrating LLM interactions with built-in Self-healing mechanisms for script generation.
- EasyExcel: Efficient streaming processing for large Excel files to prevent OutOfMemoryError.

### GCP (Google Cloud Platform)
- Cloud Run: Serverless container execution for scalable backend processing.
- GCS (Google Cloud Storage): Temporary storage for large data files with automated lifecycle management.
- Artifact Registry: Secure hosting for Docker images.
- Secret Manager: Centralized management of sensitive API keys and tokens.

### DevOps
- GitHub Actions: Fully automated CI/CD pipeline including GraalVM Native Image builds.
- Terraform: Infrastructure-as-Code (IaC) for reproducible cloud resource management.
- Workload Identity Federation (WIF): Keyless authentication between GitHub and GCP.

## Credentials

### Lark
| item   | description     |
|--------|-----------------|
| LARK_APP_ID |Unique identifier for the application|
|LARK_APP_SECRET|Secret key used to generate access tokens|
|LARK_VERIFY_TOKEN|Token to verify that requests are sent from Lark|
|LARK_ENCRYPT_KEY|Key for AES-256-CBC decryption of event payloads|

### GCP
| item   | description     |
|--------|-----------------|
| GCP_PROJECT_ID |The ID of your Google Cloud Project|
|GCP_GCS_BUCKET|The name of the storage bucket|
|GCP_WIF_PROVIDER|Workload Identity Federation Provider ID|

### LLM
| item   | description     |
|--------|-----------------|
| LLM_API_KEY |API Key for OpenAI / Gemini / Claude|