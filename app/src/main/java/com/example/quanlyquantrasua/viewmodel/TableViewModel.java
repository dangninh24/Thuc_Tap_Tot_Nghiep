package com.example.quanlyquantrasua.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlyquantrasua.model.Table;

import java.util.List;

public class TableViewModel extends ViewModel {
    private MutableLiveData<List<Table>> listTable;

    public LiveData<List<Table>> getTable() {
        if(listTable == null) {
            listTable = new MutableLiveData<>();
        }
        return listTable;
    }

    public void loadTable(List<Table> list){
        listTable.setValue(list);
    }

}
