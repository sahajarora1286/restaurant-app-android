package com.sahajarora.fate;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SetQuantity extends AppCompatActivity {
    private TextView tvName;
    private Button btnIncrement, btnDecrement, btnAddToCart;
    private TextView tvQuantity;
    private int quantity;


    public SetQuantity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_quantity);

        Intent i = getIntent();

        final FoodItem foodItem = (FoodItem) i.getSerializableExtra("foodItem");


        tvName = (TextView) findViewById(R.id.tvItemName);
        tvName.setText(foodItem.getName());

        btnIncrement = (Button) findViewById(R.id.btnIncrement);
        btnDecrement = (Button) findViewById(R.id.btnDecrement);
        btnAddToCart = (Button) findViewById(R.id.btnAddToCart);
        tvQuantity = (TextView) findViewById(R.id.tvQuantity);
        quantity = Integer.parseInt(tvQuantity.getText().toString());

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(tvQuantity.getText().toString());
                tvQuantity.setText(String.valueOf(quantity+1));
                quantity++;
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(tvQuantity.getText().toString());
                if (quantity > 0) {
                    tvQuantity.setText(String.valueOf(quantity - 1));
                    quantity--;
                }

            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity>0) {
                    MainActivity.cart.addItem(foodItem, quantity);
                    finish();

                    Toast.makeText(getApplicationContext(), "Item added to cart!", Toast.LENGTH_LONG).show();
                }   else {
                    Toast.makeText(getApplicationContext(), "Please set the quantity!", Toast.LENGTH_LONG).show();
                }
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
