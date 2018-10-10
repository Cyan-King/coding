package com.wei.xstream.demo;

import java.util.ArrayList;
import java.util.List;

public class Province {

    //省份名称
    private String name;
    private List<City> cities = new ArrayList<City>();



    public Province() {
        super();
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", cities=" + cities +
                '}';
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

    public void addCity(City city){
        cities.add(city);
    }

    //获得省份的名字，然后获得下列的所有城市的名称
    public Province(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }
}
