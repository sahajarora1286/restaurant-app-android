package com.sahajarora.fate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sahajarora1286 on 2015-11-30.
 */
public class FoodItemAdapter extends ArrayAdapter<FoodItem> {
    public FoodItemAdapter(Context context, ArrayList<FoodItem> items){
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        FoodItem item = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.food_item_layout, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);

        tvName.setText(item.getName());
        tvPrice.setText(item.getPriceString());

        return convertView;
    }
}
