# Smart Job Application Tracker

A production-grade REST API built with Java 17 and Spring Boot 3.5 to track job applications.

## Live Demo
Swagger UI: https://job-tracker-production-38db.up.railway.app/swagger-ui/index.html

## Tech Stack
- Java 17, Spring Boot 3.5
- Spring Security + JWT Authentication
- Spring Data JPA + Hibernate
- MySQL (production), H2 (in-memory for testing), Swagger UI
- JUnit 5 + Mockito
- Deployed on Railway

## Features
- User Registration and Login with JWT tokens
- BCrypt password encryption
- Full CRUD for job applications
- Filter by status (Applied/Interview/Offer/Rejected)
- Analytics endpoint with success rate
- Unit tests with JUnit 5 and Mockito

## API Endpoints
- POST /api/auth/register
- POST /api/auth/login
- GET /api/applications
- POST /api/applications
- PUT /api/applications/{id}
- DELETE /api/applications/{id}
- GET /api/analytics

## Run Locally
1. Clone the repo
2. Run: mvn spring-boot:run
3. Open: http://localhost:8080/swagger-ui/index.html
