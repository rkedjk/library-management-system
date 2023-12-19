package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.PenaltyAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.sql.Date; // Using java.sql.Date directly
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdatePenaltyDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        Long penaltyId = Long.parseLong(request.getParameter("penaltyId"));
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        String validity = String.valueOf(request.getParameter("validity"));
        String reason = request.getParameter("reason");
        Date penaltyDate = null;
        Date expirationDate = null;
        Long librarianId = Long.parseLong(request.getParameter("librarianId"));

        try {
            // Parsing penaltyDate and expirationDate as java.sql.Date directly
            penaltyDate = Date.valueOf(request.getParameter("penaltyDate"));
            expirationDate = Date.valueOf(request.getParameter("expirationDate"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            // Handle date parsing error - redirect to an error page or display an error message
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
            return page;
        }

        PenaltyAPI penaltyAPI = new PenaltyAPI();
        try {
            penaltyAPI.updatePenalty(penaltyId, readerId, validity, reason, (java.sql.Date) penaltyDate, (java.sql.Date) expirationDate, librarianId);
            // Redirect to success page or display success message
            page = ConfigurationManager.getProperty("path.page.penaltyUpdateSuccess"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle penalty update error - redirect to an error page or display an error message
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
