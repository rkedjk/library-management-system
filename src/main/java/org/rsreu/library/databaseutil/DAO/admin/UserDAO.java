package org.rsreu.library.databaseutil.DAO.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.rsreu.library.databaseutil.entity.User;
import org.rsreu.library.resource.DatabaseManager;
import java.util.List;
import java.util.ArrayList;

public class UserDAO {

    private final Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean insertUser(User user) throws SQLException {
        String query = DatabaseManager.getProperty("query.admin.insert_user");
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, user.getType());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getStatus());
        statement.setString(5, user.getName());

        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    }

    public User getUserById(Long userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.get_user_by_id"));
        statement.setLong(1, userId);
        ResultSet resultSet = statement.executeQuery();

        User user = new User();
        if (resultSet.next()) {
            user.setId(resultSet.getLong("ID"));
            user.setType(resultSet.getString("TYPE"));
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setStatus(resultSet.getString("STATUS"));
            user.setName(resultSet.getString("NAME"));
        }

        return user;
    }

    public boolean updateUser(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.update_user"));

        statement.setString(1, user.getType());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getStatus());
        statement.setString(5, user.getName());
        statement.setLong(6, user.getId());

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }

    public boolean deleteUserById(Long userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.delete_user_by_id"));
        statement.setLong(1, userId);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }

    public List<User> getUsersByType(String userType) throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.get_users_by_type"));
        statement.setString(1, userType);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setType(resultSet.getString("TYPE"));
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setStatus(resultSet.getString("STATUS"));
            user.setName(resultSet.getString("NAME"));

            userList.add(user);
        }

        return userList;
    }

    public List<User> getActiveUsers(String status) throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.get_active_users"));
        statement.setString(1, status);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setType(resultSet.getString("TYPE"));
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setStatus(resultSet.getString("STATUS"));
            user.setName(resultSet.getString("NAME"));

            userList.add(user);
        }

        return userList;
    }

    public List<User> searchUserByName(String name) throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.search_user_by_name"));
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setType(resultSet.getString("TYPE"));
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setStatus(resultSet.getString("STATUS"));
            user.setName(resultSet.getString("NAME"));

            userList.add(user);
        }

        return userList;
    }

    public List<User> getUsersByTypeAndStatus(String userType, String status) throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.get_users_by_type_and_status"));
        statement.setString(1, userType);
        statement.setString(2, status);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setType(resultSet.getString("TYPE"));
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setStatus(resultSet.getString("STATUS"));
            user.setName(resultSet.getString("NAME"));

            userList.add(user);
        }

        return userList;
    }

    public List<User> getUsersByStatus(String status) throws SQLException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.get_users_by_status"));
        statement.setString(1, status);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setType(resultSet.getString("TYPE"));
            user.setLogin(resultSet.getString("LOGIN"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setStatus(resultSet.getString("STATUS"));
            user.setName(resultSet.getString("NAME"));

            userList.add(user);
        }

        return userList;
    }
}
