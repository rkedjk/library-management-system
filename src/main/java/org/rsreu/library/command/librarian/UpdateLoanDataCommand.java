package org.rsreu.library.command.librarian;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.databaseutil.api.librarian.LoanAPI;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.Loan;
import java.sql.Date;
import java.sql.SQLException;
import org.rsreu.library.command.ActionCommand;
public class UpdateLoanDataCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve modified loan details from the request parameters
        Long loanId = Long.parseLong(request.getParameter("loanId"));
        Long inventoryId = Long.parseLong(request.getParameter("inventoryId"));
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        Date loanDate = Date.valueOf(request.getParameter("loanDate"));
        Date dueDate = Date.valueOf(request.getParameter("dueDate"));
        String status = request.getParameter("status");
        Date returnDate = Date.valueOf(request.getParameter("returnDate"));


        LoanAPI loanAPI = new LoanAPI(); // Replace with your API or service class

        try {
            loanAPI.updateLoan(loanId,inventoryId,readerId,loanDate,dueDate,status,returnDate); // Update loan data
            // Redirect to a success page
            page = ConfigurationManager.getProperty("path.page.success");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception and redirect to an error page
            page = ConfigurationManager.getProperty("path.page.error");
        }

        return page;
    }
}
