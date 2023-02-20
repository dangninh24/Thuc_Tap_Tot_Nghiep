package com.example.quanlyquantrasua.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlyquantrasua.model.TableFood;

import java.util.List;

public class TableViewModel extends ViewModel {
    private MutableLiveData<List<TableFood>> listTable;

    public LiveData<List<TableFood>> getTable() {
        if(listTable == null) {
            listTable = new MutableLiveData<>();
        }
        return listTable;
    }

    public void loadTable(List<TableFood> list){
        listTable.setValue(list);
    }

}
