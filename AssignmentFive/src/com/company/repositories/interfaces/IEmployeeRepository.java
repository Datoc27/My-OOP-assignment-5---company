package com.company.repositories.interfaces;

import com.company.entities.BackendDeveloper;
import com.company.entities.Employee;
import com.company.entities.FrontendDeveloper;

import java.util.ArrayList;

public interface IEmployeeRepository { //interface for the repository
    ArrayList<Employee> searchEmployeeByName(String name);
    Employee getEmployeeById(int id);
    boolean hireEmployee(Employee employee);
    boolean fireEmployeeById(int id);
    boolean createProject(int id, int day, int bonus, int penalty);
    FrontendDeveloper frontendFinishedProject(int id, int day);
    BackendDeveloper backendFinishedProject(int id, int day);
}
