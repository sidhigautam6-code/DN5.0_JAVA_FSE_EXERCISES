# JWT Authentication Service

A Spring Boot-based RESTful web service implementing JWT (JSON Web Token) authentication for secure API access.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Configuration](#configuration)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [JWT Process Flow](#jwt-process-flow)
- [Security Implementation](#security-implementation)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## 🚀 Overview

This project demonstrates the implementation of JWT (JSON Web Token) authentication for RESTful web services using Spring Security. It provides a secure way to authenticate users and authorize API access without maintaining server-side sessions.

### Key Concepts Covered:
- Spring Security configuration with `@Configuration` and `@EnableWebSecurity`
- In-memory authentication with role-based access control
- JWT token generation and validation
- HTTP Basic Authentication and Authorization headers
- Spring Security filters for request interception
- Base64 encoding/decoding

## ✨ Features

- **JWT Authentication**: Secure token-based authentication
- **Role-Based Access Control**: Different permissions for USER and ADMIN roles
- **Token Expiry**: JWT tokens expire after 20 minutes
- **Stateless Authentication**: No server-side session management required
- **Protected Endpoints**: `/countries` endpoint requires valid JWT token
- **Authentication Endpoint**: `/authenticate` generates JWT tokens
- **In-Memory Users**: Pre-configured test users
- **Comprehensive Logging**: Debug-level logging for troubleshooting

## 🛠️ Technology Stack

- **Java**: 11
- **Spring Boot**: 2.7.0
- **Spring Security**: 5.7.0
- **JWT Library**: JJWT 0.9.0
- **Build Tool**: Maven
- **IDE**: VS Code (with Java extensions)

## 📁 Project Structure
jwt-auth-service/
├── src/
│ └── main/
│ ├── java/
│ │ └── com/
│ │ └── cognizant/
│ │ └── springlearn/
│ │ ├── SpringLearnApplication.java
│ │ ├── controller/
│ │ │ ├── AuthenticationController.java
│ │ │ └── CountryController.java
│ │ ├── security/
│ │ │ ├── SecurityConfig.java
│ │ │ └── JwtAuthorizationFilter.java
│ │ └── model/
│ │ └── Country.java
│ └── resources/
│ └── application.properties
├── pom.xml
└── README.md

## 📋 Prerequisites

- **Java 11** or higher
- **Maven 3.6+** or **VS Code with Maven extension**
- **curl** or **Postman** for API testing
- **Git** (optional, for cloning)

## 🔧 Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd jwt-auth-service