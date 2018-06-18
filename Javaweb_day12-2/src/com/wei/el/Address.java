package com.wei.el;

public class Address {
    private String City;
    private String Stree;

    public Address() {
        super();
    }

    public Address(String city, String stree) {
        City = city;
        Stree = stree;
    }

    @Override
    public String toString() {
        return "Address{" +
                "City='" + City + '\'' +
                ", Stree='" + Stree + '\'' +
                '}';
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStree() {
        return Stree;
    }

    public void setStree(String stree) {
        Stree = stree;
    }
}
