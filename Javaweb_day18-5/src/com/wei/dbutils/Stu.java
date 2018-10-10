package com.wei.dbutils;

public class Stu {
    private int id;
    private String NAME;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Stu() {
        super();
    }

    public Stu(int id, String NAME, int age, String sex) {
        this.id = id;
        this.NAME = NAME;
        this.age = age;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
