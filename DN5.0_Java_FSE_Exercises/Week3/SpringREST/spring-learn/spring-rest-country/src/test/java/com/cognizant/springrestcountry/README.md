# Spring REST Country Web Service

## Project Description
A Spring Boot REST API that provides country information through various endpoints.

## Technologies Used
- Java 11
- Spring Boot 2.7.0
- Maven
- SLF4J for logging
- JUnit & MockMVC for testing

## API Endpoints

| Endpoint | Method | Description | Sample Response |
|----------|--------|-------------|-----------------|
| `/hello` | GET | Hello World message | `"Hello World!!"` |
| `/country` | GET | Get India country details | `{"code":"IN","name":"India"}` |
| `/countries` | GET | Get all countries | `[{"code":"IN","name":"India"},...]` |
| `/countries/{code}` | GET | Get country by code | `{"code":"IN","name":"India"}` |

## How to Run

### Using Maven
```bash
mvn clean package
mvn spring-boot:run