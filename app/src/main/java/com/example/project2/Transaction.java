package com.example.project2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transaction")
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    private int transactionId;

    @ColumnInfo(name = "transaction_type")
    private String transactionType;

    public Transaction(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
