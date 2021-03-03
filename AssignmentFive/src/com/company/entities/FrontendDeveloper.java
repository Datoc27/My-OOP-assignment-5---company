package com.company.entities;

import com.company.entities.interfaces.IProgrammer_member;

public class FrontendDeveloper extends Employee implements IProgrammer_member {
    public static int deadline;
    public static int Bonus;
    public static int Penalty;
    private int doTime;

    public FrontendDeveloper() {
    }

    public FrontendDeveloper(String name, String address, String status, String department, double salary) {
        super(name, address, status, department, salary);
    }

    public int getDoTime() {
        return doTime;
    }

    public void setDoTime(int doTime) {
        this.doTime = doTime;
    }

    public String programs() {
        return super.getName() + " programs in " + super.getDepartment() + " department";
    }

    public String work() {
        return super.getName() + " works in IT company as Frontend developer.";
    }

    public String gettingSalary() {
        return "He get salary " + getSalary() + "$ per month.";
    }

    public int get_doing_duration() {
        return deadline;
    }

    public int getBonus() {
        return Bonus;
    }

    public int getPenalty() {
        return Penalty;
    }
    public String write(){
        return "He writes HTML and CSS pages.";
    }
    public String checking() {
        if (deadline <= doTime)
            return "He got bonus in "+getBonus()+"$ for early done.";

        else
            return "He got penalty in "+getPenalty()+"$ for late";

    }
    public void FrontendInfo(){
        System.out.println(work());
        System.out.println(programs());
        System.out.println(getSalary());
        System.out.println(write());
        System.out.println(checking());
    }
}
