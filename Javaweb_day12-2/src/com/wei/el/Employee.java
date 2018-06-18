package com.wei.el;

public class Employee {
    private String name;
    private double pay;
    private Address address;

    public Employee() {
        super();
    }

    public Employee(String name, double pay, Address address) {
        this.name = name;
        this.pay = pay;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", pay=" + pay +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
