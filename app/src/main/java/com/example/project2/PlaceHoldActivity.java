package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.project2.databinding.ActivityPlaceHoldBinding;

import java.util.List;

public class PlaceHoldActivity extends AppCompatActivity {

    private LibraryDatabase db;
    private ActivityPlaceHoldBinding binding;
    private BookAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlaceHoldBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.computerScienceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PlaceHoldActivity.this, BookCatalogueActivity.class);
                i.putExtra("genre", "Computer Science");
                startActivity(i);
            }
        });

        binding.selfHelpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PlaceHoldActivity.this, BookCatalogueActivity.class);
                i.putExtra("genre", "Self-Help");
                startActivity(i);
            }
        });

        binding.historicalFantasyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PlaceHoldActivity.this, BookCatalogueActivity.class);
                i.putExtra("genre", "Historical Fantasy");
                startActivity(i);
            }
        });

    }
}
