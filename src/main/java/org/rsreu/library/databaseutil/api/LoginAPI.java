package org.rsreu.library.databaseutil.api;

import org.rsreu.library.databaseutil.entityDAO.AccountDAO;
import org.rsreu.library.databaseutil.entities.Account;
import java.sql.SQLException;
import org.rsreu.library.databaseutil.OracleConnectionManager;
public class LoginAPI {

    private final AccountDAO accountDAO;
    public LoginAPI() {
        this.accountDAO = new AccountDAO(OracleConnectionManager.getConnection());
    }

    public boolean isAccountExisting(String login, String password) throws SQLException {
        return accountDAO.getUserByCredentials(login, password) != null;
    }

    public String getUserType(String login, String password) throws SQLException {
        Account user = accountDAO.getUserByCredentials(login, password);
        if (user != null) {
            return user.getType();
        }
        return null;
    }
}