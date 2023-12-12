package org.rsreu.library.databaseutil.entityDAO;

import java.sql.*;
import java.util.ArrayList;

import org.rsreu.library.databaseutil.resourcer.*;
import java.util.List;

public class AccountDAO {
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    public Account getUserByCredentials(String login, String password) throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.get_user_by_credentials");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Account(
                            resultSet.getInt(RESOURCER.getString("accounts.id")),
                            resultSet.getString(RESOURCER.getString("accounts.type")),
                            resultSet.getString(RESOURCER.getString("accounts.login")),
                            resultSet.getString(RESOURCER.getString("accounts.password")),
                            resultSet.getString(RESOURCER.getString("accounts.status")),
                            resultSet.getString(RESOURCER.getString("accounts.name"))
                    );
                }
            }
        }
        return null;
    }

    public List<Account> getAllUsers() throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.get_all_users");

        List<Account> accounts = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getInt(RESOURCER.getString("accounts.id")),
                        resultSet.getString(RESOURCER.getString("accounts.type")),
                        resultSet.getString(RESOURCER.getString("accounts.login")),
                        resultSet.getString(RESOURCER.getString("accounts.password")),
                        resultSet.getString(RESOURCER.getString("accounts.status")),
                        resultSet.getString(RESOURCER.getString("accounts.name"))
                );
                accounts.add(account);
            }
        }
        return accounts;
    }

    public Account getUserById(int id) throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.get_user_by_id");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Account(
                            resultSet.getInt(RESOURCER.getString("accounts.id")),
                            resultSet.getString(RESOURCER.getString("accounts.type")),
                            resultSet.getString(RESOURCER.getString("accounts.login")),
                            resultSet.getString(RESOURCER.getString("accounts.password")),
                            resultSet.getString(RESOURCER.getString("accounts.status")),
                            resultSet.getString(RESOURCER.getString("accounts.name"))
                    );
                }
            }
        }
        return null;
    }

    public List<Account> searchAccountsByName(String name) throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.get_user_by_name");

        List<Account> accounts = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = new Account(
                            resultSet.getInt(RESOURCER.getString("accounts.id")),
                            resultSet.getString(RESOURCER.getString("accounts.type")),
                            resultSet.getString(RESOURCER.getString("accounts.login")),
                            resultSet.getString(RESOURCER.getString("accounts.password")),
                            resultSet.getString(RESOURCER.getString("accounts.status")),
                            resultSet.getString(RESOURCER.getString("accounts.name"))
                    );
                    accounts.add(account);
                }
            }

        }
        return accounts;
    }

    public List<Account> getSuspendedAccounts() throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.get_suspended_users");

        List<Account> suspendedAccounts = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getInt(RESOURCER.getString("accounts.id")),
                        resultSet.getString(RESOURCER.getString("accounts.type")),
                        resultSet.getString(RESOURCER.getString("accounts.login")),
                        resultSet.getString(RESOURCER.getString("accounts.password")),
                        resultSet.getString(RESOURCER.getString("accounts.status")),
                        resultSet.getString("NAME")
                );
                suspendedAccounts.add(account);
            }
        }
        return suspendedAccounts;
    }

    public List<Account> getActiveUsers() throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.get_active_users");

        List<Account> accounts = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getInt(RESOURCER.getString("accounts.id")),
                        resultSet.getString(RESOURCER.getString("accounts.type")),
                        resultSet.getString(RESOURCER.getString("accounts.login")),
                        resultSet.getString(RESOURCER.getString("accounts.password")),
                        resultSet.getString(RESOURCER.getString("accounts.status")),
                        resultSet.getString(RESOURCER.getString("accounts.name"))
                );
                accounts.add(account);
            }
        }
        return accounts;
    }

    public List<Account> getUsersByType(String type) throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.get_users_by_type");

        List<Account> accounts = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, type);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Account account = new Account(
                            resultSet.getInt(RESOURCER.getString("accounts.id")),
                            resultSet.getString(RESOURCER.getString("accounts.type")),
                            resultSet.getString(RESOURCER.getString("accounts.login")),
                            resultSet.getString(RESOURCER.getString("accounts.password")),
                            resultSet.getString(RESOURCER.getString("accounts.status")),
                            resultSet.getString(RESOURCER.getString("accounts.name"))
                    );
                    accounts.add(account);
                }
            }
        }
        return accounts;
    }

    public void updateUserStatusById(int id, String newStatus) throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.update_user_status_by_id");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public void deleteUserById(int id) throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.delete_user_by_id");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public void insertNewUser(Account newUser) throws SQLException {
        final Resourcer RESOURCER = ProjectResourcer.getInstance();
        String query = RESOURCER.getString("accounts.query.insert_new_user");

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newUser.getId());
            preparedStatement.setString(2, newUser.getType());
            preparedStatement.setString(3, newUser.getLogin());
            preparedStatement.setString(4, newUser.getPassword());
            preparedStatement.setString(5, newUser.getStatus());
            preparedStatement.setString(6, newUser.getName());

            preparedStatement.executeUpdate();
        }
    }


}
