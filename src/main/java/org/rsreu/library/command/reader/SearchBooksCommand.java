package org.rsreu.library.command.reader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.reader.ReaderAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.BookCatalog;
import org.rsreu.library.databaseutil.entity.ExtendedBook;

import java.util.ArrayList;
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
            List<BookCatalog> bookList = readerAPI.searchBookCatalogObject(searchType, searchValue);

            // Create a new list to store books with ratings
            List<ExtendedBook> extendedBooks = new ArrayList<>();

            // Fetch ratings for each book and combine it with book information
            for (BookCatalog book : bookList) {
                int rating = readerAPI.getRatingByBookId(book.getBookId());
                ExtendedBook extendedBook = new ExtendedBook(book, rating);
                extendedBooks.add(extendedBook);
            }

            // Set the extended book list as a request attribute
            request.setAttribute("bookList", extendedBooks);
            page = ConfigurationManager.getProperty("path.page.viewBookList");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "An error occurred while processing your request.");
            page = ConfigurationManager.getProperty("path.page.error");
        }

        return page;
    }
}
