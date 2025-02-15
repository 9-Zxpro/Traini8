# Traini8 Backend Application

This project is an MVP for a registry of Government-funded Training Centers. It is built using Spring Boot with Maven, PostgreSQL for persistence, and DTOs for request handling.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Dependencies (in pom.xml)](#Dependencies)
- [Running the Application](#running-the-application)
  

## Overview

This backend application exposes two main REST endpoints:
1. **POST /api/centers/add**: Creates a new training center record.
2. **GET /api/centers**: Retrieves all training center records.
   - Optional filters with state and city: ?state=Karnataka&city=Bangalore

It uses annotation-based validation to ensure the input data is valid. In case of validation errors, a global exception handler returns descriptive error messages.

## Features

- **Spring Boot**: Spring Boot Version 3.4.1.
- **Java**: Java Version 21
- **Maven**: Build and dependency management.
- **PostgreSQL**: Relational database for data persistence. Create a database *traini8*.
- **JPA/Hibernate**: ORM for database interaction.
- **DTOs**: Clean separation between API layer and persistence.
- **Validation**: Using Jakarta Bean Validation annotations.
- **Global Exception Handling**: Consistent error responses using @RestControllerAdvice.
- **Clean Architecture**: Organized packages for controllers, services, repositories, entities, and DTOs.

## Dependencies (in pom.xml)

- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Lombok
- Validation

## Running the Application
- Using Maven:
    mvn spring-boot:run
- Or run the TrainingCenterApplication.java from your IDE.
  

