package com.example.quanlyquantrasua.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.databinding.FragmentMenuBinding;
import com.example.quanlyquantrasua.model.Custom_List_Food_Menu;
import com.example.quanlyquantrasua.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
    FragmentMenuBinding binding;
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        binding = FragmentMenuBinding.bind(view);
        List<Food> list_food = new ArrayList<>();
        list_food.add(new Food(R.drawable.menu_icon, "Cà Phê Loại 1", 100000, true, true));
        list_food.add(new Food(R.drawable.menu_icon, "Cà Phê Loại 2", 110000, true, false));

        Custom_List_Food_Menu custom_list_food_menu = new Custom_List_Food_Menu(list_food);

        binding.listFoodMenu.setAdapter(custom_list_food_menu);
        binding.listFoodMenu.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        custom_list_food_menu.setItemClickListener(new Custom_List_Food_Menu.setOnItemClickListener() {
            @Override
            public void dosomething(boolean check, int position) {
                list_food.get(position).setCheck(check);
                custom_list_food_menu.notifyDataSetChanged();
            }
        });
        return binding.getRoot();
    }
}