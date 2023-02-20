package com.example.quanlyquantrasua.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Account")
public class Account implements Serializable {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private String usedName;
    private String password;

    public Account(String usedName, String password) {
        this.usedName = usedName;
        this.password = password;
    }

    public String getUsedName() {
        return usedName;
    }

    public void setUsedName(String usedName) {
        this.usedName = usedName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
