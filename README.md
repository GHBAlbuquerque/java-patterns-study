# Java Patterns Study Project
## java-patterns-study

Mock project for pattern study using Java.

This is a Renegotiation Agreement management system created solely for pattern study using Java and SpringBoot.

### Entities:
- Agreements
- Installments
- Invoices

### Features: 
+ CRUD operations
+ Validation of invoices
+ Asynchronous communication for payment processings
+ Asynchronous event sourcing for invoice updates
+ Entity aggregation for Agreement entity

## Patterns :checkered_flag:
- Validation Chain ```(package com.patterns.domain.validator;)```
   ```
   Used in the method 'createInvoice' through the 'validateInvoiceRequest' call. 
   Validates dueDate, issueDate, issuer and amount before creation, 
   linking each validation with the next one thought the 'linkWith' method on ChainValidator.
   ```
- Strategy ```(package com.patterns.domain.strategy;)```
   ```
   Used on the PaymentEventGateway to strategically select the event processing class according to event type.
  Iterates over a List<EventStrategy> and calls the 'updatePaymentStatusOnInvoice' method 
  on the first strategy that matches the event type.
   ```
- Chain of Responsibility (with strategy) ```(package com.patterns.domain.strategy.entity.Middlware;)```
   ```
   Used to consecutivelly aggregate information from other entities to complete de Agreement entity.
   The 'handle' method is called on each middleware, passing the current state of the Agreement entity through a builder.
   Strategies are conditionally chained according to their enum type and if it was received in request's expand. 
  ```

## Other 📨
- Use of Projection Views to fetch and return partial fields from the database ```(com.patterns.external.database.projections;)```
- Use of CompletableFuture for validation of invoices before processing them for payment ```(package com.patterns.common.interfaces.usecases.BatchValidateInvoiceUseCase;)```

## Technologies :robot:

![image](https://img.shields.io/badge/Java-E97627?style=for-the-badge&logo=Java&logoColor=white)
![image](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![image](https://img.shields.io/badge/AWS-FF9900?style=for-the-badge&logo=AWS&logoColor=black)

## How to Run :computer:

1. Clone the repository:
2. Install all dependencies using Maven:
   ```bash
   mvn clean install
   ```
3. Create a localstack for using AWS components by running the scripts located in the `local` folder:
   ```bash
   ./local/0-params.sh
   ./local/1-start-sqs-localstack.sh
   ```
4. Run the application

## Authors

*Giovanna Albuquerque* [@GHBAlbuquerque](https://github.com/GHBAlbuquerque)

Done in 2025