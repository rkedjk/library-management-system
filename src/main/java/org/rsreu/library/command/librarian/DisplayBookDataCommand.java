package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.BookCatalogAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.BookCatalog; // Import your BookCatalog model

import java.sql.SQLException;

public class DisplayBookDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String bookId = String.join(request.getParameter("bookId"));
        BookCatalogAPI bookCatalogAPI = new BookCatalogAPI();

        try {
            BookCatalog book = (BookCatalog) bookCatalogAPI.searchBookCatalog("id",bookId); // Implement method to get book details by ID
            request.setAttribute("book", book);
            page = ConfigurationManager.getProperty("path.page.displayBookDetails"); // Next page to display book details
        } catch (SQLException e) {
            // Handle exception, redirect to an error page, or display an error message
            e.printStackTrace();
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
