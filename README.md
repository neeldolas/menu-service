# 🍽️ DineGrid Menu Service

The **Menu Service** is part of the Food Ordering Microservices platform. It manages food menu items — handling CRUD operations and exposing APIs for other services like Order Service to consume.

---

## 📦 Tech Stack:
- Java 21
- Spring Boot 3.4.x
- Spring Data JPA
- PostgreSQL
- Spring Web
- Redis (optional for caching)
- Lombok
- MapStruct
- Springdoc OpenAPI (Swagger)

---

## 🚀 Endpoints:

| Method | Endpoint                 | Description            |
|--------|--------------------------|------------------------|
| GET    | /api/v1/menu              | Get all menu items      |
| POST   | /api/v1/menu              | Add new menu item       |
| PUT    | /api/v1/menu/{id}         | Update menu item        |
| DELETE | /api/v1/menu/{id}         | Delete menu item        |

---

## 📑 Notes:
- No authentication enforced — internal service
- Swagger UI at `http://localhost:8082/swagger-ui.html`
- Service deployed via Docker container (if required)
- Uses MapStruct for DTO mapping

---

