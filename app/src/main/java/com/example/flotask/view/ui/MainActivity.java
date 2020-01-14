package com.example.flotask.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.flotask.R;
import com.example.flotask.model.City;
import com.example.flotask.view.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.RecyclerViewElementClickListener {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private List<City> cityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = new ArrayList<City>();
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
        initRecyclerView();

    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(cityList,this));
    }

    @Override
    public void onRecyclerViewElementClick(int position) {

        startActivity(new Intent(MainActivity.this, WeatherDetails.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                                                         .putExtra("city", cityList.get(position)
                                                                                                   .getCity()));
    }
}
