# Java Patterns Study Project
## java-patterns-study

Mock project for pattern study using Java.
Invoice management system with:
+ CRUD operations
+ Validation of invoices
+ Asynchronous communication for payment processings
+ Asynchronous event sourcing for invoice updates

## Patterns :checkered_flag:
- Validation Chain (package com.patterns.domain.validator;)
- Strategy (package com.patterns.domain.strategy;)

## Other 📨
- Projection Views (com.patterns.external.database.projections;)

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