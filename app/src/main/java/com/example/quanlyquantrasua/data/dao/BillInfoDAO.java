package com.example.quanlyquantrasua.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlyquantrasua.data.relationship.FoodAndBillInfo;
import com.example.quanlyquantrasua.model.BillInfo;

import java.util.List;

@Dao
public interface BillInfoDAO {
    @Insert
    public void AddBillInfo(BillInfo billInfo);

    @Update
    public void UpdateBillInfo(BillInfo billInfo);

    @Query("SELECT * FROM BillInfo AS B JOIN Food AS F WHERE billID = :billID AND F.foodID = B.foodID")
    public List<FoodAndBillInfo> getListFoodAndBillInfoByBillID(int billID);

    @Query("SELECT * FROM BillInfo WHERE foodID = :foodID AND billID = :billID")
    public BillInfo getListBillInfoByFoodID(int billID, int foodID);
}
