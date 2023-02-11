package com.example.quanlyquantrasua.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.quanlyquantrasua.R;
import com.example.quanlyquantrasua.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        SharedPreferences sharedPreferences = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
        binding.btnLogin.setOnClickListener((view) -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });


    }
}