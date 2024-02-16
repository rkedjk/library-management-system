package org.rsreu.library.databaseutil.entity;

import org.rsreu.library.databaseutil.entity.BookCatalog;

public class ExtendedBook {
    private BookCatalog book;
    private int rating;

    public ExtendedBook(BookCatalog book, int rating) {
        this.book = book;
        this.rating = rating;
    }

    public BookCatalog getBook() {
        return book;
    }

    public void setBook(BookCatalog book) {
        this.book = book;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ExtendedBook{" +
                "book=" + book +
                ", rating=" + rating +
                '}';
    }
}
