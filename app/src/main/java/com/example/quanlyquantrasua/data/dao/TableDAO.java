package com.example.quanlyquantrasua.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlyquantrasua.model.TableFood;

import java.util.List;

@Dao
public interface TableDAO {
    @Insert
    public void AddTable(TableFood table);

    @Update
    public void UpdateTable(TableFood tableFood);

    @Query("SELECT * FROM TableFood")
    public List<TableFood> getListTable();

    @Query("DELETE FROM tablefood WHERE tableID = :id")
    public void deleteTableByID(int id);

    @Query("SELECT * FROM TableFood WHERE tableID = :id")
    public TableFood getTableByID(int id);
}
