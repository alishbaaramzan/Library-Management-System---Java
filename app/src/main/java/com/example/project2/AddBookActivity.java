package com.example.project2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivityAddBookBinding;

public class AddBookActivity extends AppCompatActivity {

    private ActivityAddBookBinding binding;
    private AddBookConfirmationDialog dialog;
    private ErrorDialog errorDialog;
    private LibraryDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = LibraryDatabase.getInstance(this);

       binding.addBook.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String title = binding.bookTitle.getText().toString().trim();
               String author = binding.bookAuthor.getText().toString().trim();
               String genre = binding.bookGenre.getText().toString().trim();

               // checking if a book with this title and author alr exists in the system
               Book b = db.book().getBookByTitleAndAuthor(title, author);

               // we first check if the information entered is valid
               if(title.equals("") || author.equals("") || genre.equals("") || b != null){
                   // error dialogue
                   errorDialog = new ErrorDialog();
                   errorDialog.show(getSupportFragmentManager(), "Error Dialog");
               }
               else {
                   dialog = new AddBookConfirmationDialog(title, author, genre);
                   dialog.show(getSupportFragmentManager(), "BookConfirmationDialog");
               }
           }
       });

    }
}
