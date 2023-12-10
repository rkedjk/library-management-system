package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import org.rsreu.library.resource.ConfigurationManager;

public class AdminDashboardCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add_user":
                    page = ConfigurationManager.getProperty("path.page.manage_users");
                    // Logic to handle adding a new user
                    break;

                default:
                    // Handle if action is not recognized
                    break;
            }
        }

        return page;
    }
}
