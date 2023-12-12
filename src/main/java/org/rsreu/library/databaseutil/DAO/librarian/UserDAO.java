package org.rsreu.library.databaseutil.DAO.librarian;

import org.rsreu.library.databaseutil.entity.User;
import org.rsreu.library.resource.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean insertUser(User user) throws SQLException {
        String query = DatabaseManager.getProperty("query.librarian.insert_user");
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, user.getType());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getStatus());
        statement.setString(5, user.getName());

        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    }

    public boolean updateUserStatus(Long userId, String status) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_user_status"));
        statement.setString(1, status);
        statement.setLong(2, userId);

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }

}
