package com.example.quanlyquantrasua.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.quanlyquantrasua.model.Category;
import com.example.quanlyquantrasua.model.Food;

import java.util.List;

public class Custom_List_Spinner_Food extends ArrayAdapter<Food> {
    public Custom_List_Spinner_Food(Context context, List<Food> persons) {
        super(context, android.R.layout.simple_spinner_item, persons);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        Food food = getItem(position);
        textView.setText(food.getName());
        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
        Food food = getItem(position);
        textView.setText(food.getName());
        return textView;
    }
}
