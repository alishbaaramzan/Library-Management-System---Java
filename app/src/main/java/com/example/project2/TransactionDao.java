package com.example.project2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionDao {
    @Insert
    void addTransaction(Transaction transaction);

    @Query("SELECT COUNT(*) FROM `transaction`")
    int count();

    @Query("SELECT * FROM `transaction`")
    List<Transaction> getAll();

    @Delete
    void delete(Transaction transaction);
}
