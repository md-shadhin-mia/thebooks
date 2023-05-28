# Spring Boot Application

This is a sample Spring Boot application that demonstrates the setup and configuration process.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Database Configuration](#database-configuration)
- [Building the Application](#building-the-application)
- [Running the Application](#running-the-application)

## Prerequisites

Before getting started, ensure you have the following installed on your system:

- Java Development Kit (JDK) 17 or higher
- Apache Maven (for building the application)
- PostgreSQL (or any other database of your choice)

## Database Configuration

1. Create a new MySQL database for the application. to Update the database configuration you have to set environment veriable.
Command for set environtment veriable 
For Windows Command Prompt:
      ```
set JDBC_URL=<your_JDBC_URL>
set DB_PS=<your_DB_PS>
set DB_USER=<your_DB_USER>
      ```

For Unix/Linux/MacOS Terminal:

```
export JDBC_URL="<your_JDBC_URL>"
export DB_PS="<your_DB_PS>"
export DB_USER="<your_DB_USER>"
```
   
## Building the Application
To build the application, follow these steps:

Open a terminal or command prompt in the project root directory.
Run the following command to build the application using Maven:
```bash
mvn clean install
```


## Running the application

This will compile the source code, run tests, and package the application into a JAR file.

To run the application, follow these steps:

Make sure the database server is running and the database is set up correctly.

Open a terminal or command prompt in the project root directory.

Run the following command to start the application:

```mvn spring-boot:run```
This will start the Spring Boot application on the configured port (usually 8080).

Once the application is running, you can access it in your web browser at http://localhost:8080.

That's it! You have successfully configured, built, and run the Spring Boot application.
