package com.example.quanlyquantrasua.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.databinding.CustomFoodMenuBinding;

import java.util.List;

public class Custom_List_Food_Menu extends RecyclerView.Adapter<Custom_List_Food_Menu.Myholder> {
    List<Food> list_food;

    public void setItemClickListener(setOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    setOnItemClickListener itemClickListener;

    public interface setOnItemClickListener {
        void dosomething(boolean check, int position, Food food);
    }


    public Custom_List_Food_Menu(List<Food> list_food) {
        this.list_food = list_food;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_food_menu, parent, false);
        return new Myholder(view);
    }

    @Override
    public int getItemCount() {
        return list_food.size();
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        Food food = list_food.get(position);
        holder.binding.setFood(food);
        holder.binding.switchFood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                itemClickListener.dosomething(b, position, food);
            }
        });

    }

    public class Myholder extends RecyclerView.ViewHolder {
        CustomFoodMenuBinding binding;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            binding = CustomFoodMenuBinding.bind(itemView);
        }
    }
}
