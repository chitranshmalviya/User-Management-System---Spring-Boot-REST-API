# **User Management System - Spring Boot REST API**

## **Project Overview**
The **User Management System** is a REST API developed using **Spring Boot** to manage user data effectively. It provides functionalities for performing CRUD (Create, Read, Update, Delete) operations and adheres to RESTful design principles to ensure scalability and ease of use. 

## **Features**
- **Create Users:** Add new users with details such as name, email, and phone number.
- **Retrieve Users:** Fetch user details by ID or retrieve a list of all users.
- **Update Users:** Modify existing user information.
- **Delete Users:** Remove user records from the system.
- **Consistent Error Handling:** Includes custom exceptions for improved error tracking.
- **Standardized Response Structure:** Ensures clarity and consistency for API consumers.

## **Technologies Used**
- **Framework:** Spring Boot
- **Language:** Java
- **Database:** MySQL Database
- **ORM Tool:** Spring Data JPA
- **Build Tool:** Maven

## **Project Structure**
```plaintext
src/main/java
├── com.spring.rest.ums
│   ├── controller   # REST controllers
│   ├── model        # Entity classes
│   ├── repository   # JPA repositories
│   ├── service      # Business logic
│   ├── exception    # Custom exceptions
│   ├── util         # Utility classes
