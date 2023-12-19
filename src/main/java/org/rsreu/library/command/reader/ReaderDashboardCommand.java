package org.rsreu.library.command.reader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;

public class ReaderDashboardCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
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
                case "request_fines":
                    page = ConfigurationManager.getProperty("path.page.request_fines");
                    break;
                case "loans_history":
                    page = ConfigurationManager.getProperty("path.page.loans_history");
                default:
                    // Handle if action is not recognized
                    break;
            }
        }

        return page;
    }
}
