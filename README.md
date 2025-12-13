# Java Patterns Study Project

A mock system for managing renegotiation agreements, built to explore and apply software design patterns using Java and Spring Boot.

---
## 📚 Project Overview

This project serves as a sandbox to study and demonstrate common design patterns in Java within the context of a simple domain: managing agreements, installments, and invoices.

### Architecture

//TODO

### 📦 Entities
- **Agreements**
- **Installments**
- **Invoices**

### 🚀 Key Features
- Full CRUD operations
- Invoice validation logic
- Asynchronous communication for payment processing
- Event sourcing for invoice updates
- Entity aggregation for building comprehensive Agreement views

## 🧠 Implemented Design Patterns
### ✅ Validation Chain
`(package com.patterns.domain.validator;)`

Used in the `createInvoice` flow through the `validateInvoiceRequest` call.
Each invoice field (dueDate, issueDate, issuer, amount) is validated in sequence via the `linkWith` method on ChainValidator.

### 🎯 Strategy
`(package com.patterns.domain.strategy;)`

Employed in `PaymentEventGateway` to dynamically choose the right processing strategy for each payment event.
Iterates through a list of `EventStrategy` implementations and invokes `updatePaymentStatusOnInvoice` on the appropriate one.

### 🔗 Chain of Responsibility with Strategy
`(package com.patterns.domain.strategy.entity.Middleware;)`

Used to sequentially aggregate data from other entities to enrich the Agreement entity.
The `handle` method is invoked on each middleware in the chain, conditionally assembled based on the `expand` field of the request.

### ⚙️ Specification Pattern with JPA Criteria
`(package com.patterns.communication.gateway;)`

To support dynamic and complex filtering of invoices, this project uses the **Specification** pattern from Domain-Driven Design, implemented via Spring Data JPA's `Specification<T>` interface.

The `InvoiceGatewayImpl` dynamically constructs a query using the **JPA Criteria API** based on the fields provided in the `InvoiceFilterRequest`. This approach avoids the need for multiple repository methods for different filter combinations and protects against SQL injection by design. It allows for clean, type-safe, and flexible query building, making it easy to add new filter criteria in the future.

---

## 🧰 Additional Highlights
- **Projection Views**: Efficient data retrieval using partial views from the database (`com.patterns.external.database.projections`)


- **Asynchronous Invoice Validation**: Concurrent validations using `CompletableFuture` before payment processing (`com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase`)


- **Lock-Token for Concurrency Management**: Implemented a custom filter (`com.patterns.common.filter.LockTokenFilter`) to manage concurrent requests using a `Lock-Token` header, ensuring data consistency for update operations.

---

## 🛠 Technologies Used

![Java](https://img.shields.io/badge/Java-E97627?style=for-the-badge&logo=Java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-FF9900?style=for-the-badge&logo=AWS&logoColor=black)

---

## ▶️ How to Run

### ✅ Prerequisites
- Java 17+
- Maven
- Docker (for LocalStack)

### 💻 Steps

1. **Clone the repository**
2. **Build the project**
   ```bash
   mvn clean install
   ```
3. **Start AWS local services**: Run the scripts inside the `local` directory to bootstrap LocalStack and SQS:
   ```bash
   ./local/0-params.sh
   ./local/1-start-sqs-localstack.sh
   ```
4. **Run the application**: Use your IDE or Spring Boot CLI to start the project.

5. **Access the in-memory database** console at:
   ```bash
    http://localhost:8080/h2-console
   ```
6. **Access the swagger** API definition at:
   ```bash
   http://localhost:8080/swagger-ui/index.html
   ```

## 👤 Author

**Giovanna Albuquerque**  
[@GHBAlbuquerque](https://github.com/GHBAlbuquerque)

---

📅 *Built in 2025 for learning and experimentation.*