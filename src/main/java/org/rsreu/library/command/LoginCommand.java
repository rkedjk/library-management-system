package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.resource.MessageManager;
import org.rsreu.library.databaseutil.api.LoginAPI;

import java.io.IOException;
import java.sql.SQLException;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        try {

        // Extracting login and password from the request
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        LoginAPI loginAPI = new LoginAPI();
        if (loginAPI.isAccountExisting(login, pass)) {
            String userType = loginAPI.getUserType(login, pass);

            if (userType != null) {
                request.setAttribute("user", login);

                // Determining the path based on user type from LoginLogic
                switch (userType) {
                    case "ADMIN":
                        page = ConfigurationManager.getProperty("path.page.admin_dashboard");
                        break;
                    case "LIBRARIAN":
                        page = ConfigurationManager.getProperty("path.page.librarian_dashboard");
                        break;
                    case "READER":
                        page = ConfigurationManager.getProperty("path.page.reader_dashboard");
                        break;
                    // Handle additional user types if needed
                    default:
                        // Handle unrecognized user type
                        break;
                }
            } else {
                request.setAttribute("errorLoginPassMessage",
                        MessageManager.getProperty("message.loginerror"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }  } catch (SQLException e) {
            // Handle the SQLException here or log it
            e.printStackTrace(); // This is an example, handle it according to your needs
            // Optionally, you can set an error attribute or redirect to an error page
            request.setAttribute("error", "An error occurred while processing your request.");
            page = "error.jsp"; // Set the error page or any other appropriate page
        }
        return page;
    }
}