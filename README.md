# Employee Payroll Management System

## Setup Instructions

### 1. Database Setup
- Install MySQL
- Run the `database_setup.sql` script
- Update database credentials in `DatabaseUtility.java` (URL, USER, PASSWORD)

### 2. Add MySQL JDBC Driver
- Download MySQL Connector/J from: https://dev.mysql.com/downloads/connector/j/
- Add the JAR file to your classpath

### 3. Compile the Project
```bash
cd c:\Users\mirrooma\Downloads\Jva
javac -d bin src\com\payroll\*.java
```

### 4. Run the Application
```bash
java -cp bin com.payroll.MainApp
```

## Features
- Add employee payroll details
- Calculate HRA (20% of basic salary)
- Calculate DA (10% of basic salary)
- Store data in MySQL database
- View employee salary by ID
