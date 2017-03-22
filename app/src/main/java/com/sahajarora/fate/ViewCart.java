package com.sahajarora.fate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewCart extends AppCompatActivity {

    private ListView lvCart;
    private TextView tvTotalPrice;
    private ArrayList<FoodItem> foodItems;
    private FoodItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        foodItems = new ArrayList<FoodItem>();
        foodItems = MainActivity.cart.getFoodItems();

        adapter = new FoodItemAdapter(this, foodItems);

        lvCart = (ListView) findViewById(R.id.lvCart);
        lvCart.setAdapter(adapter);

        tvTotalPrice = (TextView) findViewById(R.id.tvTotalPrice);
        tvTotalPrice.setText(MainActivity.cart.getTotalPriceString());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }



}
