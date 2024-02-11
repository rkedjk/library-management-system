package org.rsreu.library.databaseutil.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.rsreu.library.resource.DatabaseManager;

public class BookRatingDAO {
    private final Connection connection;

    public BookRatingDAO(Connection connection) {
        this.connection = connection;
    }

    public void updateRating(int bookId, int rating) throws SQLException {
        String query = DatabaseManager.getProperty("query.rating.update_rating");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, rating);
            statement.setInt(2, bookId);
            statement.executeUpdate();
        }
    }

    public void addNewRating(int bookId, int rating) throws SQLException {
        String query = DatabaseManager.getProperty("query.rating.add_new_rating");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            statement.setInt(2, rating);
            statement.executeUpdate();
        }
    }
}