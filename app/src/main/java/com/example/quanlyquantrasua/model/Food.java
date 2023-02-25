package com.example.quanlyquantrasua.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Food")
public class Food {

    @PrimaryKey(autoGenerate = true)
    private int foodID;
    private int categoryID;
    private int image;
    private String name;
    private int price;
    private boolean status; // Thuộc tính status để xác định xem món có được mở để order hay không ?

    public Food(int foodID, int categoryID, int image, String name, int price, boolean status) {
        this.foodID = foodID;
        this.image = image;
        this.name = name;
        this.price = price;
        this.status = status;
        this.categoryID = categoryID;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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
