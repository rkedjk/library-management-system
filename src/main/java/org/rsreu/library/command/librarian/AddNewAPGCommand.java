package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.BookCatalogAPI;

import java.sql.SQLException;

public class AddNewAPGCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String command = request.getParameter("command");

        BookCatalogAPI bookCatalogAPI = new BookCatalogAPI();

        if (command != null) {
            switch (command) {
                case "insertAuthor":
                    String authorName = request.getParameter("authorName");
                    try {
                        bookCatalogAPI.insertAuthor(authorName);
                    } catch (SQLException e) {
                        // Handle the SQL exception
                        e.printStackTrace(); // Or log it
                    }
                    break;
                case "insertGenre":
                    String genreName = request.getParameter("genreName");
                    try {
                        bookCatalogAPI.insertGenre(genreName);
                    } catch (SQLException e) {
                        // Handle the SQL exception
                        e.printStackTrace(); // Or log it
                    }
                    break;
                case "insertPublisher":
                    String publisherName = request.getParameter("publisherName");
                    try {
                        bookCatalogAPI.insertPublisher(publisherName);
                    } catch (SQLException e) {
                        // Handle the SQL exception
                        e.printStackTrace(); // Or log it
                    }
                    break;
                default:
                    // Handle unknown command
                    break;
            }
            // Set the page to return to (success page)
            // For example:
            // page = ConfigurationManager.getProperty("successPage");
        }

        return page;
    }

}
