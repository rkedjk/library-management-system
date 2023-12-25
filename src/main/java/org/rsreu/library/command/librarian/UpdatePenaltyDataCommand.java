package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.PenaltyAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdatePenaltyDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve parameters from the request
        Long penaltyId = Long.parseLong(request.getParameter("penaltyId"));
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        Integer validity = Integer.parseInt(request.getParameter("validity"));
        String reason = request.getParameter("reason");
        Date penaltyDate = null;
        Date expirationDate = null;
        try {
            penaltyDate = Date.valueOf(request.getParameter("penaltyDate"));
            expirationDate = Date.valueOf(request.getParameter("expirationDate"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            // Handle date parsing exception
        }
        Long librarianId = Long.parseLong(request.getParameter("librarianId"));

        // Instantiate the PenaltyAPI (or service class)
        PenaltyAPI penaltyAPI = new PenaltyAPI(); // Replace with your API or service class

        try {
            penaltyAPI.updatePenalty(penaltyId, readerId, String.valueOf(validity), reason, penaltyDate, expirationDate, librarianId);
            // Redirect to success page
            page = ConfigurationManager.getProperty("path.page.success");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.error");
        }

        return page;
    }
}
