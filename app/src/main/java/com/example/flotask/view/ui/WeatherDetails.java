package com.example.flotask.view.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.flotask.R;

public class WeatherDetails extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_details);
        textView = findViewById(R.id.weather_info_text);
        textView.setText(getIntent().getStringExtra("city"));
        textView.setTextSize(35);
    }
}
