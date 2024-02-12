package org.rsreu.library.databaseutil.DAO.librarian;

import org.rsreu.library.databaseutil.entity.BookCatalog;
import org.rsreu.library.resource.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The BookCatalogDAO class provides Data Access Object methods to interact with book catalog-related database operations.
 */
public class BookCatalogDAO {

    private final Connection connection;

    /**
     * Constructor for BookCatalogDAO.
     *
     * @param connection The connection object to the database
     */
    public BookCatalogDAO(Connection connection) {
        this.connection = connection;
    }
    /**
     * Inserts a new book catalog entry into the database.
     *
     * @param bookCatalog The book catalog object to be inserted
     * @return True if insertion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean insertBookCatalog(BookCatalog bookCatalog) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_book_catalog"));

        statement.setString(1, bookCatalog.getTitle());
        statement.setInt(2, bookCatalog.getYearPublished());
        statement.setString(3, bookCatalog.getAuthorName());
        statement.setString(4, bookCatalog.getGenreName());
        statement.setString(5, bookCatalog.getPublisherName());

        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }
    /**
     * Retrieves a book catalog entry by its ID from the database.
     *
     * @param bookId The ID of the book to retrieve
     * @return The book catalog entry corresponding to the given ID
     * @throws SQLException If an SQL exception occurs
     */
    public BookCatalog getBookCatalogById(Long bookId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_book_catalog_by_id"));
        statement.setLong(1, bookId);
        ResultSet resultSet = statement.executeQuery();

        BookCatalog bookCatalog = new BookCatalog();
        if (resultSet.next()) {
            bookCatalog.setBookId(resultSet.getLong("BOOK_ID"));
            bookCatalog.setTitle(resultSet.getString("TITLE"));
            bookCatalog.setYearPublished(resultSet.getInt("YEAR_PUBLISHED"));
            bookCatalog.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            bookCatalog.setGenreName(resultSet.getString("GENRE_NAME"));
            bookCatalog.setPublisherName(resultSet.getString("PUBLISHER_NAME"));
        }

        return bookCatalog;
    }
    /**
     * Updates a book catalog entry in the database.
     *
     * @param bookCatalog The book catalog object with updated information
     * @return True if the update is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean updateBookCatalog(BookCatalog bookCatalog) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_book_catalog"));

        statement.setString(1, bookCatalog.getTitle());
        statement.setInt(2, bookCatalog.getYearPublished());
        statement.setString(3, bookCatalog.getAuthorName());
        statement.setString(4, bookCatalog.getGenreName());
        statement.setString(5, bookCatalog.getPublisherName());
        statement.setLong(6, bookCatalog.getBookId());

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
    /**
     * Deletes a book catalog entry from the database based on its ID.
     *
     * @param bookId The ID of the book catalog entry to be deleted
     * @return True if deletion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean deleteBookCatalogById(Long bookId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.delete_book_catalog_by_id"));
        statement.setLong(1, bookId);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }
    /**
     * Retrieves a list of book catalog entries based on a specific publisher.
     *
     * @param publisherName The name of the publisher to search for
     * @return A list of book catalog entries matching the specified publisher
     * @throws SQLException If an SQL exception occurs
     */
    public List<BookCatalog> getBooksByPublisher(String publisherName) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_by_publisher"));
        statement.setString(1, publisherName);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            BookCatalog book = new BookCatalog();
            book.setBookId(resultSet.getLong("BOOK_ID"));
            book.setTitle(resultSet.getString("TITLE"));
            book.setYearPublished(resultSet.getInt("YEAR_PUBLISHED"));
            book.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            book.setGenreName(resultSet.getString("GENRE_NAME"));
            book.setPublisherName(resultSet.getString("PUBLISHER_NAME"));

            bookList.add(book);
        }

        return bookList;
    }
    /**
     * Retrieves a list of book catalog entries based on a specific year of publication.
     *
     * @param yearPublished The year of publication to search for
     * @return A list of book catalog entries published in the specified year
     * @throws SQLException If an SQL exception occurs
     */
    public List<BookCatalog> getBooksByYearPublished(int yearPublished) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_by_year_published"));
        statement.setInt(1, yearPublished);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            BookCatalog bookCatalog = new BookCatalog();
            bookCatalog.setBookId(resultSet.getLong("BOOK_ID"));
            bookCatalog.setTitle(resultSet.getString("TITLE"));
            bookCatalog.setYearPublished(resultSet.getInt("YEAR_PUBLISHED"));
            bookCatalog.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            bookCatalog.setGenreName(resultSet.getString("GENRE_NAME"));
            bookCatalog.setPublisherName(resultSet.getString("PUBLISHER_NAME"));

            bookList.add(bookCatalog);
        }

        return bookList;
    }
    /**
     * Retrieves a list of book catalog entries based on a specific genre.
     *
     * @param genreName The name of the genre to search for
     * @return A list of book catalog entries belonging to the specified genre
     * @throws SQLException If an SQL exception occurs
     */
    public List<BookCatalog> getBooksByGenre(String genreName) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_by_genre"));
        statement.setString(1, genreName);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            BookCatalog bookCatalog = new BookCatalog();
            bookCatalog.setBookId(resultSet.getLong("BOOK_ID"));
            bookCatalog.setTitle(resultSet.getString("TITLE"));
            bookCatalog.setYearPublished(resultSet.getInt("YEAR_PUBLISHED"));
            bookCatalog.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            bookCatalog.setGenreName(resultSet.getString("GENRE_NAME"));
            bookCatalog.setPublisherName(resultSet.getString("PUBLISHER_NAME"));

            bookList.add(bookCatalog);
        }

        return bookList;
    }
    /**
     * Retrieves a list of book catalog entries based on a specific author's name.
     *
     * @param authorName The name of the author to search for
     * @return A list of book catalog entries authored by the specified author
     * @throws SQLException If an SQL exception occurs
     */
    public List<BookCatalog> getBooksByAuthor(String authorName) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_by_author"));
        statement.setString(1,  authorName);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            BookCatalog bookCatalog = new BookCatalog();
            bookCatalog.setBookId(resultSet.getLong("BOOK_ID"));
            bookCatalog.setTitle(resultSet.getString("TITLE"));
            bookCatalog.setYearPublished(resultSet.getInt("YEAR_PUBLISHED"));
            bookCatalog.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            bookCatalog.setGenreName(resultSet.getString("GENRE_NAME"));
            bookCatalog.setPublisherName(resultSet.getString("PUBLISHER_NAME"));

            bookList.add(bookCatalog);
        }

        return bookList;
    }
    /**
     * Searches for book catalog entries based on a specified title keyword.
     *
     * @param title The keyword to search for in book titles
     * @return A list of book catalog entries containing the specified title keyword
     * @throws SQLException If an SQL exception occurs
     */
    public List<BookCatalog> searchBooksByTitle(String title) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.search_books_by_title"));
        statement.setString(1, title);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            BookCatalog bookCatalog = new BookCatalog();
            bookCatalog.setBookId(resultSet.getLong("BOOK_ID"));
            bookCatalog.setTitle(resultSet.getString("TITLE"));
            bookCatalog.setYearPublished(resultSet.getInt("YEAR_PUBLISHED"));
            bookCatalog.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            bookCatalog.setGenreName(resultSet.getString("GENRE_NAME"));
            bookCatalog.setPublisherName(resultSet.getString("PUBLISHER_NAME"));

            bookList.add(bookCatalog);
        }

        return bookList;
    }
    /**
     * Retrieves a list of all book catalog entries from the database.
     *
     * @return A list containing all book catalog entries
     * @throws SQLException If an SQL exception occurs
     */
    public List<BookCatalog> getAllBookCatalog() throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_all_book_catalog"));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            BookCatalog bookCatalog = new BookCatalog();
            bookCatalog.setBookId(resultSet.getLong("BOOK_ID"));
            bookCatalog.setTitle(resultSet.getString("TITLE"));
            bookCatalog.setYearPublished(resultSet.getInt("YEAR_PUBLISHED"));
            bookCatalog.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            bookCatalog.setGenreName(resultSet.getString("GENRE_NAME"));
            bookCatalog.setPublisherName(resultSet.getString("PUBLISHER_NAME"));

            bookList.add(bookCatalog);
        }

        return bookList;
    }

}
