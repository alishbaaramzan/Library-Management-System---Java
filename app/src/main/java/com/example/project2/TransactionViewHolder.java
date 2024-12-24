package com.example.project2;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.databinding.TransactionItemBinding;

public class TransactionViewHolder extends RecyclerView.ViewHolder {
    private final TransactionItemBinding binding;

    public TransactionViewHolder(@NonNull TransactionItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    // Provide public access to the binding object
    public TransactionItemBinding getBinding() {
        return binding;
    }
}
