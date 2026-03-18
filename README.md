# Experiment 6 - JWT Authentication Backend (Spring Boot)

Deadline: 17 March 2026

This project implements JWT-based authentication using Spring Boot, Spring Security, and H2 database.

## Features

- User login with username/password and JWT token generation.
- Protected API route accessible only with valid JWT.
- Logout endpoint that invalidates JWT (in-memory blacklist for the running session).
- Default demo user auto-created for quick testing.

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- H2 Database
- JJWT (io.jsonwebtoken)

## Project Structure

```text
exp-6-FSD/
├── screenshots/
│   └── README.md
├── src/
│   └── main/
│       ├── java/com/exp6/jwtauth/
│       │   ├── config/
│       │   │   ├── DataInitializer.java
│       │   │   ├── JwtAuthenticationFilter.java
│       │   │   └── SecurityConfig.java
│       │   ├── controller/
│       │   │   ├── AuthController.java
│       │   │   └── ProtectedController.java
│       │   ├── dto/
│       │   │   ├── AuthResponse.java
│       │   │   ├── LoginRequest.java
│       │   │   ├── MessageResponse.java
│       │   │   └── RegisterRequest.java
│       │   ├── entity/
│       │   │   └── User.java
│       │   ├── repository/
│       │   │   └── UserRepository.java
│       │   ├── service/
│       │   │   ├── AuthService.java
│       │   │   ├── CustomUserDetailsService.java
│       │   │   ├── JwtService.java
│       │   │   └── TokenBlacklistService.java
│       │   └── Exp6JwtAuthApplication.java
│       └── resources/
│           └── application.properties
├── .env.example
├── .gitignore
├── pom.xml
└── README.md
```

## Run Locally

### 1) Start project

```bash
mvn spring-boot:run
```

Server runs on:

- `http://localhost:5000`

## Live Deployment

Use `Render` for this project, not `Netlify`.

- `Render` supports long-running Java/Spring Boot backend services.
- `Netlify` is mainly for static frontend sites and serverless functions, so it is not the right fit for this Spring Boot app.

### Render setup

1. Push this project to GitHub.
2. In Render, create a new `Web Service` from the GitHub repo.
3. Use these settings:
   - Runtime: `Java`
   - Build Command: `mvn clean package -DskipTests`
   - Start Command: `java -jar target/jwt-auth-backend-0.0.1-SNAPSHOT.jar`
4. Add environment variables if needed:
   - `JWT_SECRET`
   - `JWT_EXPIRATION_MS`

The app is already configured for Render's dynamic port using:

```properties
server.port=${PORT:5000}
```

### Important note

This project uses an in-memory `H2` database, so all data resets whenever the service restarts or redeploys. That is acceptable for demo submission, but not for a persistent production deployment.

### 2) Default user (already seeded)

- `username`: `user123`
- `password`: `password123`

## API Endpoints

### Health (public)

- `GET /api/health`

### Register (public)

- `POST /api/auth/register`
- Body:

```json
{
  "username": "newuser",
  "password": "newpassword"
}
```

### Login (public)

- `POST /api/auth/login`
- Body:

```json
{
  "username": "user123",
  "password": "password123"
}
```

- Success response:

```json
{
  "token": "<jwt_token>",
  "message": "Login successful"
}
```

### Protected route (JWT required)

- `GET /api/protected`
- Header:

```text
Authorization: Bearer <jwt_token>
```

### Logout (JWT required)

- `POST /api/auth/logout`
- Header:

```text
Authorization: Bearer <jwt_token>
```

After logout, the same token becomes invalid for this running app session.

## Postman Demonstration Steps

1. Send login request to `POST /api/auth/login` with valid credentials.
2. Copy token from response.
3. Call `GET /api/protected` with `Authorization: Bearer <token>`.
4. Call `POST /api/auth/logout` with same token.
5. Retry `GET /api/protected` with same token and show unauthorized response.

## Required Screenshots (at least 3)

Store all screenshots inside `screenshots/`:

1. Successful login and token in response.
2. Protected route success using bearer token.
3. Logout + invalid token behavior (or unauthorized access after invalidation).

## GitHub Notes

- `.gitignore` is included.
- Keep `.env` out of Git. Use `.env.example` as reference.
- Commit your screenshots and README clearly for evaluation.
