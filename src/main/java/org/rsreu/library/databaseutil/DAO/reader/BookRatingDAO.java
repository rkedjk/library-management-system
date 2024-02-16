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

    public boolean hasUserRatedBook(Long userId, Long bookId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM BOOK_SCORES WHERE USER_ID = ? AND BOOK_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, userId);
            statement.setLong(2, bookId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    public boolean updateRating(Long userId, Long bookId, String rating) throws SQLException {
        // Update the rating in the BOOK_SCORES table
        String updateSql = "UPDATE BOOK_SCORES SET SCORE = ? WHERE USER_ID = ? AND BOOK_ID = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
            updateStatement.setString(1, rating);
            updateStatement.setLong(2, userId);
            updateStatement.setLong(3, bookId);
            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                // If the update is successful, recalculate the percentage of positive reviews
                return recalculatePositiveReviews(bookId);
            }
        }
        return false;
    }

    public boolean insertRating(Long userId, Long bookId, String rating) throws SQLException {
        String sql = "INSERT INTO BOOK_SCORES (USER_ID, BOOK_ID, SCORE) VALUES (?, ?, ?)";
        try (PreparedStatement updateStatement = connection.prepareStatement(sql)) {
            updateStatement.setString(1, rating);
            updateStatement.setLong(2, userId);
            updateStatement.setLong(3, bookId);
            int rowsInserted = updateStatement.executeUpdate();
            if (rowsInserted > 0) {
                // If the insertion is successful, recalculate the percentage of positive reviews
                return recalculatePositiveReviews(bookId);
            }
        }
        return false;
    }

    private boolean recalculatePositiveReviews(Long bookId) throws SQLException {
        // Count the number of positive ratings for the book
        String countPositiveSql = "SELECT COUNT(*) FROM BOOK_SCORES WHERE BOOK_ID = ? AND SCORE = 'positive'";
        try (PreparedStatement countStatement = connection.prepareStatement(countPositiveSql)) {
            countStatement.setLong(1, bookId);
            try (ResultSet resultSet = countStatement.executeQuery()) {
                if (resultSet.next()) {
                    int positiveCount = resultSet.getInt(1);
                    // Calculate the total number of ratings for the book
                    int totalCount = getTotalRatingsForBook(bookId);
                    // Calculate the percentage of positive reviews
                    double positivePercentage = (double) positiveCount / totalCount * 100.0;
                    // Update the positive percentage in the BOOK_SCORES table
                    String updatePositivePercentageSql = "UPDATE BOOK_RATING SET RATING = ? WHERE BOOK_ID = ?";
                    try (PreparedStatement updateStatement = connection.prepareStatement(updatePositivePercentageSql)) {
                        updateStatement.setDouble(1, positivePercentage);
                        updateStatement.setLong(2, bookId);
                        int rowsUpdated = updateStatement.executeUpdate();
                        return rowsUpdated > 0;
                    }
                }
            }
        }
        return false;
    }

    private int getTotalRatingsForBook(Long bookId) throws SQLException {
        // Count the total number of ratings for the book
        String countTotalSql = "SELECT COUNT(*) FROM BOOK_SCORES WHERE BOOK_ID = ?";
        try (PreparedStatement countStatement = connection.prepareStatement(countTotalSql)) {
            countStatement.setLong(1, bookId);
            try (ResultSet resultSet = countStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
        return 0;
    }

}
