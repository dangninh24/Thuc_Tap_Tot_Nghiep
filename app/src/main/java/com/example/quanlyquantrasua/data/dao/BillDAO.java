package com.example.quanlyquantrasua.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quanlyquantrasua.model.Bill;

import java.util.List;

@Dao
public interface BillDAO {
    @Insert
    public void AddBill(Bill bill);

    @Query("SELECT * FROM BILL WHERE status = :status")
    public List<Bill> getListBill(boolean status);
}
