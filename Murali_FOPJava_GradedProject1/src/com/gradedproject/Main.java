package com.gradedproject;

public class Main {
    public static void main(String[] args) {

        Super_Department super_department = new Super_Department();
        Admin_Department admin_department = new Admin_Department();
        Hr_Department hr_department = new Hr_Department();
        Tech_Department tech_department = new Tech_Department();

        System.out.println("Welcome to "+admin_department.departmentName()+"\n"+admin_department.getTodaysWork()+"\n"+admin_department.getWorkDeadline()+"\n"+super_department.isTodayAHoliday());
        System.out.println("---------------------------------------------------");
        System.out.println("Welcome to "+hr_department.departmentName()+"\n"+hr_department.doActivity()+"\n"+hr_department.getTodaysWork()+"\n"+hr_department.getWorkDeadline()+"\n"+super_department.isTodayAHoliday());
        System.out.println("---------------------------------------------------");
        System.out.println("Welcome to "+tech_department.departmentName()+"\n"+tech_department.getTodaysWork()+"\n"+tech_department.getWorkDeadline()+"\n"+tech_department.getTechStackInformation()+"\n"+super_department.isTodayAHoliday());
    }
}