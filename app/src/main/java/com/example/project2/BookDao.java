package com.example.project2;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void addBook(Book book);

    @Query("SELECT COUNT(*) FROM `books`")
    int count();

    @Query("SELECT * FROM books")
    List<Book> getAll();

    @Query("SELECT * FROM books WHERE genre = :genre")
    List<Book>getBooksByGenre(String genre);

    @Query("SELECT * FROM books WHERE bookId = :id")
    Book getBookById(int id);

    @Query("SELECT * FROM books WHERE book_title = :title AND author = :author")
    Book getBookByTitleAndAuthor(String title, String author);

    @Delete
    void delete(Book book);
}
