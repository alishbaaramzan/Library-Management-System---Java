package com.example.project2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.project2.databinding.ActivityBookCatalogueBinding;

import java.util.List;

public class BookCatalogueActivity extends AppCompatActivity {

    private LibraryDatabase db;
    private ActivityBookCatalogueBinding binding;
    private BookAdapter adapter;
    private EmptyCatalogueDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBookCatalogueBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = LibraryDatabase.getInstance(this);

        String genre = getIntent().getStringExtra("genre");

        // filtering the books by genre
        List<Book> books = db.book().getBooksByGenre(genre);

        // in case there is no book for the current genre
        if((books == null || books.isEmpty())){
           dialog = new EmptyCatalogueDialog(genre);
           dialog.show(getSupportFragmentManager(), "EmptyCatalogueDialog");
        }

        else {
            // Set up RecyclerView
            adapter = new BookAdapter(books, db.book());
            binding.recyclerView.setAdapter(adapter);
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    }
}
