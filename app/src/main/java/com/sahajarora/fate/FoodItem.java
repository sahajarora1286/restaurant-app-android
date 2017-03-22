package com.sahajarora.fate;

import java.io.Serializable;

/**
 * Created by sahajarora1286 on 2015-11-30.
 */
public class FoodItem implements Serializable{
    private String name;
    private String price;

    public FoodItem(String name,String price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPriceValue(){
        return Double.parseDouble(price);
    }

    public String getPriceString(){
        String t = "€" + price;
        return t;
    }
}
