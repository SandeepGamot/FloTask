package com.example.flotask.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flotask.R;
import com.example.flotask.services.model.City;
import com.example.flotask.viewmodel.WeatherViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<City> cities = new ArrayList<>();
    private RecyclerViewElementClickListener elementClickListener;
    private WeatherViewModel viewModel;


    public RecyclerViewAdapter(List<City> cities, RecyclerViewElementClickListener elementClickListener, WeatherViewModel viewModel) {
        this.cities = cities;
        this.elementClickListener = elementClickListener;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.recycler_list_element_layout, parent, false);
        return new ViewHolder(v, this.elementClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.city.setText(cities.get(position)
                                    .getName());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView city;
        RecyclerViewElementClickListener elementClickListener;

        public ViewHolder(@NonNull View itemView, RecyclerViewElementClickListener elementClickListener) {
            super(itemView);
            city = itemView.findViewById(R.id.city_name);
            this.elementClickListener = elementClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            elementClickListener.onRecyclerViewElementClick(getAdapterPosition() , viewModel);
        }

    }

    public interface RecyclerViewElementClickListener {
        void onRecyclerViewElementClick(int position , WeatherViewModel viewModel);
    }
}
