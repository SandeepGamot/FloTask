
package com.example.flotask.services.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Main {

    @Expose
    private Long humidity;
    @Expose
    private Long pressure;
    @Expose
    private Double temp;

    public String getHumidity() {
        return String.valueOf(humidity);
    }

    public String getPressure() {
        return String.valueOf(pressure);
    }

    public String getTemp() {
        return String.valueOf((int)(temp - 273.15));
    }


    public Main() {
    }

    public Main(Long humidity, Long pressure, Double temp) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Main{" +
                "humidity=" + humidity +
                ", pressure=" + pressure +
                ", temp=" + temp +
                '}';
    }
}


