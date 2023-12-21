package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.PenaltyAPI;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.User;

import java.sql.Date;
import java.sql.SQLException;

public class InsertPenaltyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve parameters from the request
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        String validity = request.getParameter("validity");
        String reason = request.getParameter("reason");
        Date penaltyDate = Date.valueOf(request.getParameter("penaltyDate"));
        Date expirationDate = Date.valueOf(request.getParameter("expirationDate"));

        // Retrieve librarian ID from the session
        User user = (User) request.getSession().getAttribute("user");
        Long librarianId = user.getId(); // Assuming the ID is available in 'id' attribute of User object

        // Instantiate the LibraryManagementAPI (or service class)
        PenaltyAPI libraryManagementAPI = new PenaltyAPI(); // Replace with your API or service class

        try {
            libraryManagementAPI.insertPenalty(readerId, validity, reason, penaltyDate, expirationDate, librarianId);
            // Penalty inserted successfully
            page = ConfigurationManager.getProperty("path.page.penaltyInserted"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.penaltyInsertError"); // Redirect to error page
        }

        return page;
    }
}
