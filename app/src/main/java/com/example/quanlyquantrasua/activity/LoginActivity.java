package com.example.quanlyquantrasua.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.quanlyquantrasua.data.dbconnect.DBConnect;
import com.example.quanlyquantrasua.databinding.ActivityLoginBinding;
import com.example.quanlyquantrasua.model.Account;
import com.example.quanlyquantrasua.model.Bill;
import com.example.quanlyquantrasua.model.TableFood;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    DBConnect dbConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbConnect = Room.databaseBuilder(this, DBConnect.class, "Database")
                .allowMainThreadQueries()
                .build();
//
        Account account = dbConnect.getAccountDAO().getAccountByUserNameAndPass("Admin", "1");
        if(account == null) {
            dbConnect.getAccountDAO().AddAccount(new Account("Admin", "1"));
        }

        ClickEvenListener();
    }

    private void ClickEvenListener() {
        binding.btnLogin.setOnClickListener((view) -> {
            LoginByRoom();
        });

        binding.cboxPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    binding.etxtPassword.setTransformationMethod(new HideReturnsTransformationMethod());
                } else {
                    binding.etxtPassword.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });
    }

    private void LoginByRoom() {
        try {
            String name = binding.etxtUsedname.getText().toString();
            String pass = binding.etxtPassword.getText().toString();
            Account account = dbConnect.getAccountDAO().getAccountByUserNameAndPass(name, pass);
            if(account != null) {
                Intent intent = new Intent(this, HomeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("account", account);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                binding.etxtUsedname.setError("Invalid username or account");
            }

        } catch (Exception err) {
            Toast.makeText(this, "Lỗi: " + err.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}