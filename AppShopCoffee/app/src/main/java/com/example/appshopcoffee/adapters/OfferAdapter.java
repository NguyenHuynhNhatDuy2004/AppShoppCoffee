package com.example.appshopcoffee.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appshopcoffee.R;
import com.example.appshopcoffee.models.OfferItem;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    private List<OfferItem> items;

    public OfferAdapter(List<OfferItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_offer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OfferItem item = items.get(position);
        holder.shapeableImageView.setImageResource(item.getImageRes());
        holder.ratingBar.setRating(item.getRating());
        holder.titleTxt.setText(item.getTitle());
        holder.extraTxt.setText(item.getExtra());
        holder.priceTxt.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView shapeableImageView;
        RatingBar ratingBar;
        TextView titleTxt, extraTxt, priceTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shapeableImageView = itemView.findViewById(R.id.shapeableImageView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            extraTxt = itemView.findViewById(R.id.extraTxt);
            priceTxt = itemView.findViewById(R.id.priceTxt);
        }
    }
}
