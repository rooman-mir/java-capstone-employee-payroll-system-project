-- Create Database
CREATE DATABASE IF NOT EXISTS payroll_db;

-- Use Database
USE payroll_db;

-- Create Table
CREATE TABLE IF NOT EXISTS employee_payroll (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    basic_salary DOUBLE NOT NULL,
    hra DOUBLE NOT NULL,
    da DOUBLE NOT NULL,
    total_salary DOUBLE NOT NULL
);
