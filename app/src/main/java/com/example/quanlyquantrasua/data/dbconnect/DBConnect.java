package com.example.quanlyquantrasua.data.dbconnect;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.quanlyquantrasua.data.convert.TypeConvert;
import com.example.quanlyquantrasua.data.dao.AccountDAO;
import com.example.quanlyquantrasua.model.Account;

//@TypeConverters({TypeConvert.class})
//@Database(entities = {Account.class}, version = 1)
public abstract class DBConnect extends RoomDatabase {
    public abstract AccountDAO getAccountDAO();
}
