package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.librarian.LoanAPI;
import org.rsreu.library.databaseutil.entity.Loan;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.Date;
import java.sql.SQLException;

public class CreateLoanCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve parameters from the request
        Long inventoryId = Long.parseLong(request.getParameter("inventoryId"));
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        Date loanDate = Date.valueOf(request.getParameter("loanDate"));
        Date dueDate = Date.valueOf(request.getParameter("dueDate"));
        String status = request.getParameter("status");

        // Instantiate the LibraryManagementAPI (or service class)
        LoanAPI libraryManagementAPI = new LoanAPI(); // Replace with your API or service class

        try {
            libraryManagementAPI.createLoan(inventoryId, readerId, loanDate, dueDate, status);
            // Loan created successfully
            page = ConfigurationManager.getProperty("path.page.success"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
