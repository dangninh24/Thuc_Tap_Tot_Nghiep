package com.example.quanlyquantrasua.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlyquantrasua.model.Bill;

import java.util.Date;
import java.util.List;

@Dao
public interface BillDAO {
    @Insert
    public void AddBill(Bill bill);

    @Update
    public void UpdateBill(Bill bill);

    @Query("SELECT * FROM BILL WHERE status = :status")
    public List<Bill> getListBill(boolean status);

    @Query("SELECT * FROM BILL WHERE dateCheckIn >= :dateStart AND dateCheckOut <= :dateEnd AND status = :status")
    public List<Bill> getListBillByDate(Date dateStart, Date dateEnd, boolean status);

    @Query(("SELECT * FROM Bill WHERE status = :status AND tableID = :tableID  "))
    public Bill getBillByTableStatus(boolean status, int tableID);
}
