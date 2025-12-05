# E-Commerce Microservices System  
Microservices architecture built using **Spring Boot**, **Kafka**, **Redis**, **MySQL**, and **OpenFeign**.  
This system simulates a complete E-commerce backend including ordering, customers, products, payments, and notifications.

---

## 📌 **Architecture Overview**

### Services included:
1. **Customer Service**  
   - Manages customer creation, update, delete, and retrieval.
   - Exposes REST endpoints.
   - Used remotely by Order Service via FeignClient.

2. **Product Service**  
   - Manages products, stock, categories.
   - Deducts product quantity when an order is created.

3. **Order Service**  
   - Main business workflow:
     - Validate customer (via Feign)
     - Validate product (via Feign)
     - Create order
     - Publish event to Kafka (`order-events`)
   - Subscribes for payment updates.

4. **Payment Service**
   - Listens to Kafka order events.
   - Processes payment.
   - Publishes payment status to Kafka topic (`payment-events`).

5. **Notification Service**
   - Listens to Kafka payment events.
   - Sends email/SMS/notification.
   - Stores notifications temporarily in Redis.

---

## 🧩 **Technologies Used**

| Technology | Usage |
|-----------|--------|
| **Spring Boot 3** | Microservices |
| **Spring Cloud** | Feign, Config Server, Eureka |
| **Kafka** | Event-driven communication |
| **Redis** | Caching, fast-access notification store |
| **MySQL** | Data persistence |
| **Docker Compose** | Infrastructure for Kafka/Redis/MySQL |
| **Lombok** | Boilerplate removal |

---

