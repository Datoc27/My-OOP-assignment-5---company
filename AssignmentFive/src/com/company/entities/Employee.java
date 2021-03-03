package com.company.entities;

public class Employee {
    private int id;
    private String name;
    private String address;
    private String status;
    private String department;
    private double salary;
    public Employee() {

    }

    public Employee(int id, String name, String address, String status, String department, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String name, String address, String status, String department, double salary) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.department = department;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
