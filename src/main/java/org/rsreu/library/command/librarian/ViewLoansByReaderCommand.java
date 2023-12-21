package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.LoanAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class ViewLoansByReaderCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve reader ID from the request
        Long readerId = Long.parseLong(request.getParameter("readerId"));

        // Instantiate the LoanAPI (or service class)
        LoanAPI loanAPI = new LoanAPI(); // Replace with your API or service class

        try {
            List<Object> readerLoans = loanAPI.getLoansByReader(readerId);
            request.setAttribute("readerLoans", readerLoans);
            page = ConfigurationManager.getProperty("path.page.viewLoansByReader"); // Redirect to loans page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.viewLoansByReaderError"); // Redirect to error page
        }

        return page;
    }
}
