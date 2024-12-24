package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LibraryDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // initially populating the database
        db = LibraryDatabase.getInstance(MainActivity.this);
        db.populateInitialData();

        // when customer selects the 'Create Account' button
        Button create_account = binding.createAccount;
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(i);
            }
        });

        // when customer selects the 'Place Hold' button
        Button place_hold = binding.placeHold;
        place_hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PlaceHoldActivity.class);
                startActivity(i);
            }
        });

        // when the customer selected the manage system button
        Button manage_system = binding.manageSystem;
        manage_system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ManageSystemActivity.class);
                startActivity(i);
            }
        });
    }
}