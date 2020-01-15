
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
    @SerializedName("temp_max")
    private Double tempMax;
    @SerializedName("temp_min")
    private Double tempMin;

    public Long getHumidity() {
        return humidity;
    }

    public Long getPressure() {
        return pressure;
    }

    public Double getTemp() {
        return temp;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getTempMin() {
        return tempMin;
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

    public static class Builder {

        private Long humidity;
        private Long pressure;
        private Double temp;
        private Double tempMax;
        private Double tempMin;

        public Main.Builder withHumidity(Long humidity) {
            this.humidity = humidity;
            return this;
        }

        public Main.Builder withPressure(Long pressure) {
            this.pressure = pressure;
            return this;
        }

        public Main.Builder withTemp(Double temp) {
            this.temp = temp;
            return this;
        }

        public Main.Builder withTempMax(Double tempMax) {
            this.tempMax = tempMax;
            return this;
        }

        public Main.Builder withTempMin(Double tempMin) {
            this.tempMin = tempMin;
            return this;
        }

        public Main build() {
            Main main = new Main();
            main.humidity = humidity;
            main.pressure = pressure;
            main.temp = temp;
            main.tempMax = tempMax;
            main.tempMin = tempMin;
            return main;
        }

    }

}
