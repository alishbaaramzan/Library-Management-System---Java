package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding binding;
    private LibraryDatabase db;
    private InfoConfirmationDialog dialogFragment;
    private int allowedAttempts = 2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = LibraryDatabase.getInstance(this);

        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bookId = getIntent().getIntExtra("book_id", -1);

                if(bookId!=-1){
                    String username = binding.username.getText().toString().trim();
                    String password = binding.password.getText().toString().trim();

                    Customer c = db.customer().getCustomerByUsernameAndPassword(username, password);
                    Book b = db.book().getBookById(bookId);

                    if(c != null){

                        dialogFragment = new InfoConfirmationDialog(bookId, username, bookId+1001, b.getBookTitle());
                        dialogFragment.show(getSupportFragmentManager(), "InfoConfirmationDialog");
                    }
                    else{
                        allowedAttempts--;
                        if(allowedAttempts>=1) {
                            Toast.makeText(SignInActivity.this,
                                    "Info is not valid, please re-enter your username and password",
                                    Toast.LENGTH_LONG).show();
                        }
                        else {
                            // go back to main menu
                            Toast.makeText(SignInActivity.this,
                                    "ERROR! Too many wrong attempts",
                                    Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                            startActivity(intent);

                        }
                    }
                }
            }
        });
    }
}
