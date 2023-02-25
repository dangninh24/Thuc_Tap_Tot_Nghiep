package com.example.quanlyquantrasua.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.quanlyquantrasua.model.Food;
import com.example.quanlyquantrasua.model.TableFood;

import java.util.List;

public class Custom_List_Spinner_Table extends ArrayAdapter<TableFood> {
    public Custom_List_Spinner_Table(Context context, List<TableFood> persons) {
        super(context, android.R.layout.simple_spinner_item, persons);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        TableFood food = getItem(position);
        textView.setText(food.getName());
        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
        TableFood food = getItem(position);
        textView.setText(food.getName());
        return textView;
    }
}
