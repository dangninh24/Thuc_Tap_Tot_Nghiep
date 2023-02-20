package com.example.quanlyquantrasua.data.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.quanlyquantrasua.model.Category;
import com.example.quanlyquantrasua.model.Food;

public class CategoryAndFood {
    @Embedded
    public Category category;
    @Relation(
            parentColumn = "categoryID",
            entityColumn = "categoryID"
    )
    public Food food;
}
