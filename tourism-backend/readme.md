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

## Implemented routes documentation

# POST /auth/register 
```
Create an user
Expects a JSON:

{
  name: String,
  email: String,
  password: String,
}

Returns 400 BAD REQUEST if email is already registered.
200 Created if the user was created succesfully.
```

# POST /auth/login
```
Login the user
Expects a JSON:

{
   email: String,
   password: String
}

Returns 403 forbidden if email and password doesn't match / doesn't exist.
Returns a JWT token if successfull.
```
