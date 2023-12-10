package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import org.rsreu.library.resource.ConfigurationManager;

public class UserDashboardCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "search_books":
                    page = ConfigurationManager.getProperty("path.page.search_books");
                    break;
                case "request_reservation":
                    page = ConfigurationManager.getProperty("path.page.request_reservation");
                    break;
                case "request_available_books":
                    page = ConfigurationManager.getProperty("path.page.request_available_books");
                    break;
                case "reservation_history":
                    page = ConfigurationManager.getProperty("path.page.reservation_history");
                    break;
                default:
                    // Handle if action is not recognized
                    break;
            }
        }

        return page;
    }
}
