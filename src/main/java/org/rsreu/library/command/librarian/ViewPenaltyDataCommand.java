package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.PenaltyAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class ViewPenaltyDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve parameter - penalty ID
        Long penaltyId = Long.parseLong(request.getParameter("penaltyId"));

        // Instantiate the PenaltyAPI (or service class)
        PenaltyAPI penaltyAPI = new PenaltyAPI(); // Replace with your API or service class

        try {
            // Fetch penalty data by ID
            // Use this data in the JSP for viewing/editing

            request.setAttribute("penaltyData", penaltyAPI.getPenaltyById(penaltyId));
            page = ConfigurationManager.getProperty("path.page.viewPenaltyData");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.error");
        }

        return page;
    }
}
