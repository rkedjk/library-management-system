package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.BookCatalogAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class AddNewCopyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String title = request.getParameter("title");
        int yearPublished = Integer.parseInt(request.getParameter("yearPublished"));
        String authorName = request.getParameter("authorName");
        String genreName = request.getParameter("genreName");
        String publisherName = request.getParameter("publisherName");

        BookCatalogAPI bookCatalogAPI = new BookCatalogAPI();
        try {
            bookCatalogAPI.insertBookCatalog(title, yearPublished, authorName, genreName, publisherName);
            page = ConfigurationManager.getProperty("path.page.success"); // Redirect to success page
        } catch (SQLException e) {
            // Handle exception, redirect to an error page, or display an error message
            e.printStackTrace();
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
