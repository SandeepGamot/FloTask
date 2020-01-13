package com.example.flotask.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.flotask.R;
import com.example.flotask.model.City;
import com.example.flotask.view.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<City> cityList = new ArrayList<City>();
        cityList.add(new City("Mumbai"));
        cityList.add(new City("Dubai"));
        cityList.add(new City("Pune"));
        cityList.add(new City("Goa"));
        cityList.add(new City("London"));
        cityList.add(new City("New York"));
        cityList.add(new City("Some"));
        cityList.add(new City("Thing"));
        cityList.add(new City("Else"));
        cityList.add(new City("Sandy Boi"));
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(cityList));
    }
}
