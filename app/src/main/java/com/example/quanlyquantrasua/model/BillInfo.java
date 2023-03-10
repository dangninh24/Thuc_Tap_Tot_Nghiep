package com.example.quanlyquantrasua.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BillInfo")
public class BillInfo {
    @PrimaryKey(autoGenerate = true)
    private int billInfoID;
    private int billID;
    private int foodID;
    private int count;

    public BillInfo(int billInfoID, int billID, int foodID, int count) {
        this.billInfoID = billInfoID;
        this.foodID = foodID;
        this.count = count;
        this.billID = billID;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getBillInfoID() {
        return billInfoID;
    }

    public void setBillInfoID(int billInfoID) {
        this.billInfoID = billInfoID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
