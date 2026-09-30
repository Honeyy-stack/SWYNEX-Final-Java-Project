# SWYNEX Final Java Project – Student Management System

## Description
A console-based Java app for managing student records with MySQL.

## Features
- Add, view, search, update, delete students (CRUD)
- Input validation (name, email, phone, marks)
- Custom exception handling
- JDBC database connectivity

## Concepts Used
Encapsulation, constructors/overloading, DAO pattern, exceptions,
collections, JDBC, PreparedStatement, regex validation.

## Tech Stack
Java 17, MySQL, JDBC

## Project Structure
SWYNEX-Final-Java-Project/
├── src/
│   └── com/swynex/studentapp/
│       ├── model/        → Student.java
│       ├── dao/          → StudentDAO.java
│       ├── util/         → DBConnection.java, Validator.java
│       ├── exception/    → ValidationException.java
│       └── Main.java
├── database/
│   └── schema.sql
├── README.md
└── .gitignore

## Setup Instructions
1. Clone the repo
2. Run database/schema.sql in MySQL
3. Update DB credentials in DBConnection.java
4. Add the MySQL connector JAR
5. Run Main.java

## Author
Honey Goyal | Internship at SWYNEX Technologies
