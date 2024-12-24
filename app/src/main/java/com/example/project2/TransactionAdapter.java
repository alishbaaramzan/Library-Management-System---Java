package com.example.project2;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.databinding.TransactionItemBinding;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionViewHolder> {

    private List<Transaction> transactions;
    private TransactionDao transactionDao;

    public TransactionAdapter(List<Transaction> transactions, TransactionDao transactionDao) {
        this.transactions = transactions;
        this.transactionDao = transactionDao;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout using ViewBinding
        TransactionItemBinding binding = TransactionItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new TransactionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);

        // Bind the question data to the views
        holder.getBinding().transactionText.setText(transaction.getTransactionType());

    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }
}