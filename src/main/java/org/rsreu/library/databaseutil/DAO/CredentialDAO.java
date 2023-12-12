package org.rsreu.library.databaseutil.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.rsreu.library.databaseutil.entity.User;
import org.rsreu.library.resource.DatabaseManager;

public class CredentialDAO {
    private final Connection connection;

    public CredentialDAO(Connection connection) {
        this.connection = connection;
    }
    public boolean insertUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.credential.insert_user"));

        statement.setString(1, user.getType());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getStatus());
        statement.setString(4, user.getName());

        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }
    public User getUserByLoginAndPassword(String login, String password) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.credential.get_user_by_login_and_pass"));
        statement.setString(1, login);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setType(resultSet.getString("TYPE"));
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setStatus(resultSet.getString("STATUS"));
            user.setName(resultSet.getString("NAME"));
        }

        return user;
    }

}
