package com.example.project2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustomerDao {

    @Insert
    void addCustomer(Customer customer);

    @Query("SELECT COUNT(*) FROM customer")
    int count();

    @Query("SELECT * FROM customer")
    List<Customer> getAll();

    @Delete
    void delete(Customer customer);

    @Query("SELECT * FROM customer WHERE username = :username")
    Customer getCustomerByUsername(String username);

    @Query("SELECT * FROM customer WHERE username = :username AND password = :password")
    Customer getCustomerByUsernameAndPassword(String username, String password);
}
