package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.project2.databinding.ActivityManageSystemBinding;

import java.util.List;

public class ManageSystemActivity extends AppCompatActivity {

    private ActivityManageSystemBinding binding;
    private ManagerConfirmationDialog managerDialog;
    private AddBookDialog bookDialog;
    private LibraryDatabase db;
    private TransactionAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityManageSystemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // making an instance of the database
        db = LibraryDatabase.getInstance(this);

        // an alert dialogue pops up asking for username and password
        managerDialog = new ManagerConfirmationDialog();
        managerDialog.show(getSupportFragmentManager(), "ManagerConfirmationDialog");

        // if the dialogue has been dismissed then it means the info was valid so we can proceed to display all the tranactions
        // Set up RecyclerView
        List<Transaction> transactions = db.transaction().getAll();
        adapter = new TransactionAdapter(transactions, db.transaction());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // when the ok button ic clicked, we need to ask the manager if they want to add a book
        binding.managerOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookDialog = new AddBookDialog();
                bookDialog.show(getSupportFragmentManager(), "AddBookDialog");
            }
        });


    }
}
