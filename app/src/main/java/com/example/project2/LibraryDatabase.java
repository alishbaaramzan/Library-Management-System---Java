package com.example.project2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Customer.class, Book.class, Transaction.class}, version=3, exportSchema=false)
public abstract class LibraryDatabase extends RoomDatabase {

    public abstract CustomerDao customer();
    public abstract TransactionDao transaction();
    public abstract BookDao book();
    private static LibraryDatabase sInstance;

    public static synchronized LibraryDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            LibraryDatabase.class, "library.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData() {
        runInTransaction(() -> {

            // seeding the customer table
            if(customer().count()==0){

                Customer c1 = new Customer("sShlaer", "oop");
                Customer c2 = new Customer("bMeyer", "eiffel");
                Customer c3 = new Customer("shirleyBee", "carmel2Chicago");

                customer().addCustomer(c1);
                customer().addCustomer(c2);
                customer().addCustomer(c3);
            }

            // seeding the books table
            if(book().count()==0){

                Book b1 = new Book("Meditations", "Marcus Aurelius", "Self-Help");
                Book b2 = new Book("Letters to a Young Poet", "Rainer Maria Rilke ", "Self-Help");
                Book b3 = new Book("Circe", "Madeline Miller", "Historical Fantasy");
                Book b4 = new Book("Reusable Software", "Bertrand Meyer", "Computer Science");
                Book b5 = new Book("Intro to Machine Learning", "Anita Faul", "Computer Science");

                book().addBook(b1);
                book().addBook(b2);
                book().addBook(b3);
                book().addBook(b4);
                book().addBook(b5);
            }

        });
    }

}

