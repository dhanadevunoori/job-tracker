# 🗂️ Job Tracker API

A RESTful backend API for tracking job applications, built with Java Spring Boot and secured with JWT authentication.

## 🚀 Live Demo

**Base URL:** https://job-tracker-9b1i.onrender.com

**Swagger UI:** https://job-tracker-9b1i.onrender.com/swagger-ui/index.html

> ⚠️ Hosted on Render free tier — may take 30–60 seconds to wake up after inactivity.

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.5
- Spring Security + JWT
- Spring Data JPA
- H2 In-Memory Database
- Docker

## ✨ Features

- User Registration & Login with JWT Authentication
- Create, Read, Update, Delete Job Applications
- Track application status per user
- Swagger UI for API documentation & testing

## 📦 Run Locally

```bash
git clone https://github.com/dhanadevunoori/job-tracker.git
cd job-tracker
mvn spring-boot:run
```

Visit: http://localhost:8080/swagger-ui/index.html

## 🐳 Docker

```bash
docker build -t job-tracker .
docker run -p 8080:8080 job-tracker
```
