package com.example.quanlyquantrasua.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Bill")
public class Bill {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private int billID;
    private int tableID;
    private Date dateCheckIn;
    private Date dateCheckOut;
    private int totalPrice;
    private boolean status; // Thuộc tính status kiểm tra xem bill đã được thanh toán hay chưa ?

    public Bill(int billID, int tableID, Date dateCheckIn, Date dateCheckOut, int totalPrice, boolean status) {
        this.billID = billID;
        this.tableID = tableID;
        this.dateCheckIn = dateCheckIn;
        this.dateCheckOut = dateCheckOut;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Date getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
