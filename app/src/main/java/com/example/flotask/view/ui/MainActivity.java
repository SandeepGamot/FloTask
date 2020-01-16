package com.example.flotask.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.example.flotask.R;
import com.example.flotask.services.model.City;
import com.example.flotask.view.adapter.RecyclerViewAdapter;
import com.example.flotask.viewmodel.WeatherViewModel;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerViewElementClickListener {

    private RecyclerView recyclerView;
    private List<City> cities;
    private LinearLayoutManager layoutManager;
    private WeatherViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);

        cities = new ArrayList<City>();
        for(String s : getResources().getString(R.string.cities).split(" "))
        {
            cities.add(new City(s));
        }
        initRecyclerView();

    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(cities, this,viewModel));
    }

    @Override
    public void onRecyclerViewElementClick(int position, WeatherViewModel viewModel) {
        String city = cities.get(position).getName();
        viewModel.getWeather(city);
        startActivity(new Intent(MainActivity.this, WeatherDetails.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT).putExtra("city",city));
    }
}
