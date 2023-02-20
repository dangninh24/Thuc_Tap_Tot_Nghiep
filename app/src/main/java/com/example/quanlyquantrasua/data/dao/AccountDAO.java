package com.example.quanlyquantrasua.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quanlyquantrasua.model.Account;

@Dao
public interface AccountDAO {
    @Insert
    public void AddAccount(Account account);

    @Query("SELECT * FROM Account WHERE usedName = :username AND password = :pass")
    public Account getAccountByUserNameAndPass(String username, String pass);
}
