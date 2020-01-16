
package com.example.flotask.services.model;


import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Wind {


    @Expose
    private Double speed;

    public String getSpeed() {
        return String.valueOf(speed);
    }

    public Wind(Double speed) {
        this.speed = speed;
    }

}
