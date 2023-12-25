package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.BookCatalogAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class InsertEntityCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String entityType = request.getParameter("entityType");
        String entityName = request.getParameter("entityName");

        // Instantiate the LibraryManagementAPI (or service class)
        BookCatalogAPI libraryManagementAPI = new BookCatalogAPI(); // Replace with your API or service class

        try {
            switch (entityType) {
                case "author":
                    libraryManagementAPI.insertAuthor(entityName);
                    break;
                case "genre":
                    libraryManagementAPI.insertGenre(entityName);
                    break;
                case "publisher":
                    libraryManagementAPI.insertPublisher(entityName);
                    break;
                default:
                    // Handle other cases or leave it blank if not needed
                    break;
            }
            // Entity inserted successfully
            page = ConfigurationManager.getProperty("path.page.success"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
