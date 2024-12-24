package com.example.project2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project2.databinding.ActivityCreateAccountBinding;

public class CreateAccountActivity extends AppCompatActivity {

    private ActivityCreateAccountBinding binding;
    private LibraryDatabase db;
    int allowed_attempts = 2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = LibraryDatabase.getInstance(this);

        // adding a new customer to the database when the 'create account' is clicked
        binding.createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();


                // first and foremost checking if allowed attempts are left
                if(allowed_attempts <=1 ){
                    Toast.makeText(CreateAccountActivity.this,
                            "ERROR",
                            Toast.LENGTH_LONG).show();

                    finish();
                }

                // checking for all the invalid cases before adding the username to the database
                if(!username.equals("") && !password.equals("") && !username.equals("!admin2")){

                    // checking for duplicate accounts
                    if(db.customer().getCustomerByUsername(username) == null){
                        db.customer().addCustomer(new Customer(username, password)); // adding the customer
                        db.transaction().addTransaction(new Transaction("Transaction Type : New Account, Customer's Name: "+ username)); // logging transaction

                        Toast.makeText(CreateAccountActivity.this,
                                "Your account has been created successfully!",
                                Toast.LENGTH_LONG).show();

                        finish();

                    }

                    else{
                        Toast.makeText(CreateAccountActivity.this,
                                "Username already exists. Try Again!",
                                Toast.LENGTH_LONG).show();
                        allowed_attempts--; // reduce attempts
                    }

                }
                else{
                    Toast.makeText(CreateAccountActivity.this,
                            "Username/Password can not be blank. Try Again!",
                            Toast.LENGTH_LONG).show();
                    allowed_attempts--; // reduce attempts
                }
            }
        });

    }
}
