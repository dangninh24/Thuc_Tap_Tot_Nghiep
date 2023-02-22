package com.example.quanlyquantrasua.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.activity.HomeActivity;
import com.example.quanlyquantrasua.custom.Custom_List_History_Statistical;
import com.example.quanlyquantrasua.model.Bill;
import com.example.quanlyquantrasua.viewmodel.HistoryViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {
    View view;
    RecyclerView rcv_history;
    HomeActivity homeActivity;
    HistoryViewModel historyViewModel;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
        homeActivity = (HomeActivity) getActivity();
        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history, container, false);
        INit(view);
        LoadData(view);
        return view;
    }

    private void INit(View view) {
        rcv_history = view.findViewById(R.id.rcv_history);
    }

    private void LoadData(View view) {
        List<Bill> billList = homeActivity.getListBill();
        Custom_List_History_Statistical custom_list_history_statistical = new Custom_List_History_Statistical(billList);
        rcv_history.setAdapter(custom_list_history_statistical);
        rcv_history.setLayoutManager(new LinearLayoutManager(getContext()));

        historyViewModel.getBill().observe((LifecycleOwner) getContext(), new Observer<List<Bill>>() {
            @Override
            public void onChanged(List<Bill> bills) {
                custom_list_history_statistical.notifyDataSetChanged();
            }
        });
    }
}