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

import com.example.project2.databinding.DialogAddBookConfirmationBinding;
import com.example.project2.databinding.DialogErrorBinding;

public class ErrorDialog extends DialogFragment {

    private DialogErrorBinding binding;

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        binding = DialogErrorBinding.inflate(LayoutInflater.from(requireContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());


        builder.setView(binding.getRoot())
                .setTitle("Error")
                .setMessage("The information provided is invalid")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(requireContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });

        return builder.create();
    }
}
