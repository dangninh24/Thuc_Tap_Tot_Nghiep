package com.example.quanlyquantrasua.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quanlyquantrasua.model.TableFood;

import java.util.List;

@Dao
public interface TableDAO {
    @Insert
    public void AddTable(TableFood table);

    @Query("SELECT * FROM TableFood")
    public List<TableFood> getListTable();

    @Query("DELETE FROM tablefood WHERE tableID = :id")
    public void deleteTableByID(int id);
}
