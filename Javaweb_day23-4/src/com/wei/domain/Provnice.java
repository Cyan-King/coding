package com.wei.domain;

import java.util.List;

public class Provnice {

    private int pid;
    private String name;
    private List<City> cities;

    public Provnice() {
        super();
    }

    @Override
    public String toString() {
        return "Provnice{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }

    public Provnice(int pid, String name, List<City> cities) {
        this.pid = pid;
        this.name = name;
        this.cities = cities;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
