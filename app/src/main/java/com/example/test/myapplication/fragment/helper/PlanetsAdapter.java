package com.example.test.myapplication.fragment.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.myapplication.R;

import java.util.ArrayList;

/**
 * Created by itdept on 10/7/2017.
 */

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.PlanetsViewHolder> {

    ArrayList<String> planetList;

    public PlanetsAdapter(ArrayList<String> planetList, Context context) {
        this.planetList = planetList;
    }

    @Override
    public PlanetsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.month_row, parent, false);
        PlanetsViewHolder viewHolder = new PlanetsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlanetsViewHolder holder, int position) {
        holder.text.setText(planetList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public static class PlanetsViewHolder extends RecyclerView.ViewHolder {

        protected TextView text;

        public PlanetsViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.text);
        }
    }


    public static final ArrayList<String> getPlanets(){
        ArrayList<String> planets = new ArrayList<String>();
        planets.add("January");
        planets.add("February");
        planets.add("March");
        planets.add("April");
        planets.add("May");
        planets.add("June");
        planets.add("July");
        planets.add("August");
        planets.add("September");
        planets.add("October");
        planets.add("November");
        planets.add("December");
        return planets;
    }
}
