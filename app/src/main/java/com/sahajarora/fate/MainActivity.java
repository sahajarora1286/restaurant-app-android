package com.sahajarora.fate;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnOrder, btnLocate, btnContact, btnAbout;
    public static Cart cart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cart = new Cart();

        btnOrder = (Button) findViewById(R.id.btnOrder);
        btnLocate = (Button) findViewById(R.id.btnLocate);
        btnContact = (Button) findViewById(R.id.btnContact);
        btnAbout = (Button) findViewById(R.id.btnAbout);
    }


    public void displayOrderActivity(View view){
        Intent i = new Intent(this, OrderActivity.class);
        startActivity(i);
    }

    public void displayContactActivity(View view){
        Intent i = new Intent(this, ContactActivity.class);
        startActivity(i);
    }

    public void displayAboutActivity(View view){
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
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
            Intent intent = new Intent(MainActivity.this, ViewCart.class);
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
