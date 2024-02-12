package org.rsreu.library.databaseutil.DAO.reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.rsreu.library.databaseutil.entity.BookCatalog;
import org.rsreu.library.resource.DatabaseManager;

public class BookCatalogDAO {
    private final Connection connection;

    public BookCatalogDAO(Connection connection) {
        this.connection = connection;
    }
    public List<BookCatalog> getBooksByPublisher(String publisherName) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.get_books_by_publisher"));
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
    public List<BookCatalog> getBooksByYearPublished(int yearPublished) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.get_books_by_year_published"));
        statement.setInt(1, yearPublished);
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
    public List<BookCatalog> getBooksByGenre(String genreName) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.get_books_by_genre"));
        statement.setString(1, genreName);
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
    public List<BookCatalog> getBooksByAuthor(String authorName) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.get_books_by_author"));
        statement.setString(1, authorName);
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
    public List<BookCatalog> searchBooksByTitle(String title) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.search_books_by_title"));
        statement.setString(1, title);
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

    public BookCatalog getBookCatalogById(Long bookId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.get_book_catalog_by_id"));
        statement.setLong(1, bookId);
        ResultSet resultSet = statement.executeQuery();

        BookCatalog book = new BookCatalog();
        if (resultSet.next()) {
            book.setBookId(resultSet.getLong("BOOK_ID"));
            book.setTitle(resultSet.getString("TITLE"));
            book.setYearPublished(resultSet.getInt("YEAR_PUBLISHED"));
            book.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            book.setGenreName(resultSet.getString("GENRE_NAME"));
            book.setPublisherName(resultSet.getString("PUBLISHER_NAME"));
        }

        return book;
    }


}
