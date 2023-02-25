package com.example.quanlyquantrasua.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.activity.HomeActivity;
import com.example.quanlyquantrasua.custom.Custom_List_Food_Order;
import com.example.quanlyquantrasua.custom.Custom_List_Food_Pay;
import com.example.quanlyquantrasua.custom.Custom_List_table;
import com.example.quanlyquantrasua.data.dbconnect.DBConnect;
import com.example.quanlyquantrasua.data.relationship.FoodAndBillInfo;
import com.example.quanlyquantrasua.databinding.CustomFoodOrderBinding;
import com.example.quanlyquantrasua.databinding.FragmentTableBinding;
import com.example.quanlyquantrasua.model.BillInfo;
import com.example.quanlyquantrasua.model.Food;
import com.example.quanlyquantrasua.model.TableFood;
import com.example.quanlyquantrasua.viewmodel.TableViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    TableViewModel tableViewModel;
    HomeActivity homeActivity;
    RecyclerView rcv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TableFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TableFragment newInstance(String param1, String param2) {
        TableFragment fragment = new TableFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        tableViewModel = new ViewModelProvider(this).get(TableViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_table, container, false);
        CustomAdapter(container);
        return view;
    }



    private void CustomAdapter(ViewGroup container) {
        recyclerView = view.findViewById(R.id.rcv_list_table);
        homeActivity = (HomeActivity) getActivity();

        List<TableFood> listTable = homeActivity.getListTable();

        Custom_List_table custom_list_table = new Custom_List_table(listTable);

        recyclerView.setAdapter(custom_list_table);
        tableViewModel.getTable().observe((LifecycleOwner) getContext(), new Observer<List<TableFood>>() {
            @Override
            public void onChanged(List<TableFood> tables) {
                custom_list_table.notifyDataSetChanged();
            }
        });

        custom_list_table.setItemClickListener(new Custom_List_table.setOnItemClickListener() {
            @Override
            public void dosomething(int position) {
                boolean check = listTable.get(position).status == true ? false : true;
                ShowPayment(check, position);
                listTable.get(position).status = check;
                tableViewModel.loadTable(listTable);
            }

            @Override
            public void order(int position) {
                showOrder();
                
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    private void showOrder() {
        View viewBottomSheet = getLayoutInflater().inflate(R.layout.custom_order_bottomsheet, null);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext());
        bottomSheetDialog.setContentView(viewBottomSheet);
        rcv = bottomSheetDialog.findViewById(R.id.rcv_list_food_order);

        List<Food> list_food = new ArrayList<>();

        Custom_List_Food_Order custom_list_food_order = new Custom_List_Food_Order(list_food);
        rcv.setAdapter(custom_list_food_order);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));

        custom_list_food_order.setOnItemClickListener(new Custom_List_Food_Order.ItemClickListener() {
            @Override
            public void DoSomething(int position) {

            }

            @Override
            public void PlusCount(CustomFoodOrderBinding binding, int position) {
                String numberString = binding.etxtFoodCount.getText().toString();
                int number = Integer.valueOf(numberString) + 1;
                binding.etxtFoodCount.setText(String.valueOf(number));
            }

            @Override
            public void MinusCount(CustomFoodOrderBinding binding, int position) {
                String numberString = binding.etxtFoodCount.getText().toString();
                int number = Integer.valueOf(numberString) - 1;
                binding.etxtFoodCount.setText(String.valueOf(number));
            }

            @Override
            public void SelectCount(CustomFoodOrderBinding binding, int position) {
                Toast.makeText(homeActivity, "Món " + list_food.get(position).getName() + "    order " + binding.etxtFoodCount.getText().toString(), Toast.LENGTH_SHORT).show();
            }

        });

        bottomSheetDialog.show();
    }

    private void ShowPayment(boolean check, int position) {
        if(check) {
            return;
        }

        Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_payment);
        dialog.setCancelable(true);

        ShowFoodPay(dialog);

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnPay = dialog.findViewById(R.id.btn_pay);

        btnPay.setOnClickListener(view ->{
            CancelPayTheBill(dialog);
        });

        dialog.show();
    }

    private void ShowFoodPay(Dialog dialog) {
        List<FoodAndBillInfo> foodAndBillInfoList = new ArrayList<>();
        Food food = new Food(1, 0, R.drawable.menu_icon, "Cà phê", 60000, true);
        BillInfo billInfo = new BillInfo(1, 1, 3);

        Food food2 = new Food(2, 0, R.drawable.menu_icon, "Hướng dương", 10000, true);
        BillInfo billInfo2 = new BillInfo(1, 2, 3);

        FoodAndBillInfo foodAndBillInfo = new FoodAndBillInfo();
        foodAndBillInfo.billInfo = billInfo;
        foodAndBillInfo.food = food;

        FoodAndBillInfo foodAndBillInfo2 = new FoodAndBillInfo();
        foodAndBillInfo2.billInfo = billInfo2;
        foodAndBillInfo2.food = food2;


        foodAndBillInfoList.add(foodAndBillInfo);
        foodAndBillInfoList.add(foodAndBillInfo2);

        RecyclerView recyclerView = dialog.findViewById(R.id.food_list_payment);
        Custom_List_Food_Pay customListFoodPay = new Custom_List_Food_Pay(foodAndBillInfoList);

        recyclerView.setAdapter(customListFoodPay);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        TextView txtTotalPrice = dialog.findViewById(R.id.txt_totalPrice_pay);
        int sum = 0;
        for(FoodAndBillInfo item : foodAndBillInfoList) {
            sum += item.food.getPrice() * item.billInfo.getCount();
        }
        txtTotalPrice.setText(String.valueOf(sum) + " NVD");
    }

    private void CancelPayTheBill(Dialog dialog) {
        dialog.cancel();
    }
}