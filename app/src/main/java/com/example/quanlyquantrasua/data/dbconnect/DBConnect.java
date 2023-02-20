package com.example.quanlyquantrasua.data.dbconnect;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.quanlyquantrasua.data.convert.TypeConvert;
import com.example.quanlyquantrasua.data.dao.AccountDAO;
import com.example.quanlyquantrasua.data.dao.BillDAO;
import com.example.quanlyquantrasua.data.dao.BillInfoDAO;
import com.example.quanlyquantrasua.data.dao.CategoryDAO;
import com.example.quanlyquantrasua.data.dao.FoodDAO;
import com.example.quanlyquantrasua.data.dao.TableDAO;
import com.example.quanlyquantrasua.model.Account;
import com.example.quanlyquantrasua.model.Bill;
import com.example.quanlyquantrasua.model.BillInfo;
import com.example.quanlyquantrasua.model.Category;
import com.example.quanlyquantrasua.model.Food;
import com.example.quanlyquantrasua.model.TableFood;

import java.io.Serializable;

@TypeConverters({TypeConvert.class})
@Database(entities = {Account.class, TableFood.class, Food.class, Category.class, Bill.class, BillInfo.class}, version = 1)
public abstract class DBConnect extends RoomDatabase implements Serializable {
    public abstract AccountDAO getAccountDAO();
    public abstract BillDAO getBillDAO();
    public abstract BillInfoDAO getBillInfoDAO();
    public abstract FoodDAO getFoodDAO();
    public abstract TableDAO getTableDAO();
    public abstract CategoryDAO getCategoryDAO();
}
