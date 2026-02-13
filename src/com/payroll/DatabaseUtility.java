package com.payroll;

import java.sql.*;

public class DatabaseUtility {
    private static final String URL = "jdbc:mysql://localhost:3306/payroll_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Mir@123";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void insertEmployee(Employee emp) {
        String query = "INSERT INTO employee_payroll (emp_id, emp_name, basic_salary, hra, da, total_salary) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setDouble(3, emp.getBasicSalary());
            pstmt.setDouble(4, emp.getHra());
            pstmt.setDouble(5, emp.getDa());
            pstmt.setDouble(6, emp.getTotalSalary());
            pstmt.executeUpdate();
            System.out.println("Employee payroll added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewEmployeeSalary(int empId) {
        String query = "SELECT * FROM employee_payroll WHERE emp_id = ?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, empId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("\n--- Employee Salary Details ---");
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Employee Name: " + rs.getString("emp_name"));
                System.out.println("Basic Salary: " + rs.getDouble("basic_salary"));
                System.out.println("HRA: " + rs.getDouble("hra"));
                System.out.println("DA: " + rs.getDouble("da"));
                System.out.println("Total Salary: " + rs.getDouble("total_salary"));
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
