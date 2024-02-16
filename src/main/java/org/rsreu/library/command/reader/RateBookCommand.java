package org.rsreu.library.command.reader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.reader.ReaderAPI;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.User;
import java.sql.SQLException;

public class RateBookCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ReaderAPI readerAPI = new ReaderAPI();
        String page = null;
        String bookIdString = request.getParameter("bookId");
        String rating = request.getParameter("rating");
        User user = (User) request.getSession().getAttribute("user");

        if (bookIdString != null && rating != null && user != null) {
            try {
                Long bookId = Long.parseLong(bookIdString);
                // Assuming you have a method in ReaderAPI to handle book rating
                boolean ratingSuccess = readerAPI.rateBook(user.getId(), bookId, rating);

                if (ratingSuccess) {
                    page = ConfigurationManager.getProperty("path.page.success");
                } else {
                    page = ConfigurationManager.getProperty("path.page.error");
                    request.setAttribute("error", "Failed to rate the book");
                }
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
                page = ConfigurationManager.getProperty("path.page.error");
                request.setAttribute("error", "An error occurred while processing your request.");
            }
        } else {
            page = ConfigurationManager.getProperty("path.page.error");
            request.setAttribute("error", "Invalid parameters provided for rating the book.");
        }

        return page;
    }
}
