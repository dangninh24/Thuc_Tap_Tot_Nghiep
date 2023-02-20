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
import com.example.quanlyquantrasua.model.Account;
import com.example.quanlyquantrasua.model.TableFood;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    DBConnect dbConnect;
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

    }

    public List<TableFood> getListTable(){
        return dbConnect.getTableDAO().getListTable();
    }
}