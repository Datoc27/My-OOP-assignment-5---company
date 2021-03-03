package com.company.controllers;

import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepository;

public class EmployeeController {
    private final IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String searchEmployeeByName(String name) {
        return employeeRepository.searchEmployeeByName(name).toString();
    }

    public String getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id).toString();
    }

    public String hireEmployee(String name, String address, String status, String department, double salary) {

        boolean added = employeeRepository.hireEmployee(new Employee(name, address, status, department, salary));

        if (added) {
            return "The employee was successfully hired!";
        }
        return "An error occurred!";
    }

    public String fireEmployeeById(int id) {
        boolean removed = employeeRepository.fireEmployeeById(id);

        if (removed) {
            return "The employee was successfully fired!";
        }

        return "An error occurred!";
    }

    public String createProject(int id, int duration, int bonus, int penalty) {
        boolean created = employeeRepository.createProject(id, duration, bonus, penalty);

        if (created) {
            return "The project was created and active now!";
        }

        return "An error occurred!";
    }

    public void frontendFinishedProject(int id, int day){
        employeeRepository.frontendFinishedProject(id, day).FrontendInfo();
    }

    public void backendFinishedProject(int id, int day){
        employeeRepository.backendFinishedProject(id, day).BackendInfo();
    }
}
