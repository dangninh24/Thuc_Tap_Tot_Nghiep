package com.example.quanlyquantrasua.custom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.data.relationship.TableAndBill;
import com.example.quanlyquantrasua.databinding.CustomItemHistoryStatisticalBinding;
import com.example.quanlyquantrasua.model.Bill;

import java.util.Date;
import java.util.List;

public class Custom_List_History_Statistical extends  RecyclerView.Adapter<Custom_List_History_Statistical.Myholders> {

    List<Bill> list;

    public Custom_List_History_Statistical(List<Bill> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Myholders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_history_statistical, parent, false);
        return new Myholders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholders holder, int position) {
        Bill bill = list.get(position);
        Date dateCheckIn = bill.getDateCheckIn();
        Date dateCheckOut = bill.getDateCheckOut();
        String dateIn = "" + dateCheckIn.getDate() + "/" + (dateCheckIn.getMonth()) + "/" + dateCheckIn.getYear() + "   " + dateCheckIn.getHours() + ":" + dateCheckIn.getMinutes();
        String dateOut = "" + dateCheckOut.getDate() + "/" + (dateCheckOut.getMonth()) + "/" + dateCheckOut.getYear() + "   " + dateCheckOut.getHours() + ":" + dateCheckOut.getMinutes();

        holder.binding.txtBillID.setText(String.valueOf(bill.getBillID()));
        holder.binding.txtFoodPrice.setText(String.valueOf(bill.getTotalPrice()));
        holder.binding.txtDateCheckIn.setText(dateIn);
        holder.binding.txtDateCheckOut.setText(dateOut);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myholders extends RecyclerView.ViewHolder{
        CustomItemHistoryStatisticalBinding binding;
        public Myholders(@NonNull View itemView) {
            super(itemView);
            binding = CustomItemHistoryStatisticalBinding.bind(itemView);
        }
    }
}
