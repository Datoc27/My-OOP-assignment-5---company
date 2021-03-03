package com.company;

import com.company.controllers.EmployeeController;

import java.util.Scanner;

public class MyApplication {
    private final EmployeeController employeeController;
    private final Scanner scanner;

    public MyApplication(EmployeeController employeeController) {
        this.employeeController = employeeController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) { //choice menu
            System.out.println("1. Search for any employee by name\n" +
                    "2. Get employee by id\n" +
                    "3. Hire an employee\n" +
                    "4. Fire an employee\n" +
                    "5. Create a new project\n" +
                    "6. Frontend developer's salary after finishing the project\n" +
                    "7. Backend developer's salary after finishing the project\n" +
                    "0. Exit\n");
            int operation = scanner.nextInt();

            switch(operation) {
                case 1:
                    searchEmployeeByNameMenu();
                    break;
                case 2:
                    getEmployeeByIdMenu();
                    break;
                case 3:
                    hireEmployeeMenu();
                    break;
                case 4:
                    fireEmployeeByIdMenu();
                    break;
                case 5:
                    createProjectMenu();
                    break;
                case 6:
                    frontendFinishedProjectMenu();
                    break;
                case 7:
                    backendFinishedProjectMenu();
                    break;
                default:
                    System.exit(0);
                    break;
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~");
        }

    }
    public void searchEmployeeByNameMenu() {
        System.out.println("Type the name of the employee:");
        String name = scanner.next();

        String result = employeeController.searchEmployeeByName(name);

        System.out.println(result);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Type the id of the employee:");
        int id = scanner.nextInt();

        String result = employeeController.getEmployeeById(id);

        System.out.println(result);
    }

    public void hireEmployeeMenu() {
        System.out.println("Type the name of the employee:");
        String name = scanner.next();
        System.out.println("Type the address of the employee:");
        String address = scanner.next();
        System.out.println("Type the status of the employee:");
        String status= scanner.next();
        System.out.println("Type the department of the employee:");
        String department= scanner.next();
        System.out.println("Type the salary of the employee:");
        double salary= scanner.nextDouble();

        String result = employeeController.hireEmployee(name, address, status, department, salary);

        System.out.println(result);
    }

    public void fireEmployeeByIdMenu() {
        System.out.println("Type the id of the employee to fire:");
        int id = scanner.nextInt();

        String result = employeeController.fireEmployeeById(id);

        System.out.println(result);
    }

    public void createProjectMenu() {
        System.out.println("Type the id of the manager:");
        int id = scanner.nextInt();
        System.out.println("Type the deadline for the project:");
        int duration = scanner.nextInt();
        System.out.println("Type the bonus for early finishing:");
        int bonus= scanner.nextInt();
        System.out.println("Type the penalty for late finishing:");
        int penalty= scanner.nextInt();

        String result = employeeController.createProject(id, duration, bonus, penalty);

        System.out.println(result);
    }

    public void frontendFinishedProjectMenu() {
        System.out.println("Type the id of the Frontend Developer:");
        int id = scanner.nextInt();
        System.out.println("Type the number of days in which the project was finished:");
        int day = scanner.nextInt();

        employeeController.frontendFinishedProject(id, day);
    }

    public void backendFinishedProjectMenu() {
        System.out.println("Type the id of the Backend Developer:");
        int id = scanner.nextInt();
        System.out.println("Type the number of days in which the project was finished:");
        int day = scanner.nextInt();

        employeeController.backendFinishedProject(id, day);
    }
}