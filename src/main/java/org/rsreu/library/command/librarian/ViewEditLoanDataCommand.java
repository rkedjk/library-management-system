package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.LoanAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;

public class ViewEditLoanDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        Long readerId = Long.parseLong(request.getParameter("readerId"));
        LoanAPI loanAPI = new LoanAPI();

        try {
            // Fetch loan details by ID using LoanAPI
            // Assuming getLoanDetailsById returns an array of parameters or a custom DTO
            Object[] loanDetails = (Object[]) loanAPI.getLoanById(readerId);

            // Set individual parameters as request attributes
            request.setAttribute("loanId", loanDetails[0]); // Assuming loanId is at index 0
            request.setAttribute("inventoryId", loanDetails[1]); // Assuming inventoryId is at index 1
            request.setAttribute("readerId", loanDetails[2]); // Assuming readerId is at index 2
            request.setAttribute("loanDate", loanDetails[3]); // Assuming loanDate is at index 3
            request.setAttribute("dueDate", loanDetails[4]); // Assuming dueDate is at index 4
            request.setAttribute("returnDate", loanDetails[5]); // Assuming returnDate is at index 5
            request.setAttribute("status", loanDetails[6]); // Assuming status is at index 6

            page = ConfigurationManager.getProperty("path.page.viewEditLoanDetails"); // Next page to view/edit loan details
        } catch (SQLException e) {
            // Handle exception, redirect to an error page, or display an error message
            e.printStackTrace();
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
