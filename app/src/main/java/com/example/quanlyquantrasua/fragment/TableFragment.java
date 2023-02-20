package com.example.quanlyquantrasua.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.model.Table;
import com.example.quanlyquantrasua.viewmodel.TableViewModel;

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
        recyclerView = view.findViewById(R.id.rcv_list_table);
        List<Table> list = new ArrayList<>();
        list.add(new Table(1 ,"Bàn số 1", true));
        list.add(new Table(2,"Bàn số 2", false));
        list.add(new Table(3,"Bàn số 3", true));
        list.add(new Table(4,"Bàn số 4", false));
        list.add(new Table(5,"Bàn số 5", true));
        list.add(new Table(6,"Bàn số 6", false));
        list.add(new Table(7,"Bàn số 7", false));

        Custom_List_table custom_list_table = new Custom_List_table(list);
        recyclerView.setAdapter(custom_list_table);
        tableViewModel.getTable().observe((LifecycleOwner) getContext(), new Observer<List<Table>>() {
            @Override
            public void onChanged(List<Table> tables) {
                custom_list_table.notifyDataSetChanged();
            }
        });
        custom_list_table.setItemClickListener(new Custom_List_table.setOnItemClickListener() {
            @Override
            public void dosomething(int position) {
                boolean check = list.get(position).status == true ? false : true;
                list.get(position).status = check;
                tableViewModel.loadTable(list);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));


        return view;
    }
}