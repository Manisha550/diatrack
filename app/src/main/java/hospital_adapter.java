package com.example.diabiotrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diatrack.R;

import java.util.List;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder> {

    private final List<String> hospitalList;
    private final OnHospitalClickListener listener;

    public interface OnHospitalClickListener {
        void onHospitalClick(String hospitalName);
    }

    public HospitalAdapter(List<String> hospitalList, OnHospitalClickListener listener) {
        this.hospitalList = hospitalList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use a simple layout for list items (custom layout can be used if needed)
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new HospitalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalViewHolder holder, int position) {
        String hospitalName = hospitalList.get(position);
        holder.hospitalNameTextView.setText(hospitalName);

        // Set the item click listener
        holder.itemView.setOnClickListener(v -> listener.onHospitalClick(hospitalName));
    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    static class HospitalViewHolder extends RecyclerView.ViewHolder {
        TextView hospitalNameTextView;

        public HospitalViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalNameTextView = itemView.findViewById(android.R.id.text1); // Using default text1 view for simplicity
        }
    }
}
