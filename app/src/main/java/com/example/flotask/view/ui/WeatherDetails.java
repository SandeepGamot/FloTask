package com.example.flotask.view.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.flotask.R;
import com.example.flotask.services.model.WeatherResult;
import com.example.flotask.viewmodel.WeatherViewModel;

public class WeatherDetails extends AppCompatActivity {

    private WeatherViewModel viewModel;
    private TextView name,temp,pressure,humidity,wind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_details);

        name = findViewById(R.id.details_city_name);
        temp = findViewById(R.id.details_temperature);
        pressure= findViewById(R.id.details_pressure);
        humidity = findViewById(R.id.details_humidity);
        wind = findViewById(R.id.details_wind_speed);
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);

        String t = getResources().getString(R.string.temperature);
        String p = getResources().getString(R.string.pressure);
        String h = getResources().getString(R.string.humidity);
        String w = getResources().getString(R.string.wind_speed);

        viewModel.getWeather(getIntent().getStringExtra("city")).observe(this, new Observer<WeatherResult>() {
            @Override
            public void onChanged(WeatherResult weatherResult) {
                    name.setText(weatherResult.getName());
                    temp.setText(t.replace("%s",weatherResult.getMain().getTemp()));
                    pressure.setText(p.replace("%s",weatherResult.getMain().getPressure()));
                    humidity.setText(h.replace("%s",weatherResult.getMain().getHumidity()));
                    wind.setText(w.replace("%s",weatherResult.getWind().getSpeed()));
            }
        });
    }
}

