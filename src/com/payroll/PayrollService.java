package com.payroll;

public class PayrollService {
    
    public double calculateHRA(double basicSalary) {
        return basicSalary * 0.20;
    }

    public double calculateDA(double basicSalary) {
        return basicSalary * 0.10;
    }

    public double calculateTotalSalary(double basicSalary, double hra, double da) {
        return basicSalary + hra + da;
    }
}
