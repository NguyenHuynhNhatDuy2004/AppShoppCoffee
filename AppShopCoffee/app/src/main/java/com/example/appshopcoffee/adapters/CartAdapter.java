package com.example.appshopcoffee.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appshopcoffee.R;
import com.example.appshopcoffee.models.CartItem;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CartItem> cartItems;
    private OnQuantityChangeListener listener;

    public interface OnQuantityChangeListener {
        void onQuantityChange(CartItem item, int newQuantity);
    }

    public CartAdapter(List<CartItem> cartItems, OnQuantityChangeListener listener) {
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem item = cartItems.get(position);
        holder.cartPicture.setImageResource(item.getImageRes());
        holder.titleTxt.setText(item.getTitle());
        holder.feeEachItem.setText(item.getPricePerItem());
        holder.totalEachItem.setText(item.getTotalPrice());
        holder.numberItemTxt.setText(String.valueOf(item.getQuantity()));

        holder.minusCartBtn.setOnClickListener(v -> {
            int newQty = Math.max(1, item.getQuantity() - 1);
            item.setQuantity(newQty);
            holder.numberItemTxt.setText(String.valueOf(newQty));
            // Update total price logic here if needed
            listener.onQuantityChange(item, newQty);
        });

        holder.plusCartBtn.setOnClickListener(v -> {
            int newQty = item.getQuantity() + 1;
            item.setQuantity(newQty);
            holder.numberItemTxt.setText(String.valueOf(newQty));
            // Update total price logic here if needed
            listener.onQuantityChange(item, newQty);
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView cartPicture;
        TextView titleTxt, feeEachItem, totalEachItem, numberItemTxt, minusCartBtn, plusCartBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartPicture = itemView.findViewById(R.id.cartPicture);
            titleTxt = itemView.findViewById(R.id.titleTxt);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            numberItemTxt = itemView.findViewById(R.id.numberItemTxt);
            minusCartBtn = itemView.findViewById(R.id.minusCartBtn);
            plusCartBtn = itemView.findViewById(R.id.plusCartBtn);
        }
    }
}
