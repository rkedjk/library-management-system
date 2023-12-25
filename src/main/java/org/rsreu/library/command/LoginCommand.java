package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.resource.MessageManager;
import org.rsreu.library.databaseutil.api.LoginAPI;
import org.rsreu.library.databaseutil.entity.User;

import java.io.IOException;
import java.sql.SQLException;


public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        if (request.getSession() != null) {
            request.getSession().invalidate(); // Invalidate the session, clearing all session data
        }
        try {
            String login = request.getParameter(PARAM_NAME_LOGIN);
            String pass = request.getParameter(PARAM_NAME_PASSWORD);

            LoginAPI loginAPI = new LoginAPI();
            User user = loginAPI.getUserByLoginAndPassword(login, pass);

            if (user != null) {
                HttpSession session = request.getSession();
                int sessionTimeoutSeconds = 1800; // 30 минут * 60 секунд
                session.setMaxInactiveInterval(sessionTimeoutSeconds);
                session.setAttribute("user", user);
                session.setAttribute("isAuthorized","True");
                switch (user.getType()) {
                    case "ADMIN":
                        page = ConfigurationManager.getProperty("path.page.admin_dashboard");
                        break;
                    case "LIBRARIAN":
                        page = ConfigurationManager.getProperty("path.page.librarian_dashboard");
                        break;
                    case "READER":
                        page = ConfigurationManager.getProperty("path.page.reader_dashboard");
                        break;
                    default:
                        // Handle unrecognized user type
                        break;
                }
            } else {
                request.setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("message.loginerror"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while processing your request.");
            page = "error.jsp";
        }
        return page;
    }
}