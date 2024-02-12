package org.rsreu.library.databaseutil.api.reader;
import org.rsreu.library.databaseutil.entity.BookCatalog;
public class ExtendedBook {
    private BookCatalog bookCatalog;
    private int rating;

    public ExtendedBook(BookCatalog bookCatalog, int rating) {
        this.bookCatalog = bookCatalog;
        this.rating = rating;
    }

    public BookCatalog getBookCatalog() {
        return bookCatalog;
    }

    public void setBookCatalog(BookCatalog bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
