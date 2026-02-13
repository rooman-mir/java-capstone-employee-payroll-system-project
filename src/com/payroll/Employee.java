package com.payroll;

public class Employee {
    private int empId;
    private String empName;
    private double basicSalary;
    private double hra;
    private double da;
    private double totalSalary;

    public Employee(int empId, String empName, double basicSalary, double hra, double da, double totalSalary) {
        this.empId = empId;
        this.empName = empName;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.totalSalary = totalSalary;
    }

    public int getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public double getBasicSalary() { return basicSalary; }
    public double getHra() { return hra; }
    public double getDa() { return da; }
    public double getTotalSalary() { return totalSalary; }
}
