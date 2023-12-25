package org.rsreu.library.databaseutil.DAO.admin;

import org.rsreu.library.databaseutil.entity.User;
import org.rsreu.library.resource.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The UserDAO class provides Data Access Object methods to interact with the user-related database operations.
 */
public class UserDAO {

    private final Connection connection; // Database connection

    /**
     * Constructs a UserDAO with a database connection.
     *
     * @param connection The database connection
     */
    public UserDAO(Connection connection) {
        this.connection = connection;
    }
    // Full JavaDocs for each method...

    /**
     * Retrieves a list of all users from the database.
     *
     * @return A list of all users
     * @throws SQLException If an SQL exception occurs
     */
    public List<User> getAllUsers() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.get_all_users"));
        ResultSet resultSet = statement.executeQuery();

        List<User> userList = new ArrayList<>();
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
    /**
     * Inserts a new user into the database.
     *
     * @param user The user object to insert
     * @return True if insertion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
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
    /**
     * Retrieves a user by their ID from the database.
     *
     * @param userId The ID of the user to retrieve
     * @return The user object corresponding to the given ID
     * @throws SQLException If an SQL exception occurs
     */
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
    /**
     * Updates an existing user in the database.
     *
     * @param user The user object with updated information
     * @return True if the update is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
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
    /**
     * Deletes a user from the database by their ID.
     *
     * @param userId The ID of the user to delete
     * @return True if the deletion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean deleteUserById(Long userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.admin.delete_user_by_id"));
        statement.setLong(1, userId);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }
    /**
     * Retrieves a list of users based on a specific user type.
     *
     * @param userType The type of user to search for
     * @return A list of users matching the specified type
     * @throws SQLException If an SQL exception occurs
     */
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
    /**
     * Searches for users by their name in the database.
     *
     * @param name The name of the user to search for
     * @return A list of users matching the provided name
     * @throws SQLException If an SQL exception occurs
     */
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
    /**
     * Retrieves a list of users based on a specific user type and status.
     *
     * @param userType The type of user to search for
     * @param status   The status of the user to search for
     * @return A list of users matching the specified type and status
     * @throws SQLException If an SQL exception occurs
     */
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
    /**
     * Retrieves a list of users based on a specific user status.
     *
     * @param status The status of the user to search for
     * @return A list of users matching the specified status
     * @throws SQLException If an SQL exception occurs
     */
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
