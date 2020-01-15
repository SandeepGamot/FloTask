
package com.example.flotask.services.model;


import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Wind {

    @Expose
    private Long deg;
    @Expose
    private Double speed;

    public Long getDeg() {
        return deg;
    }

    public Double getSpeed() {
        return speed;
    }

    public Wind()
    {
    }

    public Wind(Double speed) {
        this.speed = speed;
    }

    public static class Builder {

        private Long deg;
        private Double speed;

        public Wind.Builder withDeg(Long deg) {
            this.deg = deg;
            return this;
        }

        public Wind.Builder withSpeed(Double speed) {
            this.speed = speed;
            return this;
        }

        public Wind build() {
            Wind wind = new Wind();
            wind.deg = deg;
            wind.speed = speed;
            return wind;
        }

    }

}
