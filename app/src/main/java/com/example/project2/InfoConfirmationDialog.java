package com.example.project2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.project2.databinding.DialogInfoConfirmationBinding;

public class InfoConfirmationDialog extends DialogFragment {
    private DialogInfoConfirmationBinding binding;
    private LibraryDatabase db;

    // custom data members
    int bookId = -1; // Default values
    String username = "";
    int reservationId = -1;
    String bookTitle = "";

    public InfoConfirmationDialog(int bookId, String username, int reservationId, String bookTitle){
        this.bookTitle = bookTitle;
        this.username = username;
        this.reservationId = reservationId;
        this.bookId = bookId;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        binding = DialogInfoConfirmationBinding.inflate(LayoutInflater.from(requireContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        db = LibraryDatabase.getInstance(requireContext());

        // Update the views with the data
        binding.titleConfirm.setText(bookTitle);
        binding.usernameConfirm.setText(username);
        binding.rNoConfirm.setText(String.valueOf(reservationId));


        builder.setView(binding.getRoot())
                .setTitle("Confirmation")
                .setMessage("Please confirm if the following information is valid: ")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // Logging the transaction
                        db.transaction().addTransaction(new Transaction("Place Hold: " + bookTitle + ", Username: " + username + ", Reservation ID: " + reservationId));

                        // Removing the book from the database
                        Book bookToDelete = db.book().getBookById(bookId);

                        if (bookToDelete != null) {
                            db.book().delete(bookToDelete);
                        }

                        // Displaying confirmation
                        Toast.makeText(requireContext(),
                                "Info is valid, book is placed on hold!",
                                Toast.LENGTH_LONG).show();

                        // going back to the main activity
                        Intent intent = new Intent(requireContext(), MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        return builder.create();
    }
}
