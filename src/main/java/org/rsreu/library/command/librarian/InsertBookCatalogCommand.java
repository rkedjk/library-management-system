package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.BookCatalogAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class InsertBookCatalogCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve parameters from the request
        String title = request.getParameter("title");
        int yearPublished = Integer.parseInt(request.getParameter("yearPublished"));
        String authorName = request.getParameter("authorName");
        String genreName = request.getParameter("genreName");
        String publisherName = request.getParameter("publisherName");

        // Instantiate the BookCatalogAPI (or service class)
        BookCatalogAPI bookCatalogAPI = new BookCatalogAPI(); // Replace with your API or service class

        try {
            bookCatalogAPI.insertBookCatalog(title, yearPublished, authorName, genreName, publisherName);
            // Book catalog inserted successfully
            page = ConfigurationManager.getProperty("path.page.bookCatalogInserted"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.bookCatalogInsertError"); // Redirect to error page
        }

        return page;
    }
}
