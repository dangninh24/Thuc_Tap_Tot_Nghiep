package com.example.quanlyquantrasua.data.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.quanlyquantrasua.model.Bill;
import com.example.quanlyquantrasua.model.BillInfo;

import java.util.List;

public class BillAndBillInfo {
    @Embedded
    public Bill bill;
    @Relation(
            parentColumn = "billID",
            entityColumn = "billID"
    )
    public List<BillInfo> billInfo;

}
