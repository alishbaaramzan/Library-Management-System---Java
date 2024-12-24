package com.example.project2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project2.databinding.BookItemBinding;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private List<Book> books;
    private BookDao bookDao;

    public BookAdapter(List<Book> books, BookDao bookDao) {
        this.books = books;
        this.bookDao = bookDao;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout using ViewBinding
        BookItemBinding binding = BookItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new BookViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);

        // Bind the question data to the views
        holder.getBinding().bookTitle.setText(book.getBookTitle());
        holder.getBinding().bookAuthor.setText(book.getAuthor());

        // set the functionality for place_hold button here
        holder.getBinding().placeHold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SignInActivity.class);
                i.putExtra("book_id", book.getBookId());
                view.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
