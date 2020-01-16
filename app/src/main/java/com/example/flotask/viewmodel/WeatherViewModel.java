package com.example.flotask.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.flotask.services.model.WeatherResult;
import com.example.flotask.services.repository.WeatherRepository;

public class WeatherViewModel extends ViewModel
{
    private String TAG = this.getClass().getSimpleName();

    private String APP_ID = "2abcb389368f079ecc5b790b5485b268";

    public LiveData<WeatherResult> getWeather(String city)
    {
        return WeatherRepository.getInstance().getWeatherData(city,APP_ID);
    }

}
