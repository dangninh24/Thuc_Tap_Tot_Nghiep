package com.example.quanlyquantrasua.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlyquantrasua.model.Category;

import java.util.List;

public class Custom_List_Spinner_Category extends ArrayAdapter<Category> {

    public Custom_List_Spinner_Category(Context context, List<Category> persons) {
        super(context, android.R.layout.simple_spinner_item, persons);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        Category category = getItem(position);
        textView.setText(category.getCategoryName());
        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
        Category category = getItem(position);
        textView.setText(category.getCategoryName());
        return textView;
    }
}
