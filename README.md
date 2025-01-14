Dating-Suggestions
Overview
This project implements a dating recommendation engine using Spring Boot and MySQL. The engine recommends potential matches based on shared interests and other criteria such as age and gender.

Features
User registration with details like name, gender, age, and interests.
Recommendation service that suggests top matches based on interests, age, and gender.
In-memory MySQL database for storing user data.
REST API for fetching recommendations.
Prerequisites
Java 23 
MySQL
Maven

Set Up MySQL Database
Make sure your MySQL server is running and create a database called datingdb:

sql

CREATE DATABASE datingdb;
Configure application.properties
In the src/main/resources/application.properties file, ensure the following database configuration:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/datingdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
4. Run the Application
To run the application, use the following command:

mvn spring-boot:run

ScreenShots (https://drive.google.com/file/d/1eQHJ7HKI5bmXl8v6o7yZt6epslf00xsZ/view?usp=sharing)
Access the Application
Once the application is running, you can access the recommendation API:

[http://localhost:8080/api/recommendations/{userId}?topN={number}](http://localhost:8080/api/recommendations/2?topN=2)

Running Unit Tests
To run the unit tests, use the following Maven command:

mvn test
