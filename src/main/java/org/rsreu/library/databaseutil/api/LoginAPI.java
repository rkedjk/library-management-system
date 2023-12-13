package org.rsreu.library.databaseutil.api;

import org.rsreu.library.databaseutil.DAO.CredentialDAO;

import java.sql.SQLException;
import org.rsreu.library.databaseutil.OracleConnectionManager;
import org.rsreu.library.databaseutil.entity.User;

public class LoginAPI {

    private final CredentialDAO credentialDAO;
    public LoginAPI() {
        this.credentialDAO = new CredentialDAO(OracleConnectionManager.getConnection());
    }

    public boolean isAccountExisting(String login, String password) throws SQLException {
        return credentialDAO.getUserByLoginAndPassword(login, password) != null;
    }

    public String getUserType(String login, String password) throws SQLException {
        User user = credentialDAO.getUserByLoginAndPassword(login, password);
        if (user != null) {
            return user.getType();
        }
        return null;
    }


}