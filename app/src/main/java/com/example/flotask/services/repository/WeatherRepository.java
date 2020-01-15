package com.example.flotask.services.repository;

import android.util.Log;


import androidx.lifecycle.MutableLiveData;

import com.example.flotask.services.model.Main;
import com.example.flotask.services.model.WeatherResult;
import com.example.flotask.services.model.Wind;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRepository {
    final String TAG = this.getClass()
                           .getSimpleName();

    private static final String WEATHER_API_URL = "https://api.openweathermap.org/";
    private static WeatherRepository weatherRepository;
    private APIService apiService;

    private WeatherRepository() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(WEATHER_API_URL)
                                                  .addConverterFactory(GsonConverterFactory.create())
                                                  .build();
        apiService = retrofit.create(APIService.class);
    }

    public synchronized static WeatherRepository getInstance() {
        if (weatherRepository == null) {
            return new WeatherRepository();
        }
        return weatherRepository;
    }

    public MutableLiveData<WeatherResult> getWeatherData(String city, String appid) {
        MutableLiveData<WeatherResult> data = new MutableLiveData<>();

        apiService.getWeatherData(city, appid)
                  .enqueue(
                          new Callback<WeatherResult>() {
                              @Override
                              public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {

                                  if (response.isSuccessful()) {
                                      Log.i(TAG, "onResponse: " + response.body()
                                                                          .toString());
                                      WeatherResult body = response.body();
                                      WeatherResult w = new WeatherResult.Builder().withName(body.getName())
                                                                                   .withWind(new Wind(body.getWind()
                                                                                                          .getSpeed()))
                                                                                   .withMain(new Main(body.getMain()
                                                                                                          .getHumidity(),
                                                                                           body.getMain()
                                                                                               .getPressure(),
                                                                                           body.getMain()
                                                                                               .getTemp()))
                                                                                   .build();
                                      data.setValue(w);
                                  }
                              }

                              @Override
                              public void onFailure(Call<WeatherResult> call, Throwable t) {
                                  t.printStackTrace();
                                  Log.i(TAG, "onFailure: " + t.getMessage());
                              }
                          });
        Log.i(TAG, "getWeatherData: " + data.toString());
        return data;
    }
}
