package com.example.quanlyquantrasua.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.data.relationship.FoodAndBillInfo;
import com.example.quanlyquantrasua.databinding.CustomListFoodPayBinding;

import java.util.List;

public class Custom_List_Food_Pay extends RecyclerView.Adapter<Custom_List_Food_Pay.MyHolder> {

    private List<FoodAndBillInfo> list;

    public Custom_List_Food_Pay(List<FoodAndBillInfo> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_food_pay, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        FoodAndBillInfo foodAndBillInfo = list.get(position);
        holder.binding.txtFoodCount.setText(String.valueOf(foodAndBillInfo.billInfo.getCount()));
        holder.binding.txtFoodName.setText(foodAndBillInfo.food.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CustomListFoodPayBinding binding;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomListFoodPayBinding.bind(itemView);
        }
    }
}
