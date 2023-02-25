package com.example.quanlyquantrasua.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import android.os.Bundle;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.data.dbconnect.DBConnect;
import com.example.quanlyquantrasua.databinding.ActivityHomeBinding;
import com.example.quanlyquantrasua.fragment.HistoryFragment;
import com.example.quanlyquantrasua.model.Account;
import com.example.quanlyquantrasua.model.Bill;
import com.example.quanlyquantrasua.model.Category;
import com.example.quanlyquantrasua.model.Food;
import com.example.quanlyquantrasua.model.TableFood;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    DBConnect dbConnect;
    HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        Account account = bundle.getParcelable("account");

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        dbConnect = Room.databaseBuilder(this, DBConnect.class, "Database")
                .allowMainThreadQueries()
                .build();

        historyFragment = new HistoryFragment();

    }

    public List<TableFood> getListTable(){
        return dbConnect.getTableDAO().getListTable();
    }
    public List<Bill> getListBill(){
        return dbConnect.getBillDAO().getListBill(true);
    }
    public List<Bill> getListBillDate(Date dateStart, Date dateEnd) {
        return dbConnect.getBillDAO().getListBillByDate(dateStart, dateEnd, true);
    }

    public void AddTable(TableFood table){
        dbConnect.getTableDAO().AddTable(table);
    }
    public List<Food> getListFood(){
        return dbConnect.getFoodDAO().getListFood();
    }
    public void AddCategory(Category category){
        dbConnect.getCategoryDAO().AddCategory(category);
    }
    public List<Category> getListCategory(){
        return dbConnect.getCategoryDAO().getListCategory();
    }
    public void AddFood(Food food) {
        dbConnect.getFoodDAO().AddFood(food);
    }
    public void DeleteCategoryByID(int id){
        dbConnect.getCategoryDAO().deleteCategoryByID(id);
    }

    public void DeleteTableByID(int id){
        dbConnect.getTableDAO().deleteTableByID(id);
    }

    public void DeleteFoodByID(int id){
        dbConnect.getFoodDAO().deleteFoodByID(id);
    }
    public void DeleteAllFoodByCategoryID(int id) {
        dbConnect.getFoodDAO().deleteFoodByCategoryID(id);
    }

    public void UpdateFood(Food food) {
        dbConnect.getFoodDAO().UpdateFood(food);
    }
}