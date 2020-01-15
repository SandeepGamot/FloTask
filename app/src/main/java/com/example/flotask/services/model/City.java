
package com.example.flotask.services.model;

import java.util.List;
import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class City {

    @Expose
    private List<City> cities;
    @Expose
    private String name;

    public City(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
