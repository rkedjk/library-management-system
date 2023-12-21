package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.LoanAPI;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.resource.ConfigurationManager;

import java.sql.SQLException;
import java.sql.Date; // Using java.sql.Date directly
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateLoanDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        Long loanId = Long.parseLong(request.getParameter("loanId"));
        Long inventoryId = Long.parseLong(request.getParameter("inventoryId"));
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        Date loanDate = null;
        Date dueDate = null;
        Date returnDate = null;
        String status = request.getParameter("status");

        try {
            // Parsing loanDate, dueDate, and returnDate as java.sql.Date directly
            loanDate = Date.valueOf(request.getParameter("loanDate"));
            dueDate = Date.valueOf(request.getParameter("dueDate"));
            returnDate = Date.valueOf(request.getParameter("returnDate"));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            // Handle date parsing error - redirect to an error page or display an error message
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
            return page;
        }

        LoanAPI loanAPI = new LoanAPI();
        try {
            loanAPI.updateLoan(loanId, inventoryId, readerId, loanDate, dueDate, status, returnDate);
            // Redirect to success page or display success message
            page = ConfigurationManager.getProperty("path.page.loanUpdateSuccess"); // Redirect to success page
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle loan update error - redirect to an error page or display an error message
            page = ConfigurationManager.getProperty("path.page.error"); // Redirect to error page
        }

        return page;
    }
}
