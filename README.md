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

---

## 🧰 Additional Highlights
- **Projection Views**: Efficient data retrieval using partial views from the database (`com.patterns.external.database.projections`)
- **Asynchronous Invoice Validation**: Concurrent validations using `CompletableFuture` before payment processing (`com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase`)

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
3. **Start AWS local services**
   Run the scripts inside the `local` directory to bootstrap LocalStack and SQS:
   ```bash
   ./local/0-params.sh
   ./local/1-start-sqs-localstack.sh
   ```
4. **Run the application**
   Use your IDE or Spring Boot CLI to start the project.

## 👤 Author

**Giovanna Albuquerque**  
[@GHBAlbuquerque](https://github.com/GHBAlbuquerque)

---

📅 *Built in 2025 for learning and experimentation.*