package org.rsreu.library.databaseutil.api;

import org.rsreu.library.databaseutil.DAO.admin.UserDAO;
import org.rsreu.library.databaseutil.OracleConnectionManager;
import org.rsreu.library.databaseutil.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManagementAPI {
    private final UserDAO userDAO;

    public UserManagementAPI() {
        Connection connection = OracleConnectionManager.getConnection(); // Obtain connection
        userDAO = new UserDAO(connection);
    }

    public List<Object> searchUsers(String searchType, String searchValue, String userType, String userStatus) throws SQLException {
        List<User> userList = new ArrayList<>();

        // Check different search types and perform appropriate search
        switch (searchType.toLowerCase()) {
            case "by id":
                // Search by ID
                long userId = Long.parseLong(searchValue);
                userList.add(userDAO.getUserById(userId));
                break;
            case "name":
                // Search by name
                userList.addAll(userDAO.searchUserByName(searchValue));
                break;
            case "type":
                // Search by type
                userList.addAll(userDAO.getUsersByType(userType));
                break;
            case "userstatus":
                // Search by user status
                userList.addAll(userDAO.getUsersByStatus(userStatus));
                break;
            case "type and userstatus":
                // Search by type and user status
                userList.addAll(userDAO.getUsersByTypeAndStatus(userType, userStatus));
                break;
            case "none":
            default:
                // Display all users if no specific search type is provided or search value is empty
                userList.addAll(userDAO.getAllUsers());
                break;
        }

        List<Object> convertedList = new ArrayList<>(userList);
        return convertedList;
    }

    public Object getUserById(long userId) throws SQLException {
        User user = userDAO.getUserById(userId);
        Object convertedUser = (Object) user; // Convert User to Object
        return convertedUser;
    }
    public boolean insertUser(String type, String login, String password, String status, String name) throws SQLException {
        User newUser = new User();
        newUser.setType(type);
        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setStatus(status);
        newUser.setName(name);
        return userDAO.insertUser(newUser);
    }

    public boolean updateUser(long userId, String type, String login, String password, String status, String name) throws SQLException {
        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setType(type);
        updatedUser.setLogin(login);
        updatedUser.setPassword(password);
        updatedUser.setStatus(status);
        updatedUser.setName(name);
        return userDAO.updateUser(updatedUser);
    }

    public boolean deleteUserById(long userId) throws SQLException {
        return userDAO.deleteUserById(userId);
    }

}
