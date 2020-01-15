
package com.example.flotask.services.model;

import java.util.List;

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
                "main=" + main.toString()+
                ", name='" + name + '\'' +
                ", wind=" + wind.getSpeed() +
                '}';
    }

    public static class Builder {


        private Main main;
        private String name;
        private Wind wind;



        public WeatherResult.Builder withMain(Main main) {
            this.main = main;
            return this;
        }

        public WeatherResult.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public WeatherResult.Builder withWind(Wind wind) {
            this.wind = wind;
            return this;
        }

        public WeatherResult build() {
            WeatherResult weatherResult = new WeatherResult();

            weatherResult.main = main;
            weatherResult.name = name;
            weatherResult.wind = wind;
            return weatherResult;
        }

    }

}
