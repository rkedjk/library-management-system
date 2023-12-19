package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.BookCatalogAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.BookCatalog;

import java.sql.SQLException;

public class UpdateBookDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String title = request.getParameter("title");
        int yearPublished = Integer.parseInt(request.getParameter("yearPublished"));
        String authorName = request.getParameter("authorName");
        String genreName = request.getParameter("genreName");
        String publisherName = request.getParameter("publisherName");
        Long bookId = Long.parseLong(request.getParameter("bookId"));

        BookCatalogAPI bookCatalogAPI = new BookCatalogAPI();

        try {
            bookCatalogAPI.updateBookCatalog(title, yearPublished, authorName, genreName, publisherName, bookId);
            // Redirect to success page or display success message
            page = ConfigurationManager.getProperty("path.page.updateSuccess"); // Redirect to success page
        } catch (SQLException e) {
            // Handle exception, redirect to an error page, or display an error message
            e.printStackTrace();
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
