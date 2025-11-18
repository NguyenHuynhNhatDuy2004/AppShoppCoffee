package com.example.appshopcoffee.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appshopcoffee.R;
import com.example.appshopcoffee.models.SizeItem;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder> {
    private List<SizeItem> sizes;
    private OnSizeClickListener listener;

    public interface OnSizeClickListener {
        void onSizeClick(SizeItem size);
    }

    public SizeAdapter(List<SizeItem> sizes, OnSizeClickListener listener) {
        this.sizes = sizes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_size, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SizeItem size = sizes.get(position);
        holder.coffee.setImageResource(size.getImageRes());
        // Add TextView for size name if needed
        holder.itemView.setOnClickListener(v -> listener.onSizeClick(size));
    }

    @Override
    public int getItemCount() {
        return sizes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView coffee;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coffee = itemView.findViewById(R.id.coffee);
        }
    }
}
