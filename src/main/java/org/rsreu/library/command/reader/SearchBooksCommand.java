package org.rsreu.library.command.reader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.reader.ReaderAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class SearchBooksCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        try {
            String searchType = request.getParameter("searchType");
            String searchValue = request.getParameter("searchValue");

            ReaderAPI readerAPI = new ReaderAPI();
            List<Object> bookList = readerAPI.searchBookCatalog(searchType, searchValue);

            // Fetching available book copies based on the obtained book list
            // Here, assuming the book ID is available at index 0 of each object in the book list
            for (Object book : bookList) {
                Long bookId = (Long) ((Object[]) book)[0];
                List<Object[]> availableBooks = readerAPI.getNumBooksById(bookId);
                ((Object[]) book)[7] = availableBooks; // Assuming index 7 for available books in the array
            }

            request.setAttribute("bookList", bookList);
            page = ConfigurationManager.getProperty("path.page.viewBookList");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while processing your request.");
            page = "error.jsp";
        }

        return page;
    }
}
