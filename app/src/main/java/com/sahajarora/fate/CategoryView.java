package com.sahajarora.fate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryView extends AppCompatActivity implements Serializable {

    private ArrayList<FoodItem> foodItems;
    private String categoryName;
    private TextView tvCategoryName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        Intent categoryIntent = getIntent();

        categoryName = (String) categoryIntent.getSerializableExtra("categoryName");

        tvCategoryName = (TextView) findViewById(R.id.tvCategoryName);
        tvCategoryName.setText(categoryName);

        foodItems = new ArrayList<FoodItem>();

        populateFoodItems();

        FoodItemAdapter adapter = new FoodItemAdapter(this, foodItems);



        final ListView lvStarters = (ListView) findViewById(R.id.lvStarters);
        lvStarters.setAdapter(adapter);

        lvStarters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CategoryView.this, SetQuantity.class);
                FoodItem item = (FoodItem) lvStarters.getItemAtPosition(i);
                intent.putExtra("foodItem", item);
                startActivity(intent);
            }
        });


    }

    private void populateFoodItems(){
        switch (categoryName) {
            case "STARTERS":
                populateStarters();
                break;
            case "SOUPS":
                populateSoups();
                break;
            default:
                Toast.makeText(getApplicationContext(), "No items added for this category yet!", Toast.LENGTH_LONG).show();
                break;
        }

    }

    private void populateSoups() {
        foodItems.add(new FoodItem("Chicken & Sweet Corn Soup", "2.80"));
        foodItems.add(new FoodItem("Chicken & Mushroom Soup", "2.80"));
        foodItems.add(new FoodItem("Vegetable Noodle Soup", "2.80"));
        foodItems.add(new FoodItem("Hot & Sour Soup", "3.40"));
        foodItems.add(new FoodItem("Won Ton Soup", "3.40"));
    }

    private void populateStarters() {
        foodItems.clear();
        foodItems.add(new FoodItem("Spring Roll", "2.85"));
        foodItems.add(new FoodItem("Duck Rolls(3)", "3.60"));
        foodItems.add(new FoodItem("Chicken Roll(4)", "3.60"));
        foodItems.add(new FoodItem("Prawn on Toast", "4.90"));
        foodItems.add(new FoodItem("Won Tons with Sweet & Sour Sauce", "3.80"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_cart){
            Intent intent = new Intent(this, ViewCart.class);
            startActivity(intent);
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
