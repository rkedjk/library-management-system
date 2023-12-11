package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.resource.ConfigurationManager;

import java.io.IOException;

public class LibrarianDashboardCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request){
        String page = null;
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add_new_book":
                    page = ConfigurationManager.getProperty("path.page.add_new_book");
                    // Logic to handle adding a new book
                    break;
                case "update_book_details":
                    page = ConfigurationManager.getProperty("path.page.update_book_details");
                    // Logic to handle updating book details
                    break;
                case "search_books":
                    page = ConfigurationManager.getProperty("path.page.search_books");
                    // Logic to handle searching books
                    break;
                case "manage_orders":
                    page = ConfigurationManager.getProperty("path.page.manage_orders");
                    // Logic to handle managing orders
                    break;
                case "search_books_l":
                    page = ConfigurationManager.getProperty("path.page.search_books_l");
                    // Logic to handle managing orders
                    break;
                default:
                    // Handle if action is not recognized
                    break;
            }
        }

        return page;
    }
}
