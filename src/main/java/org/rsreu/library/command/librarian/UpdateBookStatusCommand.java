package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.BookInventoryAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class UpdateBookStatusCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve parameters from the request
        String status = request.getParameter("status");
        Long inventoryId = Long.parseLong(request.getParameter("inventoryId"));

        // Instantiate the BookInventoryAPI (or service class)
        BookInventoryAPI bookInventoryAPI = new BookInventoryAPI(); // Replace with your API or service class

        try {
            bookInventoryAPI.updateBookStatus(status, inventoryId);
            // Book status updated successfully
            page = ConfigurationManager.getProperty("path.page.success"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
