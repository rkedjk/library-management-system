package org.rsreu.library.databaseutil.api;

import org.rsreu.library.databaseutil.entities.Account;
import org.rsreu.library.databaseutil.entityDAO.AccountDAO;
import org.rsreu.library.databaseutil.OracleConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManagementAPI {
    private final AccountDAO accountDAO;

    public UserManagementAPI() {
        this.accountDAO = new AccountDAO(OracleConnectionManager.getConnection());
    }

    public List<Account> searchUserByProperty(String property, String value) throws SQLException {
        switch (property.toLowerCase()) {
            case "id":
                try {
                    int id = Integer.parseInt(value);
                    List<Account> userByID = new ArrayList<>();
                    Account user = accountDAO.getUserById(id);
                    if (user != null) {
                        userByID.add(user);
                    }
                    return userByID;
                } catch (NumberFormatException e) {
                    // Handle invalid input for ID (non-integer value)
                    e.printStackTrace();
                    return new ArrayList<>();
                }

            case "name":
                return accountDAO.searchAccountsByName(value);

            case "type":
                return accountDAO.getUsersByType(value);

            case "status":
                if (value == "ACTIVE"){
                    return accountDAO.getActiveUsers();
                } else {
                    return accountDAO.getSuspendedAccounts();
                }

            // Add more cases for other properties if needed

            default:
                // Handle unknown property
                return new ArrayList<>();
        }
    }
    public void setUserActiveByID(int userId) throws SQLException {
        accountDAO.updateUserStatusById(userId,"ACTIVE");

    }

    public void setUserSuspendedByID(int userId) throws SQLException {
        accountDAO.updateUserStatusById(userId, "SUSPENDED");
    }

    public void addUser(Account newUser) throws SQLException {
        accountDAO.insertNewUser(newUser);
    }

    public void deleteUserByID(int userId) throws SQLException {
        accountDAO.deleteUserById(userId);
    }
}
