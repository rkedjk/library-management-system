package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.PenaltyAPI;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.Penalty;

import java.sql.SQLException;
import java.util.List;

public class ViewPenaltiesByReaderCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve reader ID from the request
        Long readerId = Long.parseLong(request.getParameter("readerId"));

        // Instantiate the PenaltyAPI (or service class)
        PenaltyAPI penaltyAPI = new PenaltyAPI(); // Replace with your API or service class

        try {
            List<Penalty> readerPenalties = penaltyAPI.getPenaltiesByReaderID(readerId);
            request.setAttribute("readerPenalties", readerPenalties);
            page = ConfigurationManager.getProperty("path.page.viewPenaltiesByReader"); // Redirect to penalties page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.viewPenaltiesByReaderError"); // Redirect to error page
        }

        return page;
    }
}
