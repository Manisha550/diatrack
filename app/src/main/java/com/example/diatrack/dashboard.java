package com.example.diatrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import android.graphics.Color;

import java.util.ArrayList;

public class DashboardActivity<LineDataSet> extends AppCompatActivity {

    private PieChart pieChart;
    private LineChart lineChartGlucose, lineChartWeight;
    private TextView greetingMessage;
    private Button chatButton, aiAssistantButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize UI components
        greetingMessage = findViewById(R.id.greetingMessage);
        chatButton = findViewById(R.id.chatButton);
        aiAssistantButton = findViewById(R.id.aiAssistantButton);
        pieChart = findViewById(R.id.pieChart);
        lineChartGlucose = findViewById(R.id.lineChartGlucose);
        lineChartWeight = findViewById(R.id.lineChartWeight);

        setupPieChart();
        setupLineChart(lineChartGlucose, "Glucose Levels");
        setupLineChart(lineChartWeight, "Weight Tracking");

        // Set click listeners
        chatButton.setOnClickListener(view -> {
            // Handle chat button click
        });

        aiAssistantButton.setOnClickListener(view -> {
            // Handle AI Assistant button click
        });
    }

    private void setupPieChart() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40f, "Carbs"));
        entries.add(new PieEntry(30f, "Protein"));
        entries.add(new PieEntry(30f, "Fat"));

        PieDataSet dataSet = new PieDataSet(entries, "Calorie Breakdown");
        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();
    }

    private void setupLineChart(LineChart chart, String label) {
        ArrayList<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            entries.add(new Entry(i, (float) (Math.random() * 100)));
        }

        LineDataSet dataSet = new LineDataSet(entries, label);
        LineData data = new LineData(dataSet);
        chart.setData(data);
        chart.invalidate();
    }
}
