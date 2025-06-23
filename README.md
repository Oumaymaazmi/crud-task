
# 🛠️ Product Management Backend

This is the backend service of the **Product Management App**, built with **Spring Boot** using **Clean Architecture (DDD)**.  
It provides secure REST APIs to manage products and users using JWT authentication.

---

## 📦 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security (JWT)
- PostgreSQL
- JPA / Hibernate
- MapStruct
- Flyway
- Maven

---

## 📁 Project Structure

```bash
├── domain/        # Business logic & domain model
├── infra/         # Infrastructure: JPA, DB migration, persistence
├── service/       # Application services (use cases)
├── exposition/    # Web layer: controllers, config, main app
└── pom.xml        # Parent Maven build file
```

---

## 📥 Clone the Repository

```bash
git clone https://github.com/Oumaymaazmi/crud-task.git
```

---

## ⚙️ Configure the Database

1. Create a PostgreSQL database:

```sql
CREATE DATABASE product_db;
```

2. Update `task-exposition/src/main/resources/application.yaml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/product_db
    username: your_username
    password: your_password

```

## 📌 Features

- ✅ Product CRUD (create, read, update, delete)
- 🔐 JWT Authentication (register / login)
- 🚫 Secure API endpoints
- 🧠 Clean DDD architecture
- 🧪 Unit-tested service layer
- 📜 Flyway DB migrations
- 🌍 Custom error messages (`message.properties`)
- 💬 Centralized exception handling

---
## 📡 API Endpoints

### 🔐 Authentication

| Method | Endpoint         | Description         |
|--------|------------------|---------------------|
| POST   | `/auth/register` | Register a new user |
| POST   | `/auth/login`    | Authenticate user & return JWT |

### 📦 Product Management

| Method | Endpoint        | Description         |
|--------|------------------|---------------------|
| GET    | `/product/{id}` | Get product by ID   |
| GET    | `/product`      | List all products   |
| POST   | `/product`      | Create a new product|
| PUT    | `/product/{id}/update` | Update product      |
| DELETE | `/product/{id}` | Delete product      |

> All endpoints (except `/auth/**`) require authentication.

