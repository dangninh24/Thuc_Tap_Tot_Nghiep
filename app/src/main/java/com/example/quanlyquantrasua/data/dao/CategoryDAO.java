package com.example.quanlyquantrasua.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quanlyquantrasua.model.Category;

import java.util.List;

@Dao
public interface CategoryDAO {

    @Insert
    public void AddCategory(Category category);

    @Query("SELECT * FROM category")
    public List<Category> getListCategory();

    @Query("SELECT * FROM Category WHERE categoryName =:categoryName")
    public Category getCategoryByName(String categoryName);

    @Query("DELETE FROM Category WHERE categoryID = :categoryID")
    public void deleteCategoryByID(int categoryID);
}
