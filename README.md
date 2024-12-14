# User Management Application

## Overview

This application is designed to manage users and their occupations. It includes functionality for adding users, retrieving user information, and performing various operations related to user data. The application is built using Spring Boot and leverages Thymeleaf for rendering HTML templates.

## Features

- **User Management**: Create users with validation for name length and minimum age.
- **User Cache**: Store users in memory and fetch them by name or filter by salary and age.
- **Controllers**: Handle user-related requests and provide REST endpoints.
- **Templates**: Form for creating users and displaying all users in an HTML table.
- **Recursive Functions**: Count consonants in a string and check if a number is prime.
- **Unit Tests**: Validate functionality across the application.

## Prerequisites

To run this application, ensure you have the following installed:

- Java 17 or later
- Maven (for dependency management and build)
- Spring Boot 2.x
- JUnit 5 (for unit tests)

## Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/user-management-app.git
   cd user-management-app
   ```

2. Build the application using Maven:
   ```bash
   mvn clean install
    ```
3. Run the application:
    ```bash
   mvn spring-boot:run
    ```
4. Access the application at:
    ```bash
   http://localhost:8080
    ```
   
5. Run Tests using
    ```bash
   mvn test
    ```

## Implementation Details
### User and Occupation Classes
**User Class:** Contains attributes for name, age, and occupation with validation annotations.
**Occupation Class:** Contains attributes for title and salary.
### UserCache Class
- Manages a list of users with methods to fetch by name, filter by salary and age, retrieve the highest paying occupation, fetch all users, and add new users.
### Controllers
**MainController:** Handles requests for displaying all users and providing a form for creating new users.
**UserRestController:** Provides an endpoint to retrieve the occupation with the highest salary.
### Templates
- Implements Thymeleaf templates for rendering forms, displaying user data, and AJAX functionality for real-time updates.
### Unit Testing
**Unit Tests Overview**
- Tests for controller methods to validate model attributes and view names.
- Tests for recursive functions (consonant counting and prime checking).
- Tests for methods in the UserCache class.


