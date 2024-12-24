package com.example.project2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.project2.databinding.DialogEmptyCatalogueBinding;
import com.example.project2.databinding.DialogInfoConfirmationBinding;

public class EmptyCatalogueDialog extends DialogFragment {
    private DialogEmptyCatalogueBinding binding;
    private String genre;

    public EmptyCatalogueDialog(String genre){
        this.genre = genre;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        binding = DialogEmptyCatalogueBinding.inflate(LayoutInflater.from(requireContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        binding.genre.setText(genre);

        builder.setView(binding.getRoot())
                .setTitle("OOPS!")
                .setMessage("Empty catalogue :(")
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(requireContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

        return builder.create();
    }
}
