package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.LoanAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.Loan;

import java.sql.SQLException;
import java.sql.Date; // Using java.sql.Date directly
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateLoanCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        Long inventoryId = Long.parseLong(request.getParameter("inventoryId"));
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        Date loanDate = null;
        Date dueDate = null;
        String status = request.getParameter("status");

        try {
            // Parsing loanDate and dueDate as java.sql.Date directly
            loanDate = Date.valueOf(request.getParameter("loanDate"));
            dueDate = Date.valueOf(request.getParameter("dueDate"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            // Handle date parsing error - redirect to an error page or display an error message
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
            return page;
        }

        LoanAPI loanAPI = new LoanAPI();
        try {
            loanAPI.createLoan(inventoryId, readerId, loanDate, dueDate, status);
            // Redirect to success page or display success message
            page = ConfigurationManager.getProperty("path.page.loanSuccess"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle loan creation error - redirect to an error page or display an error message
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
