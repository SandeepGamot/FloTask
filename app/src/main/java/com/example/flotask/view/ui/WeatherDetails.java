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

    WeatherViewModel viewModel;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_details);

        textView = findViewById(R.id.weather_info_text);
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getCityDetails().observe(this, new Observer<WeatherResult>() {
            @Override
            public void onChanged(WeatherResult weatherResult) {
                textView.setText(weatherResult.toString());
            }
        });
    }
}

