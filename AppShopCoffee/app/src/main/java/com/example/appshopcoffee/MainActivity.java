package com.example.appshopcoffee;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appshopcoffee.R;
import com.example.appshopcoffee.adapters.CategoryAdapter;
import com.example.appshopcoffee.adapters.OfferAdapter;
import com.example.appshopcoffee.adapters.PopularAdapter;
import com.example.appshopcoffee.models.Category;
import com.example.appshopcoffee.models.OfferItem;
import com.example.appshopcoffee.models.PopularItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCategory, recyclerViewPopular, recyclerViewOffer;
    private ProgressBar progressBarCategory, progressBarPopular, progressBarOffer;
    private EditText editTextText;
    private FloatingActionButton cartBtn;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupRecyclerViews();
        setupBottomNav();
        setupCartBtn();

        // Dummy data
        loadDummyData();
    }

    private void initViews() {
        recyclerViewCategory = findViewById(R.id.recyclerViewCategory);
        recyclerViewPopular = findViewById(R.id.recyclerViewPopular);
        recyclerViewOffer = findViewById(R.id.recyclerViewOffer);
        progressBarCategory = findViewById(R.id.progressBarCategory);
        progressBarPopular = findViewById(R.id.progressBarPopular);
        progressBarOffer = findViewById(R.id.progressBarOffer);
        editTextText = findViewById(R.id.editTextText);
        cartBtn = findViewById(R.id.cartBtn);
        bottomNavigation = findViewById(R.id.bottom_navigation);
    }

    private void setupRecyclerViews() {
        // Categories (horizontal)
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // Popular (horizontal)
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // Offers (horizontal)
        recyclerViewOffer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void setupBottomNav() {
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle nav clicks
                return true;
            }
        });
    }

    private void setupCartBtn() {
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to CartActivity
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadDummyData() {
        // Categories
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Espresso"));
        categories.add(new Category("Latte"));
        categories.add(new Category("Cappuccino"));
        recyclerViewCategory.setAdapter(new CategoryAdapter(categories));
        progressBarCategory.setVisibility(View.GONE);

        // Popular
        List<PopularItem> popularItems = new ArrayList<>();
        popularItems.add(new PopularItem("Hot Coffee", "$4.99", R.drawable.coffee)); // Assume drawable
        popularItems.add(new PopularItem("Iced Latte", "$5.49", R.drawable.coffee));
        recyclerViewPopular.setAdapter(new PopularAdapter(popularItems));
        progressBarPopular.setVisibility(View.GONE);

        // Offers
        List<OfferItem> offerItems = new ArrayList<>();
        offerItems.add(new OfferItem("Special Brew", "Limited Time", "$3.99", 4.5f, R.drawable.coffee));
        offerItems.add(new OfferItem("Morning Deal", "Buy 1 Get 1", "$4.50", 4.0f, R.drawable.coffee));
        recyclerViewOffer.setAdapter(new OfferAdapter(offerItems));
        progressBarOffer.setVisibility(View.GONE);
    }
}