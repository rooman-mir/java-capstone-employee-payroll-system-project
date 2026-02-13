package com.payroll;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PayrollService payrollService = new PayrollService();
        DatabaseUtility dbUtility = new DatabaseUtility();
        Employee[] employees = new Employee[100];
        int count = 0;

        while (true) {
            System.out.println("\n=== Amazon Employee Payroll Management System ===");
            System.out.println("1. Add Amazon Employee Payroll Details");
            System.out.println("2. View Amazon Employee Salary");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Amazon Employee ID: ");
                    int empId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Amazon Employee Name: ");
                    String empName = scanner.nextLine();
                    System.out.print("Enter Basic Salary: ");
                    double basicSalary = scanner.nextDouble();

                    double hra = payrollService.calculateHRA(basicSalary);
                    double da = payrollService.calculateDA(basicSalary);
                    double totalSalary = payrollService.calculateTotalSalary(basicSalary, hra, da);

                    Employee emp = new Employee(empId, empName, basicSalary, hra, da, totalSalary);
                    employees[count++] = emp;
                    dbUtility.insertEmployee(emp);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to view salary: ");
                    int searchId = scanner.nextInt();
                    dbUtility.viewEmployeeSalary(searchId);
                    break;

                case 3:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
