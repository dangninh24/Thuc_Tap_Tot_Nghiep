package com.example.quanlyquantrasua.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.databinding.CustomTableBinding;
import com.example.quanlyquantrasua.model.TableFood;

import java.util.List;

public class Custom_List_table extends RecyclerView.Adapter<Custom_List_table.MyViewHolder> {

    List<TableFood> list;

    public interface setOnItemClickListener{
        void dosomething(int position);
        void order(int position);
    }

    private setOnItemClickListener itemClickListener;

    public void setItemClickListener(setOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public Custom_List_table(List<TableFood> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_table, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TableFood table = list.get(position);
        holder.binding.setTable(table);
        holder.binding.cardTable.setOnClickListener(view -> {
            itemClickListener.dosomething(position);
        });
        holder.binding.btnOrder.setOnClickListener(view -> {
            itemClickListener.order(position);
        });

    }
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        CustomTableBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = CustomTableBinding.bind(itemView);
        }
    }
}
