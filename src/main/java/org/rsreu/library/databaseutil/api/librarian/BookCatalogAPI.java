package org.rsreu.library.databaseutil.api.librarian;

import org.rsreu.library.databaseutil.DAO.librarian.BookCatalogDAO;
import org.rsreu.library.databaseutil.entity.BookCatalog;
import org.rsreu.library.databaseutil.OracleConnectionManager;

import org.rsreu.library.databaseutil.DAO.librarian.AuthorDAO;
import org.rsreu.library.databaseutil.DAO.librarian.GenreDAO;
import org.rsreu.library.databaseutil.DAO.librarian.PublisherDAO;

import org.rsreu.library.databaseutil.entity.Author;
import org.rsreu.library.databaseutil.entity.Genre;
import org.rsreu.library.databaseutil.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCatalogAPI {
    private final BookCatalogDAO bookCatalogDAO;
    private final AuthorDAO authorDAO;
    private final GenreDAO genreDAO;
    private final PublisherDAO publisherDAO;
    public BookCatalogAPI() {
        // Initialize BookCatalogDAO - You'll need to manage the connection creation here
        this.bookCatalogDAO = new BookCatalogDAO(OracleConnectionManager.getConnection());
        this.authorDAO = new AuthorDAO(OracleConnectionManager.getConnection());
        this.genreDAO = new GenreDAO(OracleConnectionManager.getConnection());
        this.publisherDAO = new PublisherDAO(OracleConnectionManager.getConnection());
    }

    public List<Object> searchBookCatalog(String searchType, String searchValue) throws SQLException {
        List<BookCatalog> bookCatalogList = new ArrayList<>();
        switch (searchType.toLowerCase()) {
            case "id":
                Long bookId = Long.parseLong(searchValue);
                BookCatalog bookById = bookCatalogDAO.getBookCatalogById(bookId);
                if (bookById != null) {
                    bookCatalogList.add(bookById);
                }
                break;
            case "publisher":
                bookCatalogList = bookCatalogDAO.getBooksByPublisher(searchValue);
                break;
            case "year_published":
                int yearPublished = Integer.parseInt(searchValue);
                bookCatalogList = bookCatalogDAO.getBooksByYearPublished(yearPublished);
                break;
            case "genre":
                bookCatalogList = bookCatalogDAO.getBooksByGenre(searchValue);
                break;
            case "author":
                bookCatalogList = bookCatalogDAO.getBooksByAuthor(searchValue);
                break;
            case "title":
                bookCatalogList = bookCatalogDAO.searchBooksByTitle(searchValue);
                break;
            default:
                // Display all books by default
                bookCatalogList = bookCatalogDAO.getAllBookCatalog();
                break;
        }
        List<Object> convertedList = new ArrayList<>(bookCatalogList);
        return convertedList;
    }

    public void insertBookCatalog(String title, int yearPublished, String authorName, String genreName, String publisherName) throws SQLException {
        BookCatalog book = new BookCatalog();
        book.setTitle(title);
        book.setYearPublished(yearPublished);
        book.setAuthorName(authorName);
        book.setGenreName(genreName);
        book.setPublisherName(publisherName);

        bookCatalogDAO.insertBookCatalog(book);
    }

    public void updateBookCatalog(String title, int yearPublished, String authorName, String genreName, String publisherName, Long bookId) throws SQLException {
        BookCatalog book = new BookCatalog();
        book.setTitle(title);
        book.setYearPublished(yearPublished);
        book.setAuthorName(authorName);
        book.setGenreName(genreName);
        book.setPublisherName(publisherName);
        book.setBookId(bookId);

        bookCatalogDAO.updateBookCatalog(book);
    }

    public void deleteBookCatalogById(Long bookId) throws SQLException {
        bookCatalogDAO.deleteBookCatalogById(bookId);
    }

    public List<Object> getAllAuthors() throws SQLException {
        return convertToObjects(authorDAO.getAllAuthors());
    }

    public List<Object> getAllGenres() throws SQLException {
        return convertToObjects(genreDAO.getAllGenres());
    }

    public List<Object> getAllPublishers() throws SQLException {
        return convertToObjects(publisherDAO.getAllPublishers());
    }

    public void deleteAuthorByName(String authorName) throws SQLException {
        authorDAO.deleteAuthorByName(authorName);
    }

    public void deleteGenreByName(String genreName) throws SQLException {
        genreDAO.deleteGenreByName(genreName);
    }

    public void deletePublisherByName(String publisherName) throws SQLException {
        publisherDAO.deletePublisherByName(publisherName);
    }

    public void insertAuthor(String authorName) throws SQLException {
        authorDAO.insertAuthor(String.valueOf(authorName));
    }

    public void insertGenre(String genreName) throws SQLException {
        genreDAO.insertGenre(String.valueOf(genreName));
    }

    public void insertPublisher(String publisherName) throws SQLException {

        publisherDAO.insertPublisher(String.valueOf(publisherName));
    }

    public void updateAuthorName(String newAuthorName, String oldAuthorName) throws SQLException {
        authorDAO.updateAuthorName(newAuthorName, oldAuthorName);
    }

    public void updateGenreName(String newGenreName, String oldGenreName) throws SQLException {
        genreDAO.updateGenreName(newGenreName, oldGenreName);
    }

    public void updatePublisherName(String newPublisherName, String oldPublisherName) throws SQLException {
        publisherDAO.updatePublisherName(newPublisherName, oldPublisherName);
    }

    private List<Object> convertToObjects(List<?> entities) {

        List<Object> objects = new ArrayList<>();
        for (Object entity : entities) {
            objects.add(entity);
        }
        return objects;
    }

}
