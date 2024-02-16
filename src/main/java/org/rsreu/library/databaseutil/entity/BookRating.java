package org.rsreu.library.databaseutil.entity;

public class BookRating {
    private Long bookId;
    private double rating;

    public BookRating(Long bookId, double rating) {
        this.bookId = bookId;
        this.rating = rating;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BookRating{" +
                "bookId=" + bookId +
                ", rating=" + rating +
                '}';
    }
}
