package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.BookInventoryAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.awt.print.Book;
import java.sql.SQLException;

public class InsertBookInventoryCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve parameters from the request
        String location = request.getParameter("location");
        String status = request.getParameter("status");
        Long bookId = Long.parseLong(request.getParameter("bookId"));

        // Instantiate the LibrarianAPI (or service class)
        BookInventoryAPI librarianAPI = new BookInventoryAPI(); // Replace with your API or service class

        try {
            librarianAPI.insertBookInventory(location, status, bookId);
            // Book inventory inserted successfully
            page = ConfigurationManager.getProperty("path.page.success"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
