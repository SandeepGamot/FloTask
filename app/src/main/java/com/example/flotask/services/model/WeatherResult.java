
package com.example.flotask.services.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class WeatherResult {

    @Expose
    private Main main;
    @Expose
    private String name;
    @Expose
    private Wind wind;

    public Main getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public Wind getWind() {
        return wind;
    }

    public WeatherResult() {
    }

    public WeatherResult(Main main, String name, Wind wind) {
        this.main = main;
        this.name = name;
        this.wind = wind;
    }

    public WeatherResult(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeatherResult{" +
                "main=" + main.toString() +
                ", name='" + name + '\'' +
                ", wind=" + wind.getSpeed() +
                '}';
    }
}
