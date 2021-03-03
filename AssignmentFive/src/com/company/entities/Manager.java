package com.company.entities;

import com.company.entities.interfaces.INonprogrammer_member;

public class Manager extends Employee implements INonprogrammer_member {

    public Manager() {
    }

    public Manager(String name, String address, String status, String department, double salary) {
        super(name, address, status, department, salary);
    }

    public void setDoingDuration(int day){
        BackendDeveloper.deadline=day;
        FrontendDeveloper.deadline=day;
    }
    public void setBonus(int bonus){
        BackendDeveloper.Bonus=bonus;
        FrontendDeveloper.Bonus=bonus;
    }
    public void setPenalty(int penalty){
        BackendDeveloper.Penalty=penalty;
        FrontendDeveloper.Penalty=penalty;
    }
    public String manage(){
        return super.getName()+ " manage the department "+super.getDepartment();
    }
    public String work(){
        return super.getName()+ " works in IT company as manager";
    }
    public String gettingSalary(){
        return "He get salary "+gettingSalary()+"$ permonth.";
    }
    public void ManagerInfo(){
        System.out.println(work());
        System.out.println(getSalary());
        System.out.println(manage());
    }
}
