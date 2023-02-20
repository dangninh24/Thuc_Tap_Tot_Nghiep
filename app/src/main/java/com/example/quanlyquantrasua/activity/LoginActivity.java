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
import com.example.quanlyquantrasua.model.TableFood;

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

//        dbConnect.getTableDAO().AddTable(new TableFood(1,"Bàn số 1", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(2,"Bàn số 2", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(3,"Bàn số 3", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(4,"Bàn số 4", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(5,"Bàn số 5", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(6,"Bàn số 6", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(7,"Bàn số 7", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(8,"Bàn số 8", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(9,"Bàn số 9", false));
//        dbConnect.getTableDAO().AddTable(new TableFood(10,"Bàn số 10", false));

//        dbConnect.getAccountDAO().AddAccount(new Account("Admin", "1"));
//        SharedPreferences sharedPreferences = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
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