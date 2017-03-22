package com.sahajarora.fate;

import java.util.ArrayList;

/**
 * Created by sahajarora1286 on 2015-12-02.
 */
public class Cart {
    private ArrayList<FoodItem> foodItems;

    public Cart(){
        foodItems = new ArrayList<FoodItem>();
    }

    public void addItem(FoodItem item, int quantity){
        if (quantity > 0)
        for (int i = 0; i < quantity; i++){
            foodItems.add(item);
        }
    }

    public void removeItem(FoodItem item){
        if (foodItems.contains(item)){
            foodItems.remove(item);
        }
    }

    public ArrayList<FoodItem> getFoodItems(){
        return foodItems;
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (FoodItem item: foodItems){
            totalPrice += item.getPriceValue();
        }
        return totalPrice;
    }

    public String getTotalPriceString(){
        String t = "€";
        t+= getTotalPrice();
        return t;
    }
}
