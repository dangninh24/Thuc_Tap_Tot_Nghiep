package com.example.quanlyquantrasua.model;

public class Table {
    public int tableID;
    public String name;
    public boolean status;

    public Table(int id, String name, boolean status) {
        this.tableID = id;
        this.name = name;
        this.status = status;
    }

    public int getTableID() {
        return tableID;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
