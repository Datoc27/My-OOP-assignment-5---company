package com.company.repositories;

import com.company.data.interfaces.IDBManager;
import com.company.entities.BackendDeveloper;
import com.company.entities.Employee;
import com.company.entities.FrontendDeveloper;
import com.company.entities.Manager;
import com.company.repositories.interfaces.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeRepository implements IEmployeeRepository {
    private final IDBManager dbManager;

    public EmployeeRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Employee> searchEmployeeByName(String name) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection(); //connection with database

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name LIKE '%" + name + "%'"); //sql statement

            ResultSet resultSet = preparedStatement.executeQuery(); //executeQuery method to change the data from the database into String data type

            ArrayList<Employee> employees = new ArrayList<>(); //arraylist of employees

            while(resultSet.next()) { //iteration through resultSet from the database
                Employee employee = new Employee(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("status"),
                        resultSet.getString("department"),
                        resultSet.getDouble("salary"));

                employees.add(employee); //add an employee to the arraylist
            }

            return employees;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee = new Employee();

            if (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setAddress(resultSet.getString("address"));
                employee.setStatus(resultSet.getString("status"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setSalary(resultSet.getDouble("salary"));
            }

            return employee;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (name, address, status, department, salary) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setString(3, employee.getStatus());
            preparedStatement.setString(4, employee.getDepartment());
            preparedStatement.setDouble(5, employee.getSalary());

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean fireEmployeeById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean createProject(int id, int day, int bonus, int penalty){
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id=? AND status LIKE '%" + "Manager" + "%'");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Manager manager = new Manager(); //creating a Manager object

            if (resultSet.next()) { //setting data for the manager object from the database
                manager.setId(resultSet.getInt("id"));
                manager.setName(resultSet.getString("name"));
                manager.setAddress(resultSet.getString("address"));
                manager.setStatus(resultSet.getString("status"));
                manager.setDepartment(resultSet.getString("department"));
                manager.setSalary(resultSet.getDouble("salary"));
            }
            manager.setDoingDuration(day); //setting the deadline
            manager.setBonus(bonus); //setting the bonus
            manager.setPenalty(penalty); //setting the penalty
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public FrontendDeveloper frontendFinishedProject(int id, int day){
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id=? AND status LIKE '%" + "Frontend" + "%'");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            FrontendDeveloper developer = new FrontendDeveloper();

            if (resultSet.next()) {
                developer.setId(resultSet.getInt("id"));
                developer.setName(resultSet.getString("name"));
                developer.setAddress(resultSet.getString("address"));
                developer.setStatus(resultSet.getString("status"));
                developer.setDepartment(resultSet.getString("department"));
                developer.setSalary(resultSet.getDouble("salary"));
            }
            developer.setDoTime(day);
            if (developer.deadline <= developer.getDoTime()) //if/else statement for early and late finishing of the project
                developer.setSalary(developer.getSalary() + developer.getBonus());
            else
                developer.setSalary(developer.getSalary() - developer.getPenalty());
            return developer;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public BackendDeveloper backendFinishedProject(int id, int day){
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id=? and status LIKE '%" + "Backend" + "%'");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            BackendDeveloper developer = new BackendDeveloper();

            if (resultSet.next()) {
                developer.setId(resultSet.getInt("id"));
                developer.setName(resultSet.getString("name"));
                developer.setAddress(resultSet.getString("address"));
                developer.setStatus(resultSet.getString("status"));
                developer.setDepartment(resultSet.getString("department"));
                developer.setSalary(resultSet.getDouble("salary"));
            }
            developer.setDoTime(day);
            if (developer.deadline <= developer.getDoTime())
                developer.setSalary(developer.getSalary() + developer.getBonus());
            else
                developer.setSalary(developer.getSalary() - developer.getPenalty());
            return developer;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
