package com.app.akiddie.Entities;

/**
 * Created by namdi on 12/11/18.
 */

public class BooksObject {

    private int bookId;
    private String bookName;
    private int bookCoverImage;

    public BooksObject(int bookId, String bookName, int bookCoverImage) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookCoverImage = bookCoverImage;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public int getBookCoverImage() {
        return bookCoverImage;
    }
}
