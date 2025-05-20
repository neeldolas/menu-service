# 🍽️ DineGrid Menu Service

The **Menu Service** is a core part of the **DineGrid Food Ordering Microservices Platform**. It manages food menu items — handling CRUD operations, caching frequently accessed data with Redis, and consuming Kafka events from the Order Service to update item availability and stock quantities in real time.

---

## 📦 Tech Stack:
- Java 21
- Spring Boot 3.4.x
- Spring Data JPA
- PostgreSQL
- Redis (via Docker, for caching menu items)
- Spring Kafka (for event-driven messaging)
- Lombok
- MapStruct
- Springdoc OpenAPI (Swagger)

---

## 🚀 Endpoints:

| Method | Endpoint              | Description                |
|:--------|:----------------------|:----------------------------|
| `GET`   | `/api/v1/menu`         | Get all menu items           |
| `GET`   | `/api/v1/menu/{id}`    | Get a single menu item by id |
| `POST`  | `/api/v1/menu`         | Add a new menu item          |
| `PUT`   | `/api/v1/menu/{id}`    | Update an existing menu item |
| `DELETE`| `/api/v1/menu/{id}`    | Delete a menu item           |

---

## ⚙️ Features:
- **Redis Caching** — caches `GET /api/v1/menu/{id}` responses.
- **@CacheEvict / @CachePut** — keeps cache consistent after update & delete.
- **Kafka Consumer** — listens to `order-events` topic for order placed events and updates the menu item stock quantities in real-time.
- **MapStruct DTO Mapping** — clean separation between Entity and Response/Request models.
- **Dockerized Service** — can run standalone or via docker-compose.

---

## 📑 Notes:
- No authentication enforced (internal service).
- Swagger UI available at: `http://localhost:8082/swagger-ui.html`
- Service runs via Docker container using docker-compose.
- Kafka runs via Docker network for inter-service messaging.
- Redis container for caching (optional).

---

## 🐳 Run with Docker Compose:

```bash
docker-compose up --build -d
