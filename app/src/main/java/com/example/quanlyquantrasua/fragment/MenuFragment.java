package com.example.quanlyquantrasua.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.activity.HomeActivity;
import com.example.quanlyquantrasua.custom.Custom_List_Food_Menu;
import com.example.quanlyquantrasua.custom.Custom_List_Spinner_Category;
import com.example.quanlyquantrasua.custom.Custom_List_Spinner_Food;
import com.example.quanlyquantrasua.custom.Custom_List_Spinner_Table;
import com.example.quanlyquantrasua.databinding.CustomAddFoodBinding;
import com.example.quanlyquantrasua.databinding.CustomDeleteFoodBinding;
import com.example.quanlyquantrasua.databinding.FragmentMenuBinding;
import com.example.quanlyquantrasua.model.Category;
import com.example.quanlyquantrasua.model.Food;
import com.example.quanlyquantrasua.model.TableFood;
import com.example.quanlyquantrasua.viewmodel.FoodViewModel;

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
    FoodViewModel foodViewModel;
    HomeActivity homeActivity;
    Custom_List_Food_Menu custom_list_food_menu;

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
        foodViewModel = new ViewModelProvider(this).get(FoodViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeActivity = (HomeActivity) getActivity();
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        binding = FragmentMenuBinding.bind(view);

        LoadDataFood();
        Event();
        return binding.getRoot();
    }

    private void LoadDataFood() {
        List<Food> list_food = homeActivity.getListFood();

        custom_list_food_menu = new Custom_List_Food_Menu(list_food);
        foodViewModel.getFood().observe((LifecycleOwner) getContext(), new Observer<List<Food>>() {
            @Override
            public void onChanged(List<Food> foods) {
                custom_list_food_menu.notifyDataSetChanged();
            }
        });

        binding.listFoodMenu.setAdapter(custom_list_food_menu);
        binding.listFoodMenu.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        custom_list_food_menu.setItemClickListener(new Custom_List_Food_Menu.setOnItemClickListener() {
            @Override
            public void dosomething(boolean check, int position) {
                Food food = list_food.get(position);
                food.setStatus(check);
                homeActivity.UpdateFood(food);
                foodViewModel.LoadData(homeActivity.getListFood());
            }
        });
        Event();
    }

    private void LoadDataSpinnerAddCategory(Dialog dialog) {

        List<Category> categoryList = homeActivity.getListCategory();
        Custom_List_Spinner_Category custom_spinner = new Custom_List_Spinner_Category(getContext(), categoryList);
        Spinner sn_category = dialog.findViewById(R.id.sn_category);

        sn_category.setAdapter(custom_spinner);
    }

    private void LoadDataSpinnerDeleteCategory(Dialog dialog) {

        List<Category> categoryList = homeActivity.getListCategory();
        Custom_List_Spinner_Category custom_spinner = new Custom_List_Spinner_Category(getContext(), categoryList);
        Spinner sn_category = dialog.findViewById(R.id.sn_delete_category);

        sn_category.setAdapter(custom_spinner);
    }

    private void LoadDataSpinnerDeleteFood(Dialog dialog) {

        List<Food> foodList = homeActivity.getListFood();
        Custom_List_Spinner_Food custom_spinner = new Custom_List_Spinner_Food(getContext(), foodList);
        Spinner sn_food = dialog.findViewById(R.id.sn_delete_food);

        sn_food.setAdapter(custom_spinner);
    }

    private void LoadDataSpinnerDeleteTable(Dialog dialog) {

        List<TableFood> tableFoods = homeActivity.getListTable();
        Custom_List_Spinner_Table custom_spinner = new Custom_List_Spinner_Table(getContext(), tableFoods);
        Spinner sn_table = dialog.findViewById(R.id.sn_delete_table);

        sn_table.setAdapter(custom_spinner);
    }



    private void Event() {
        binding.btnAddFoods.setOnClickListener(views -> {
            Dialog dialog = new Dialog(getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custom_add_food);
            dialog.setCancelable(true);

            Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            EventAddDialog(dialog);
            LoadDataSpinnerAddCategory(dialog);
            dialog.show();
        });

        binding.btnDeleteFoods.setOnClickListener(views -> {
            Dialog dialog = new Dialog(getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.custom_delete_food);
            dialog.setCancelable(true);

            Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            EventDeleteDialog(dialog);
            LoadDataSpinnerDeleteCategory(dialog);
            LoadDataSpinnerDeleteFood(dialog);
            LoadDataSpinnerDeleteTable(dialog);
            dialog.show();
        });
    }

    private void EventDeleteDialog(Dialog dialog) {
        Button btnDeleteTable = dialog.findViewById(R.id.btn_delete_table_dialog);
        Button btnDeleteCategory = dialog.findViewById(R.id.btn_delete_category_dialog);
        Button btnDeleteFood = dialog.findViewById(R.id.btn_delete_food_dialog);

        btnDeleteTable.setOnClickListener(views -> {
            DeleteTable(dialog);

        });

        btnDeleteCategory.setOnClickListener(views -> {
            DeleteCategory(dialog);

        });

        btnDeleteFood.setOnClickListener(views -> {
            DeleteFood(dialog);
        });
    }

    private void DeleteTable(Dialog dialog) {
        Spinner sp_delete_table = dialog.findViewById(R.id.sn_delete_table);
        TableFood table = (TableFood) sp_delete_table.getSelectedItem();
        try {
            homeActivity.DeleteTableByID(table.getTableID());
            LoadDataSpinnerDeleteTable(dialog);
            Toast.makeText(homeActivity, "Xóa bàn thành công", Toast.LENGTH_SHORT).show();
        }catch (Exception err) {
            Toast.makeText(homeActivity, "Lỗi xóa bàn", Toast.LENGTH_SHORT).show();
        }
    }

    private void DeleteCategory(Dialog dialog) {
        Spinner sp_delete_category = dialog.findViewById(R.id.sn_delete_category);
        Category cate = (Category) sp_delete_category.getSelectedItem();
        try {
            homeActivity.DeleteCategoryByID(cate.getCategoryID());
            homeActivity.DeleteAllFoodByCategoryID(cate.getCategoryID());
            LoadDataSpinnerDeleteCategory(dialog);
            LoadDataSpinnerDeleteFood(dialog);
            custom_list_food_menu.notifyDataSetChanged();
            foodViewModel.LoadData(homeActivity.getListFood());
            Toast.makeText(homeActivity, "Xóa danh mục thành công", Toast.LENGTH_SHORT).show();
        }catch (Exception err) {
            Toast.makeText(homeActivity, "Lỗi xóa danh mục", Toast.LENGTH_SHORT).show();
        }
    }
    private void DeleteFood(Dialog dialog) {
        Spinner sp_delete_food = dialog.findViewById(R.id.sn_delete_food);
        Food food = (Food) sp_delete_food.getSelectedItem();
        try {
            homeActivity.DeleteFoodByID(food.getFoodID());
            LoadDataSpinnerDeleteFood(dialog);
            foodViewModel.LoadData(homeActivity.getListFood());
            Toast.makeText(homeActivity, "Xóa đồ uống thành công", Toast.LENGTH_SHORT).show();
        }catch (Exception err) {
            Toast.makeText(homeActivity, "Lỗi xóa đồ uống", Toast.LENGTH_SHORT).show();
        }
    }

    private void EventAddDialog(Dialog dialog) {
        Button btnAddTable = dialog.findViewById(R.id.btn_add_table_dialog);
        Button btnAddCategory = dialog.findViewById(R.id.btn_add_category_dialog);
        Button btnAddFood = dialog.findViewById(R.id.btn_add_food_dialog);

        btnAddTable.setOnClickListener(views -> {
            AddTable(dialog);

        });

        btnAddCategory.setOnClickListener(views -> {
            AddCategory(dialog);

        });

        btnAddFood.setOnClickListener(views -> {
            AddFood(dialog);
        });

    }

    private void AddTable(Dialog dialog) {
        EditText etxtTableName = dialog.findViewById(R.id.etxt_table_name);
        try {
            String tableName = etxtTableName.getText().toString();
            TableFood table = new TableFood(0, tableName, false);
            homeActivity.AddTable(table);
            etxtTableName.setText("");
            Toast.makeText(homeActivity, "Thêm bàn ăn thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception err) {
            Toast.makeText(getContext(), "Lỗi thêm bàn ăn", Toast.LENGTH_SHORT).show();
        }
    }

    private void AddCategory(Dialog dialog) {
        EditText etxtCategoryName = dialog.findViewById(R.id.etxt_category_name);
        try {
            String categoryName = etxtCategoryName.getText().toString();
            Category category = new Category(0, categoryName);
            homeActivity.AddCategory(category);
            LoadDataSpinnerAddCategory(dialog);
            etxtCategoryName.setText("");
            Toast.makeText(homeActivity, "Thêm danh mục thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception err) {
            Toast.makeText(getContext(), "Lỗi thêm danh mục", Toast.LENGTH_SHORT).show();
        }
    }

    public void AddFood(Dialog dialog){
        EditText etxtFoodName = dialog.findViewById(R.id.etxt_food_name);
        EditText etxtFoodPrice = dialog.findViewById(R.id.etxt_food_price);
        Spinner sp_category_name = dialog.findViewById(R.id.sn_category);
        try {
            Category cate = (Category) sp_category_name.getSelectedItem();
            String foodName = etxtFoodName.getText().toString();
            int foodPrice = Integer.valueOf(etxtFoodPrice.getText().toString());

            Food food = new Food(0, cate.getCategoryID(), R.drawable.table_icon, foodName, foodPrice, true);
            homeActivity.AddFood(food);
            etxtFoodName.setText("");
            etxtFoodPrice.setText("");
            Toast.makeText(homeActivity, "Thêm đồ uống thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception err) {
            Toast.makeText(getContext(), "Lỗi thêm đồ uống" + err.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}