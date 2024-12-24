package com.example.project2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.project2.databinding.DialogAddBookBinding;
import com.example.project2.databinding.DialogAddBookConfirmationBinding;

public class AddBookDialog extends DialogFragment {
    private DialogAddBookBinding binding;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        binding = DialogAddBookBinding.inflate(LayoutInflater.from(requireContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());


        builder.setView(binding.getRoot())
                .setTitle("Add Book")
                .setMessage("Please confirm if you have a new book to add to the system?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(requireContext(), AddBookActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(requireContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

        return builder.create();
    }
}
