package com.example.quanlyquantrasua.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TableFood")
public class TableFood {
    @PrimaryKey(autoGenerate = true)
    public int tableID;
    public String name;
    public boolean status; // Thuộc tính status kiểm tra bàn có trống hay không ?

    public TableFood(){

    }

    public TableFood(int id, String name, boolean status) {
        this.tableID = id;
        this.name = name;
        this.status = status;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
