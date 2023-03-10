package com.example.quanlyquantrasua.data.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.quanlyquantrasua.model.Bill;
import com.example.quanlyquantrasua.model.TableFood;

import java.util.List;

public class TableAndBill {
    @Embedded
    public TableFood table;
    @Relation(
            parentColumn = "tableID",
            entityColumn = "tableID"
    )
    public List<Bill> bill;
}
