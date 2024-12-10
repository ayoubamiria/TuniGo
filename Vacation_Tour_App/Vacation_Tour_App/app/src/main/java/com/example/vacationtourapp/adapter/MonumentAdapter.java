package com.example.vacationtourapp.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vacationtourapp.R;
import com.example.vacationtourapp.model.Monument;

import java.util.List;

public class MonumentAdapter extends RecyclerView.Adapter<MonumentAdapter.MonumentViewHolder> {

    private List<Monument> monumentList;

    // Constructor
    public MonumentAdapter(List<Monument> monumentList) {
        this.monumentList = monumentList;
    }

    @NonNull
    @Override
    public MonumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_monument, parent, false);
        return new MonumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonumentViewHolder holder, int position) {
        Monument monument = monumentList.get(position);
        holder.nameTextView.setText(monument.getName());
        holder.descriptionTextView.setText(monument.getDescription());
        holder.imageView.setImageResource(monument.getImage());
    }

    @Override
    public int getItemCount() {
        return monumentList.size();
    }

    // ViewHolder class to bind the views
    public static class MonumentViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, descriptionTextView;
        ImageView imageView;

        public MonumentViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.monumentName);
            descriptionTextView = itemView.findViewById(R.id.monumentDescription);
            imageView = itemView.findViewById(R.id.monumentImage);
        }
    }
}
