package org.rsreu.library.databaseutil.DAO.reader;

import org.rsreu.library.databaseutil.entity.BookRating;
import org.rsreu.library.databaseutil.OracleConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRatingDAO {
    private Connection connection;

    public BookRatingDAO (Connection connection) {
        this.connection = connection;
    }

    public int insertBookRating(BookRating bookRating) throws SQLException {
        int rowsAffected = 0;
        String sql = "INSERT INTO BOOK_RATING (BOOK_ID, RATING) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, bookRating.getBookId());
            statement.setDouble(2, bookRating.getRating());
            rowsAffected = statement.executeUpdate();
        }
        return rowsAffected;
    }

    public int updateBookRating(BookRating bookRating) throws SQLException {
        int rowsAffected = 0;
        String sql = "UPDATE BOOK_RATING SET RATING = ? WHERE BOOK_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, bookRating.getRating());
            statement.setLong(2, bookRating.getBookId());
            rowsAffected = statement.executeUpdate();
        }
        return rowsAffected;
    }

    public int deleteBookRatingByBookId(Long bookId) throws SQLException {
        int rowsAffected = 0;
        String sql = "DELETE FROM BOOK_RATING WHERE BOOK_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, bookId);
            rowsAffected = statement.executeUpdate();
        }
        return rowsAffected;
    }

    public int getRatingByBookId(Long bookId) throws SQLException {
        int rating = -1; // Default value if rating not found
        String sql = "SELECT RATING FROM BOOK_RATING WHERE BOOK_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, bookId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    rating = resultSet.getInt("RATING");
                }
            }
        }
        return rating;
    }
}
