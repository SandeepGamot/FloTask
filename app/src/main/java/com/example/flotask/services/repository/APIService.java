package com.example.flotask.services.repository;


import com.example.flotask.services.model.WeatherResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    //Weather API
    //http://samples.openweathermap.org/data/2.5/weather?q=London&appid={APP_ID}
    @GET("data/2.5/weather?")
    Call<WeatherResult> getWeatherData(@Query("q") String city,@Query("appid") String appID);

    //City API
    //https://api.myjson.com/bins/lw9qf
//    @GET("/bins/lw9qf")
//    Call<List<City>> getCityList();
}
