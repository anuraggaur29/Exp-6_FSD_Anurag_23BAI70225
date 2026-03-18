# Experiment 6 - JWT Authentication Backend

This repository contains the submission for **Experiment 6** of Full Stack Development.  
The application is a **Spring Boot backend** that implements **JWT-based authentication and authorization** with login, registration, protected route access, and logout token invalidation.

## Objective

The goal of this experiment is to build and demonstrate a secure backend that:

- authenticates users using username and password
- generates JWT tokens after successful login
- protects selected API routes using JWT
- invalidates tokens on logout
- provides a live deployed version for evaluation

## Features Implemented

- User registration with validation
- User login with JWT token generation
- Protected API endpoint accessible only with a valid token
- Logout support with token blacklist handling
- Public health endpoint for service verification
- Default demo user auto-seeded for testing
- Live deployment on Render

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- H2 In-Memory Database
- JJWT
- Maven
- Docker
- Render

## Live Demo

- Live App: `https://exp-6-fsd-anurag-23bai70225.onrender.com/`
- Health Check: `https://exp-6-fsd-anurag-23bai70225.onrender.com/api/health`

## Demo Credentials

Use the following default user for evaluation:

- Username: `user123`
- Password: `password123`

## Project Structure

```text
exp-6-FSD/
|-- screenshots/
|   |-- README.md
|   |-- 01-login-success.png
|   |-- 02-protected-with-token.png
|   |-- 03-logout-success.png
|   |-- 04-protected-after-logout.png
|   |-- 05-register-new-user.png
|   |-- 06-health-check.png
|   |-- 07-run-results-summary.png
|   |-- render-health.png
|   `-- render-home.png
|-- src/
|   `-- main/
|       |-- java/com/exp6/jwtauth/
|       |   |-- config/
|       |   |-- controller/
|       |   |-- dto/
|       |   |-- entity/
|       |   |-- repository/
|       |   |-- service/
|       |   `-- Exp6JwtAuthApplication.java
|       `-- resources/
|           `-- application.properties
|-- .dockerignore
|-- .env.example
|-- .gitignore
|-- Dockerfile
|-- pom.xml
|-- render.yaml
`-- README.md
```

## API Endpoints

| Method | Endpoint | Access | Purpose |
|---|---|---|---|
| `GET` | `/` | Public | Shows that the backend is live |
| `GET` | `/api/health` | Public | Health/status check |
| `POST` | `/api/auth/register` | Public | Register a new user |
| `POST` | `/api/auth/login` | Public | Login and receive JWT token |
| `GET` | `/api/protected` | Protected | Access secure backend data |
| `POST` | `/api/auth/logout` | Protected | Logout and invalidate current token |

## Sample Request Bodies

### Register

```json
{
  "username": "newuser123",
  "password": "newpassword123"
}
```

### Login

```json
{
  "username": "user123",
  "password": "password123"
}
```

## How To Run Locally

### Option 1: Maven

```bash
mvn spring-boot:run
```

The application runs at:

- `http://localhost:5000`

### Option 2: Packaged Jar

```bash
mvn clean package -DskipTests
java -jar target/jwt-auth-backend-0.0.1-SNAPSHOT.jar
```

## Deployment

This project is deployed on **Render** using **Docker**.

Important deployment note:

- the project uses an **H2 in-memory database**
- data is reset whenever the service restarts or redeploys
- this is acceptable for experiment evaluation and demonstration

## Evaluation Workflow

To verify the project, the following flow can be checked:

1. Open the live app or local backend.
2. Call `POST /api/auth/login` using the demo credentials.
3. Copy the JWT token from the response.
4. Call `GET /api/protected` using `Authorization: Bearer <token>`.
5. Call `POST /api/auth/logout` using the same token.
6. Retry `GET /api/protected` with the old token and observe unauthorized access.

## Screenshot Evidence

All screenshots used for submission are stored in the [`screenshots`](screenshots) folder.

### Live Deployment Screenshots

#### Live Home Route

![Live home route](screenshots/render-home.png)

#### Live Health Route

![Live health route](screenshots/render-health.png)

### Postman Verification Screenshots

- [01-login-success.png](screenshots/01-login-success.png)
- [02-protected-with-token.png](screenshots/02-protected-with-token.png)
- [03-logout-success.png](screenshots/03-logout-success.png)
- [04-protected-after-logout.png](screenshots/04-protected-after-logout.png)
- [05-register-new-user.png](screenshots/05-register-new-user.png)
- [06-health-check.png](screenshots/06-health-check.png)
- [07-run-results-summary.png](screenshots/07-run-results-summary.png)

## Submission Notes

- The backend has been successfully deployed and tested.
- Root route and health route are publicly accessible for quick evaluation.
- Authentication flow works for login, protected access, logout, and invalid-token rejection.
- README and screenshots are included for direct review.

## Repository Notes

- `.env` is excluded from version control
- `.env.example` is included as reference
- deployment files are included: `Dockerfile` and `render.yaml`

