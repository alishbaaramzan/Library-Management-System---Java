package com.example.project2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "customer")
public class Customer {

    @PrimaryKey(autoGenerate = true)
    private int customerId;

    @ColumnInfo(name = "username")
    private String username; // making the username primary key so that we can never have two similar usernames - by SQL principle

    @ColumnInfo(name = "password")
    private String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
