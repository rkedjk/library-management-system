package org.rsreu.library.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.LoanAPI;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.util.List;

public class GetUserLoansCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        Long userId = Long.parseLong(request.getParameter("userId"));
        LoanAPI loanAPI = new LoanAPI();

        try {
            List<Object> loans = loanAPI.getLoansByReader(userId);
            request.setAttribute("loans", loans);
            page = ConfigurationManager.getProperty("path.page.displayUserLoans"); // Next page to display user loans
        } catch (SQLException e) {
            // Handle exception, redirect to an error page, or display an error message
            e.printStackTrace();
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
