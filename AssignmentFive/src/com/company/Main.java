package com.company;

import com.company.controllers.EmployeeController;
import com.company.data.DBManager;
import com.company.data.interfaces.IDBManager;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.interfaces.IEmployeeRepository;

public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager(); //database manager
        IEmployeeRepository employeeRepository = new EmployeeRepository(dbManager); //repository
        EmployeeController employeeController = new EmployeeController(employeeRepository); //controller
        MyApplication myApplication = new MyApplication(employeeController); //application
        myApplication.start(); //starting the application
    }
}
