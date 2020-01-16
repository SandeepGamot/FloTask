package com.example.flotask.services.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.flotask.services.model.WeatherResult;
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

    public LiveData<WeatherResult> getWeatherData(String city, String appid) {
        MutableLiveData<WeatherResult> weatherResult = new MutableLiveData<>();
        apiService.getWeatherData(city, appid)
                  .enqueue(
                          new Callback<WeatherResult>() {
                              @Override
                              public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {

                                  if (response.isSuccessful()) {
                                      Log.i(TAG, "onResponse: " + response.body()
                                                                          .toString());
                                      weatherResult.setValue(response.body());
                                  }
                              }

                              @Override
                              public void onFailure(Call<WeatherResult> call, Throwable t) {
                                  t.printStackTrace();
                                  Log.d(TAG, "onFailure: " + t.getMessage());
                              }
                          });

        return weatherResult;
    }
}
