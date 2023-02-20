package com.example.quanlyquantrasua.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//@Entity(tableName = "Account")
public class Account {
//    @PrimaryKey(autoGenerate = false)
//    @NonNull
    private String usedName;
    private String password;
    private boolean permission;

    public Account(String usedName, String password, boolean permission) {
        this.usedName = usedName;
        this.password = password;
        this.permission = permission;
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

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
