package com.example.quanlyquantrasua.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.databinding.CustomFoodOrderBinding;
import com.example.quanlyquantrasua.model.Food;

import java.util.List;

public class Custom_List_Food_Order extends  RecyclerView.Adapter<Custom_List_Food_Order.MyViewHoldels> {

    public interface ItemClickListener {
        void DoSomething(int position);
        void PlusCount(CustomFoodOrderBinding binding, int position);
        void MinusCount(CustomFoodOrderBinding binding,int position);
        void SelectCount(CustomFoodOrderBinding binding,int position);
    }

    ItemClickListener itemClickListener;

    List<Food> foodList;

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public Custom_List_Food_Order(List<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public MyViewHoldels onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_food_order, parent, false);
        return new MyViewHoldels(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoldels holder, int position) {
        Food food = foodList.get(position);
        holder.binding.txtFoodName.setText(food.getName());
        holder.binding.etxtFoodCount.setText("0");

        holder.binding.btnMinusFood.setOnClickListener(views -> {
            itemClickListener.MinusCount(holder.binding, position);
        });

        holder.binding.btnPlusFood.setOnClickListener(views -> {
            itemClickListener.PlusCount(holder.binding,position);
        });

        holder.binding.btnSelect.setOnClickListener(views -> {
            itemClickListener.SelectCount(holder.binding, position);
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHoldels extends RecyclerView.ViewHolder{
        CustomFoodOrderBinding binding;
        public MyViewHoldels(@NonNull View itemView) {
            super(itemView);
            binding = CustomFoodOrderBinding.bind(itemView);
        }
    }
}
