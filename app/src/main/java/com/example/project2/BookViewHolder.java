package com.example.project2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.databinding.BookItemBinding;

public class BookViewHolder extends RecyclerView.ViewHolder {

    private BookItemBinding binding;


    public BookViewHolder(@NonNull BookItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    // Provide public access to the binding object
    public BookItemBinding getBinding() {
        return binding;
    }
}