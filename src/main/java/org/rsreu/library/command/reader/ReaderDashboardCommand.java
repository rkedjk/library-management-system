package org.rsreu.library.command.reader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.reader.ReaderAPI;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.User;
import java.sql.SQLException;
import java.util.List;

public class ReaderDashboardCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
         // Instantiate this service in your constructor
        // Constructor to initialize the LibraryService (dependency injection)

        ReaderAPI readerAPI = new ReaderAPI();
        String page = null;
        String action = request.getParameter("action");
        User user = (User) request.getSession().getAttribute("user");
        if (action != null) {
            switch (action) {
                case "search_books":
                    page = ConfigurationManager.getProperty("path.page.search_books");
                    break;
                case "request_reservation":
                    page = ConfigurationManager.getProperty("path.page.request_reservation");
                    break;
                case "request_available_books":
                    try {
                        String status = "AVAILABLE"; // Status for available books
                        List<Object[]> availableBooks = readerAPI.getNumBooksByStatus(status);
                        request.setAttribute("availableBooks", availableBooks);
                        page = ConfigurationManager.getProperty("path.page.request_available_books");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        // Handle SQL exception
                        page = ConfigurationManager.getProperty("path.page.error");
                    }
                    break;
                case "reservation_history":
                    page = ConfigurationManager.getProperty("path.page.reservation_history");
                    break;
                case "request_fines":
                    try {
                        Long userId = user.getId(); // Assuming the user ID is in 'id' attribute
                        List<Object> fines = readerAPI.getPenaltiesByReaderId(userId);
                        request.setAttribute("fines", fines);
                        page = ConfigurationManager.getProperty("path.page.request_fines");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        // Handle SQL exception
                        page = ConfigurationManager.getProperty("path.page.error");
                    }
                    break;

                case "loans_history":
                    try {
                        Long userId = user.getId(); // Assuming the user ID is in 'id' attribute
                        List<Object> loans = readerAPI.getLoansByReaderId(userId);
                        request.setAttribute("loans", loans);
                        page = ConfigurationManager.getProperty("path.page.loans_history");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        // Handle SQL exception
                        page = ConfigurationManager.getProperty("path.page.error");
                    }
                    break;
                case "rate_book":
                    page = ConfigurationManager.getProperty("path.page.rate_book_form");
                    break;
                default:
                    // Handle if action is not recognized
                    break;
            }
        }

        return page;
    }
}
