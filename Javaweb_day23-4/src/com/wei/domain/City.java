package com.wei.domain;

public class City {

    private int cid;
    private String name;
    private Provnice provnice;//多方关联一方

    public City() {
        super();
    }

    @Override
    public String toString() {
        return "City{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", provnice=" + provnice +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Provnice getProvnice() {
        return provnice;
    }

    public void setProvnice(Provnice provnice) {
        this.provnice = provnice;
    }

    public City(int cid, String name, Provnice provnice) {
        this.cid = cid;
        this.name = name;
        this.provnice = provnice;
    }
}
