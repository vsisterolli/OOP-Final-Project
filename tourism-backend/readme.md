## Installing

# Installing PostgreSQL
1. Go to https://www.postgresql.org/download/ and install acordingly to your OS.
2. Create a user "postgres" and define it's password.
3. Create a database called "tourism".
4. Go to the project folder /src/main/resources/application.properties
- Insert the following text on it:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/tourism
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver


api.security.token.secret=${JWT_SECRET:jwt-secret-key}
```

5. Substitute "password" with the password you choose on postgres user.

## How to run

1. Clone the repository;
2. Install the dependencies (use your IDE or go to the repository folder and run "mvn install")
3. Run the file TourismBackendApplication.java
4. Access the backend through port 8080 (localhost:8080)

## Backend folders architeture - Repository Pattern:

# controllers
Are responsible for managing the REST requests, calling services and methods that are necessary and return the response.

# DTOs
Data transfer units, classes usefull to transfer data between methods.

# models
Shape the model in the database

# config
Spring configuration, CORS, security, etc.

# repository
Database communication layer. It has the methods to gather / insert data on the database.

# services
Useful methods, like token handling, authorization, etc.

# Authorization
- All DELETE/POST routes are blocked by default (except authentication/reservation). You need to create an ADMIN user, just change on "AuthenticationController" file from "Role.USER" to "Role.ADMIN" and create a user.
- The authentication is made through use of Bearer tokens, so, create a header "Authentication" with value "Bearer " + token for each request.

# Important
- There is no migration setted up, so the database will initially be empty and no data would be available to be displayed on the front end, you can create using the post routes with an admin user.

## Project UML
![Diagrama em branco](https://github.com/vsisterolli/OOP-Final-Project/assets/118028581/edb8893b-a4eb-409f-adc6-f70cabde15cc)
