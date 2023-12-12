package org.rsreu.library.databaseutil.entities;

public class BookCatalog {

    private Long bookId;
    private String title;
    private Integer yearPublished;
    private String authorName;
    private String genreName;
    private String publisherName;

    // Getters and Setters for BOOK_ID
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // Getters and Setters for TITLE
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getters and Setters for YEAR_PUBLISHED
    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    // Getters and Setters for AUTHOR_NAME
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    // Getters and Setters for GENRE_NAME
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    // Getters and Setters for PUBLISHER_NAME
    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}

