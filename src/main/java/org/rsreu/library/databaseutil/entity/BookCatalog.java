package org.rsreu.library.databaseutil.entity;

/**
 * The BookCatalog class represents information about a book in the library catalog.
 */
public class BookCatalog {

    private Long bookId; // Identifier for the book
    private String title; // Title of the book
    private Integer yearPublished; // Year the book was published
    private String authorName; // Name of the book's author
    private String genreName; // Genre of the book
    private String publisherName; // Name of the book's publisher

    /**
     * Retrieves the book's identifier.
     *
     * @return The book's ID
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * Sets the book's identifier.
     *
     * @param bookId The book's ID to set
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * Retrieves the title of the book.
     *
     * @return The book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The book's title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the year the book was published.
     *
     * @return The year the book was published
     */
    public Integer getYearPublished() {
        return yearPublished;
    }

    /**
     * Sets the year the book was published.
     *
     * @param yearPublished The year the book was published to set
     */
    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    /**
     * Retrieves the name of the book's author.
     *
     * @return The author's name
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Sets the name of the book's author.
     *
     * @param authorName The author's name to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * Retrieves the genre of the book.
     *
     * @return The book's genre
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * Sets the genre of the book.
     *
     * @param genreName The book's genre to set
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    /**
     * Retrieves the name of the book's publisher.
     *
     * @return The publisher's name
     */
    public String getPublisherName() {
        return publisherName;
    }

    /**
     * Sets the name of the book's publisher.
     *
     * @param publisherName The publisher's name to set
     */
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
