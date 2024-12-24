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

public class AddBookConfirmationDialog extends DialogFragment {
    private DialogAddBookConfirmationBinding binding;
    private LibraryDatabase db;
    private String title = "";
    private String author = "";
    private String genre = "";

    public AddBookConfirmationDialog(String title, String author, String genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        binding = DialogAddBookConfirmationBinding.inflate(LayoutInflater.from(requireContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());

        db = LibraryDatabase.getInstance(requireContext());

        //updating the views with data
        binding.bookTitleConfirm.setText(title);
        binding.bookAuthorConfirm.setText(author);
        binding.bookGenreConfirm.setText(genre);

        builder.setView(binding.getRoot())
                .setTitle("Confirmation")
                .setMessage("Please confirm if the following information is valid: ")
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.book().addBook(new Book(title, author,genre));
                        Toast.makeText(requireContext(),
                                "New book added to the system!",
                                Toast.LENGTH_LONG).show();

                        // going back to main menu
                        Intent intent = new Intent(requireContext(), MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dismiss();
                    }
                });

        return builder.create();
    }
}
