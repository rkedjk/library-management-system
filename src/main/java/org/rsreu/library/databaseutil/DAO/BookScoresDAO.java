package org.rsreu.library.databaseutil.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.rsreu.library.resource.DatabaseManager;

public class BookScoresDAO {
    private final Connection connection;

    public BookScoresDAO(Connection connection) {
        this.connection = connection;
    }

    public void addNewScore(int bookId, int userId, String score) throws SQLException {
        String query = DatabaseManager.getProperty("query.scores.add_new_score");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            statement.setInt(2, userId);
            statement.setString(3, score);
            statement.executeUpdate();
        }
    }
}