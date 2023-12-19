package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.PenaltyAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class ViewEditPenaltyDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        Long readerId = Long.parseLong(request.getParameter("readerId"));
        PenaltyAPI penaltyAPI = new PenaltyAPI();

        try {
            // Fetch penalty details by ID using PenaltyAPI
            // Assuming getPenaltyDetailsById returns an array of parameters or a custom DTO
            Object[] penaltyDetails = new List[]{penaltyAPI.getPenaltiesByReaderID(readerId)};

            // Set individual parameters as request attributes
            request.setAttribute("penaltyId", penaltyDetails[0]); // Assuming penaltyId is at index 0
            request.setAttribute("readerId", penaltyDetails[1]); // Assuming readerId is at index 1
            request.setAttribute("validity", penaltyDetails[2]); // Assuming validity is at index 2
            request.setAttribute("reason", penaltyDetails[3]); // Assuming reason is at index 3
            request.setAttribute("penaltyDate", penaltyDetails[4]); // Assuming penaltyDate is at index 4
            request.setAttribute("expirationDate", penaltyDetails[5]); // Assuming expirationDate is at index 5
            request.setAttribute("librarianId", penaltyDetails[6]); // Assuming librarianId is at index 6

            page = ConfigurationManager.getProperty("path.page.viewEditPenaltyDetails"); // Next page to view/edit penalty details
        } catch (SQLException e) {
            // Handle exception, redirect to an error page, or display an error message
            e.printStackTrace();
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
