package com.example.quanlyquantrasua.data.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.quanlyquantrasua.model.BillInfo;
import com.example.quanlyquantrasua.model.Food;

public class FoodAndBillInfo {
    @Embedded
    public Food food;
    @Relation(
            parentColumn = "foodID",
            entityColumn = "foodID"
    )
    public BillInfo billInfo;
}
