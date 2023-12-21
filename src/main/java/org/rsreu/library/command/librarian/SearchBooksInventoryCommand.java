package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.BookInventoryAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class SearchBooksInventoryCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String searchType = request.getParameter("searchType");
        String searchValue = request.getParameter("searchValue");

        BookInventoryAPI bookCatalogAPI = new BookInventoryAPI();
        try {
            List<Object> bookList = bookCatalogAPI.searchBooks(searchType, searchValue);
            request.setAttribute("bookList", bookList);
            page = ConfigurationManager.getProperty("path.page.searchBooksInventoryResult"); // Redirect to search results page
        } catch (SQLException | IllegalArgumentException e) {
            // Handle exception, redirect to an error page, or display an error message
            e.printStackTrace();
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
