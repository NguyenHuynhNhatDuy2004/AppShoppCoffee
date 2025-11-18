package com.example.appshopcoffee.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appshopcoffee.R;
import com.example.appshopcoffee.adapters.SizeAdapter;
import com.example.appshopcoffee.models.ProductDetail;
import com.example.appshopcoffee.models.SizeItem;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {
    private ShapeableImageView shapeableImageView;
    private ImageView ivBack, ivFavourite;
    private TextView titleTxt, priceTxt, descriptionTxt, numberItemTxt, minusCart, plusCart;
    private RatingBar ratingBar;
    private RecyclerView rvSizeList;
    private Button addToCart;

    private ProductDetail product;
    private SizeAdapter sizeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        initViews();
        loadProductData(); // Assume passed via Intent or dummy
        setupQuantity();
        setupSizes();
        setupClicks();
    }

    private void initViews() {
        shapeableImageView = findViewById(R.id.shapeableImageView);
        ivBack = findViewById(R.id.ivBack);
        ivFavourite = findViewById(R.id.ivFavourite);
        titleTxt = findViewById(R.id.titleTxt);
        priceTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        ratingBar = findViewById(R.id.ratingBar);
        rvSizeList = findViewById(R.id.rvSizeList);
        numberItemTxt = findViewById(R.id.numberItemTxt);
        minusCart = findViewById(R.id.minusCart);
        plusCart = findViewById(R.id.plusCart);
        addToCart = findViewById(R.id.addToCart);
    }

    private void loadProductData() {
        // Dummy data
        product = new ProductDetail("Espresso", "$4.99", "A strong black coffee.", 4.5f, R.drawable.coffee);
        shapeableImageView.setImageResource(product.getImageRes());
        titleTxt.setText(product.getTitle());
        priceTxt.setText(product.getPrice());
        descriptionTxt.setText(product.getDescription());
        ratingBar.setRating(product.getRating());
        numberItemTxt.setText(String.valueOf(product.getQuantity()));
    }

    private void setupQuantity() {
        minusCart.setOnClickListener(v -> {
            int qty = Math.max(1, product.getQuantity() - 1);
            product.setQuantity(qty);
            numberItemTxt.setText(String.valueOf(qty));
        });

        plusCart.setOnClickListener(v -> {
            int qty = product.getQuantity() + 1;
            product.setQuantity(qty);
            numberItemTxt.setText(String.valueOf(qty));
        });
    }

    private void setupSizes() {
        rvSizeList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        List<SizeItem> sizes = new ArrayList<>();
        sizes.add(new SizeItem(R.drawable.coffee, "Small"));
        sizes.add(new SizeItem(R.drawable.coffee, "Medium"));
        sizes.add(new SizeItem(R.drawable.coffee, "Large"));
        sizeAdapter = new SizeAdapter(sizes, sizeItem -> {
            // Handle size selection
        });
        rvSizeList.setAdapter(sizeAdapter);
    }

    private void setupClicks() {
        ivBack.setOnClickListener(v -> finish());

        ivFavourite.setOnClickListener(v -> {
            // Toggle favorite
        });

        addToCart.setOnClickListener(v -> {
            // Add to cart logic, e.g., navigate to CartActivity
        });
    }
}
