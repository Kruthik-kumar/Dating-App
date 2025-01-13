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

bash

mvn spring-boot:run

ScreenShots (https://drive.google.com/file/d/1eQHJ7HKI5bmXl8v6o7yZt6epslf00xsZ/view?usp=sharing)
Access the Application
Once the application is running, you can access the recommendation API:

bash

[http://localhost:8080/api/recommendations/{userId}?topN={number}](http://localhost:8080/api/recommendations/2?topN=2)

6. Running Unit Tests
To run the unit tests, use the following Maven command:

bash
mvn test
