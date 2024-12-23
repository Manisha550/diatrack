package com.example.diatrack;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class piechart extends Fragment {

    public piechart() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_piechart, container, false);

        // Initialize PieChart
        PieChart pieChart = view.findViewById(R.id.pieChart);

        // Configure PieChart
        setupPieChart(pieChart);

        return view;
    }

    private void setupPieChart(PieChart pieChart) {
        // Create PieEntries
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40, "Carbs"));
        entries.add(new PieEntry(30, "Proteins"));
        entries.add(new PieEntry(20, "Fats"));
        entries.add(new PieEntry(10, "Other"));

        // Create PieDataSet
        PieDataSet dataSet = new PieDataSet(entries, "Calories");
        dataSet.setColors(new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW});
        dataSet.setValueTextColor(Color.WHITE);
        dataSet.setValueTextSize(12f);

        // Create PieData
        PieData data = new PieData(dataSet);

        // Configure PieChart
        pieChart.setData(data);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Calories Breakdown");
        pieChart.setCenterTextSize(18f);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.invalidate(); // Refresh chart
    }
}
