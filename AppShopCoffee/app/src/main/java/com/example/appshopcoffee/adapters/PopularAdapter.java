package com.example.appshopcoffee.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appshopcoffee.R;
import com.example.appshopcoffee.models.PopularItem;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private List<PopularItem> items;

    public PopularAdapter(List<PopularItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopularItem item = items.get(position);
        holder.shapeableImageView.setImageResource(item.getImageRes());
        holder.titleTxt.setText(item.getTitle());
        holder.priceTxt.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;
        TextView titleTxt, priceTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.shapeableImageView);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
        }
    }
}
