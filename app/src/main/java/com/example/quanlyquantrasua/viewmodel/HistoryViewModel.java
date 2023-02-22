package com.example.quanlyquantrasua.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlyquantrasua.model.Bill;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    private MutableLiveData<List<Bill>> data;

    public LiveData<List<Bill>> getBill(){
        if(data == null) {
            data = new MutableLiveData<>();
        }
        return data;
    }

    public void LoadData(List<Bill> listData) {
        data.setValue(listData);
    }
}
