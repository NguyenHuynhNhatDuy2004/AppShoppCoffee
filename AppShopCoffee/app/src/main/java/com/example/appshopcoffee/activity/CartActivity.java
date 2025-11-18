package com.example.appshopcoffee.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appshopcoffee.R;
import com.example.appshopcoffee.adapters.CartAdapter;
import com.example.appshopcoffee.models.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private RecyclerView rvCartView;
    private ImageView ivBack;
    private EditText etCoupen;
    private Button applyBtn, proceedCheckoutBtn;
    private TextView subTotalTxt, subTotalPriceTxt, delivery, deliveryPriceTxt, totalTax, totalTaxPriceTxt, total, totalPriceTxt;

    private CartAdapter cartAdapter;
    private List<CartItem> cartItems = new ArrayList<>();
    private double subTotal = 0, deliveryFee = 2.99, tax = 0.08, totalAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initViews();
        setupRecyclerView();
        loadDummyCartData();
        updateTotals();
        setupClicks();
    }

    private void initViews() {
        rvCartView = findViewById(R.id.rvCartView);
        ivBack = findViewById(R.id.ivBack);
        etCoupen = findViewById(R.id.etCoupen);
        applyBtn = findViewById(R.id.applyBtn);
        proceedCheckoutBtn = findViewById(R.id.proceedCheckoutBtn);
        subTotalTxt = findViewById(R.id.subTotalTxt);
        subTotalPriceTxt = findViewById(R.id.subTotalPriceTxt);
        delivery = findViewById(R.id.delivery);
        deliveryPriceTxt = findViewById(R.id.deliveryPriceTxt);
        totalTax = findViewById(R.id.totalTax);
        totalTaxPriceTxt = findViewById(R.id.totalTaxPriceTxt);
        total = findViewById(R.id.total);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
    }

    private void setupRecyclerView() {
        rvCartView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(cartItems, (item, newQuantity) -> {
            // Update subtotal on quantity change
            updateTotals();
        });
        rvCartView.setAdapter(cartAdapter);
    }

    private void loadDummyCartData() {
        cartItems.add(new CartItem("Espresso", "$4.99", "$9.98", 2, R.drawable.coffee));
        cartItems.add(new CartItem("Latte", "$5.49", "$5.49", 1, R.drawable.coffee));
        cartAdapter.notifyDataSetChanged();
    }

    private void updateTotals() {
        subTotal = 0;
        for (CartItem item : cartItems) {
            // Parse price and multiply by quantity
            double price = Double.parseDouble(item.getPricePerItem().replace("$", ""));
            subTotal += price * item.getQuantity();
        }
        double taxAmount = subTotal * 0.08;
        totalAmount = subTotal + deliveryFee + taxAmount;

        subTotalPriceTxt.setText("$" + String.format("%.2f", subTotal));
        deliveryPriceTxt.setText("$" + deliveryFee);
        totalTaxPriceTxt.setText("$" + String.format("%.2f", taxAmount));
        totalPriceTxt.setText("$" + String.format("%.2f", totalAmount));
    }

    private void setupClicks() {
        ivBack.setOnClickListener(v -> finish());

        applyBtn.setOnClickListener(v -> {
            String coupon = etCoupen.getText().toString();
            if (!coupon.isEmpty()) {
                // Apply coupon logic, e.g., discount
                subTotal *= 0.9; // 10% off dummy
                updateTotals();
            }
        });

        proceedCheckoutBtn.setOnClickListener(v -> {
            // Navigate to checkout
        });
    }
}
