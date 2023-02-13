package com.example.quanlyquantrasua.model;

public class Food {
    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private String name;
    private int price;
    private boolean status;
    private boolean check;

    public Food(int image, String name, int price, boolean status, boolean check) {
        this.check = check;
        this.image = image;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
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
