package com.example.quanlyquantrasua.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Food")
public class Food {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    private int foodID;
    private int categoryID;
    private int image;
    private String name;
    private int price;
    private boolean status;

    public Food(int foodID, int image, String name, int price, boolean status) {
        this.foodID = foodID;
        this.image = image;
        this.name = name;
        this.price = price;
        this.status = status;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
