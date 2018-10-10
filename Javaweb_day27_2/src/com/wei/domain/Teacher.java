package com.wei.domain;

public class Teacher {

    private String number;//编号
    private String name;//姓名
    private double salary;//工资

    public Teacher() {
        super();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher(String number, String name, double salary) {
        this.number = number;
        this.name = name;
        this.salary = salary;
    }
}
