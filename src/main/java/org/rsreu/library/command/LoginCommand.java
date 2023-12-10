package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import org.rsreu.library.logic.LoginLogic;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.resource.MessageManager;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        // Extracting login and password from the request
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);

        // Checking login and password using LoginLogic
        LoginLogic.UserType userType = LoginLogic.checkLogin(login, pass);

        if (userType != null) {
            request.setAttribute("user", login);

            // Determining the path based on user type from LoginLogic
            switch (userType) {
                case ADMIN:
                    page = ConfigurationManager.getProperty("path.page.admin_dashboard");
                    break;
                case LIBRARIAN:
                    page = ConfigurationManager.getProperty("path.page.librarian_dashboard");
                    break;
                case USER:
                    page = ConfigurationManager.getProperty("path.page.user_dashboard");
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
        return page;
    }
}
