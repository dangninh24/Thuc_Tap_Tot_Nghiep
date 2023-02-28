package com.example.quanlyquantrasua.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlyquantrasua.model.Food;

import java.util.List;

@Dao
public interface FoodDAO {
    @Insert
    public void AddFood(Food food);
    @Update
    public void UpdateFood(Food food);

    @Query("SELECT * FROM Food")
    public List<Food> getListFood();

    @Query("DELETE FROM Food WHERE foodID = :id")
    public void deleteFoodByID(int id);

    @Query("DELETE FROM Food WHERE categoryID = :id")
    public void deleteFoodByCategoryID(int id);

    @Query("UPDATE Food SET status = :status WHERE foodID = :foodId")
    public void updateFoodByStatus(boolean status, int foodId);

    @Query("SELECT * FROM Food WHERE status = :status")
    public List<Food> getListFoodByStatus(boolean status);
}
