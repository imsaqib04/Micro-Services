# 🎯 Quiz App Using Microservices

This project demonstrates a **microservices architecture** for a Quiz Application built with **Spring Boot**.
It is designed to handle quiz creation, question management, and quiz submissions using independent services that communicate via REST APIs.

---

## 🏗 Architecture Overview

The system consists of **four independent microservices**:

1. **Service Registry**

   * **Port**: `8761`
   * **Role**: Eureka Discovery Server
   * **Annotation**: `@EnableEurekaServer`
   * **Purpose**: Keeps track of all registered services for dynamic service discovery.

2. **Question Service**

   * **Port**: `8081` (example)
   * **Database**: `questionDB`
   * **Responsibilities**:

     * Store and manage quiz questions
     * Retrieve questions by category
     * Generate random question IDs for quizzes
     * Calculate quiz scores

3. **Quiz Service**

   * **Port**: `8082` (example)
   * **Database**: `quizDB`
   * **Communication**: Uses `FeignClient` to call **Question Service**
   * **Responsibilities**:

     * Create new quizzes using questions from Question Service
     * Store quiz data
     * Submit quiz answers and get scores

4. **API Gateway**

   * **Port**: `8765`
   * **Purpose**: Routes all incoming requests to the correct microservice using Eureka Service Discovery
   * **Benefit**: Single entry point for all clients

---

## 🛠 Technology Stack

| Layer / Purpose   | Technology                  |
| ----------------- | --------------------------- |
| Framework         | Spring Boot 3.4.3           |
| Language          | Java 17                     |
| Service Discovery | Spring Cloud Netflix Eureka |
| Communication     | OpenFeign                   |
| Databases         | MySQL                       |
| ORM               | Spring Data JPA             |
| Build Tool        | Maven                       |
| Code Reduction    | Lombok                      |

---

## 📂 Project Modules

```
quiz-microservices/
│
├── service-registry/      # Eureka Server
├── question-service/      # Handles question management
├── quiz-service/          # Handles quiz creation & submission
└── api-gateway/           # Routes requests to appropriate services
```

---

## 🗄 Database Setup

### MySQL Databases Required

Before running the services, create two databases:

```sql
CREATE DATABASE questionDB;
CREATE DATABASE quizDB;
```

### `application.properties` Example

#### Question Service (`question-service/src/main/resources/application.properties`)

```properties
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/questionDB
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.application.name=QUESTION-SERVICE
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

#### Quiz Service (`quiz-service/src/main/resources/application.properties`)

```properties
server.port=8082
spring.datasource.url=jdbc:mysql://localhost:3306/quizDB
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.application.name=QUIZ-SERVICE
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
```

---

## 🚀 How to Run

1️⃣ **Start Service Registry**

```sh
cd service-registry
mvn spring-boot:run
```

2️⃣ **Start Question Service**

```sh
cd question-service
mvn spring-boot:run
```

3️⃣ **Start Quiz Service**

```sh
cd quiz-service
mvn spring-boot:run
```

4️⃣ **Start API Gateway**

```sh
cd api-gateway
mvn spring-boot:run
```

---

## 📌 Example API Endpoints

### Question Service

| Method | Endpoint                                  | Description               |
| ------ | ----------------------------------------- | ------------------------- |
| GET    | `/question/all`                           | Get all questions         |
| GET    | `/question/category/{category}`           | Get questions by category |
| POST   | `/question/add`                           | Add a new question        |
| GET    | `/question/generate?category=Java&numQ=5` | Get random question IDs   |

### Quiz Service

| Method | Endpoint                                           | Description                     |
| ------ | -------------------------------------------------- | ------------------------------- |
| POST   | `/quiz/create?category=Java&numQ=5&title=JavaQuiz` | Create a quiz                   |
| GET    | `/quiz/get/{quizId}`                               | Get quiz questions              |
| POST   | `/quiz/submit/{quizId}`                            | Submit quiz answers & get score |

---

## 📷 Architecture Diagram

<img width="1906" height="952" alt="image" src="https://github.com/user-attachments/assets/91985e57-8e24-4bf8-812e-f21219d4ce43" />

---

## Author

* **Mohd Saqib**
  
  GitHub: imsaqib04

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

