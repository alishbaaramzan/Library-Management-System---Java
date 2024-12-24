package com.example.project2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {
        @PrimaryKey(autoGenerate = true)
        private int bookId;

        @ColumnInfo(name = "book_title")
        private String bookTitle;

        @ColumnInfo(name = "author")
        private String author;

        @ColumnInfo(name = "genre")
        private String genre;

        public Book(String bookTitle, String author, String genre) {
                this.bookTitle = bookTitle;
                this.author = author;
                this.genre = genre;
        }

        public int getBookId() {
                return bookId;
        }

        public String getBookTitle() {
                return bookTitle;
        }

        public String getAuthor() {
                return author;
        }

        public String getGenre() {
                return genre;
        }

        public void setBookId(int bookId) {
                this.bookId = bookId;
        }

        public void setBookTitle(String bookTitle) {
                this.bookTitle = bookTitle;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public void setGenre(String genre) {
                this.genre = genre;
        }
}
