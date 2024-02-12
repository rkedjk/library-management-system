package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.BookCatalogAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class SearchBookCatalogCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve parameters from the request
        String searchType = request.getParameter("searchType");
        String searchValue = request.getParameter("searchValue");

        // Instantiate the BookCatalogAPI (or service class)
        BookCatalogAPI bookCatalogAPI = new BookCatalogAPI(); // Replace with your API or service class

        try {
            List<Object> bookList = bookCatalogAPI.searchBookCatalog(searchType, searchValue);
            request.setAttribute("bookList", bookList);
            page = ConfigurationManager.getProperty("path.page.searchBookCatalogResult"); // Redirect to result page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
