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

import com.example.project2.databinding.DialogManagerConfirmationBinding;

public class ManagerConfirmationDialog extends DialogFragment {
    private DialogManagerConfirmationBinding binding;
    private int allowedAttempts = 2;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Inflate the custom layout
        binding = DialogManagerConfirmationBinding.inflate(LayoutInflater.from(requireContext()));

        // Build the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setView(binding.getRoot())
                .setTitle("Sign In")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username = binding.managerUsername.getText().toString().trim();
                        String password = binding.managerPassword.getText().toString().trim();

                        if (username.equals("!admin2") && password.equals("!admin2")) {
                            // Proceed to the manager activity
                            dismiss();
                            Toast.makeText(requireContext(), "Welcome, Manager!", Toast.LENGTH_SHORT).show();
                        } else {
                            allowedAttempts--;
                            if (allowedAttempts > 0) {
                                Toast.makeText(requireContext(),
                                        "Invalid credentials. Please try again.",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(requireContext(),
                                        "ERROR! Too many wrong attempts.",
                                        Toast.LENGTH_LONG).show();
                                // Navigate to MainActivity after too many failed attempts
                                Intent intent = new Intent(requireContext(), MainActivity.class);
                                startActivity(intent);
                                dismiss();
                            }
                        }
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // Navigate to MainActivity on cancellation
                    Intent intent = new Intent(requireContext(), MainActivity.class);
                    startActivity(intent);
                });

        return builder.create();
    }
}