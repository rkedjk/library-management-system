package org.rsreu.library.databaseutil.DAO.librarian;

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

    public boolean deleteBookCatalogById(Long bookId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.delete_book_catalog_by_id"));
        statement.setLong(1, bookId);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }
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
    public List<BookCatalog> getBooksByGenre(String genreName) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_by_genre"));
        statement.setString(1, "%" + genreName + "%");
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
    public List<BookCatalog> getBooksByAuthor(String authorName) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_by_author"));
        statement.setString(1, "%" + authorName + "%");
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
    public List<BookCatalog> searchBooksByTitle(String title) throws SQLException {
        List<BookCatalog> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.search_books_by_title"));
        statement.setString(1, "%" + title + "%");
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
