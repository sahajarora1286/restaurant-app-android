package com.sahajarora.fate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;

public class OrderActivity extends AppCompatActivity implements Serializable {
    private String[] categories = {"STARTERS", "SOUPS", "HEALTHY LIGHT NEW DISHES", "EXOTIC FRESH SEAFOOD", "FRUITY & LIGHT DISHES", "FRESH ROAST DUCK",
            "ALL TIME FAVOURITE CHINESE DISHES", "FRIED RICE & CHOWMEIN", "SIDE ORDERS", "EXTRA VALUE MEALS WITH UNLIMITED CHOICES"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.layout_category_list_item, categories);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String itemValue = (String) listView.getItemAtPosition(i);
                startActivity(new Intent(OrderActivity.this, CategoryView.class).putExtra("categoryName", itemValue));

            }
        });


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
