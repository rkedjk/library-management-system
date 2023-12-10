package org.rsreu.library.databaseutil.entities;

public class Book {
    private int bookId;
    private String title;
    private Integer yearPublished;
    private Integer authorId;
    private Integer genreId;
    private Integer publisherId;

    public Book(int bookId, String title, Integer yearPublished, Integer authorId, Integer genreId, Integer publisherId) {
        this.bookId = bookId;
        this.title = title;
        this.yearPublished = yearPublished;
        this.authorId = authorId;
        this.genreId = genreId;
        this.publisherId = publisherId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }
}
