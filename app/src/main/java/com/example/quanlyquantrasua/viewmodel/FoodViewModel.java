package com.example.quanlyquantrasua.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlyquantrasua.model.Food;

import java.util.List;

public class FoodViewModel extends ViewModel {
    private MutableLiveData<List<Food>> listFood;

    public LiveData<List<Food>> getFood(){
        if(listFood == null) {
            listFood = new MutableLiveData<>();
        }
        return listFood;
    }

    public void LoadData(List<Food> list) {
        listFood.setValue(list);
    }
}
