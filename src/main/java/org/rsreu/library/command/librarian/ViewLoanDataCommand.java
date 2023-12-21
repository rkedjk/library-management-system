package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.LoanAPI;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.command.ActionCommand;
import java.sql.SQLException;

public class ViewLoanDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        Long loanId = Long.parseLong(request.getParameter("loanId"));

        LoanAPI loanAPI = new LoanAPI(); // Replace with your API or service class

        try {
            Object loanData = loanAPI.getLoanById(loanId); // Retrieve loan data
            request.setAttribute("loanData", loanData);
            page = ConfigurationManager.getProperty("path.page.viewEditLoanData"); // Redirect to view and edit loan data page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception and redirect to an error page
            page = ConfigurationManager.getProperty("path.page.error");
        }

        return page;
    }
}
