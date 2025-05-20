🍽️ DineGrid Menu Service

The Menu Service is part of the DineGrid Food Ordering Microservices platform. It manages food menu items — handling CRUD operations, exposing APIs for other services like Order Service, caching frequently accessed items, and reacting to async events via Kafka.

📦 Tech Stack
Java 21

Spring Boot 3.4.x

Spring Data JPA

PostgreSQL

Spring Web

Redis (for caching menu item lookups)

Apache Kafka (for consuming order events)

Lombok

MapStruct (for DTO mapping)

Springdoc OpenAPI (Swagger)

🚀 Endpoints
Method	Endpoint	Description
GET	/api/v1/menu	Get all menu items
POST	/api/v1/menu	Add new menu item
PUT	/api/v1/menu/{id}	Update menu item
DELETE	/api/v1/menu/{id}	Delete menu item
GET	/api/v1/menu/{id}	Fetch single menu item by ID

📑 Key Features
✅ Redis Caching

Caches GET /api/v1/menu/{id} responses.

Cache invalidation on update/delete.

✅ Kafka Consumer

Listens on topic order-events for order placement events.

Automatically decrements quantity of menu items based on order.

✅ Quantity Management

Every menu item tracks quantity.

Quantity reduced in response to order events via Kafka.

✅ MapStruct for DTO Mapping

Clean conversion between entity & response/request models.

✅ Docker-Ready

Runs via Docker container.

Can connect to PostgreSQL, Redis, and Kafka through Docker Compose network.

🌐 Swagger UI
Accessible at: http://localhost:8082/swagger-ui.html

🐳 Docker Compose Integration
Uses dedicated Postgres container

Connects to Kafka for async event handling

Connects to Redis for caching

✅ Environment variables for DB and Kafka are configured via application.properties

📖 Next Enhancements
Add metrics via Spring Boot Actuator

Integrate circuit breaker for resilient external service calls

Centralized logging integration (ELK / CloudWatch)



