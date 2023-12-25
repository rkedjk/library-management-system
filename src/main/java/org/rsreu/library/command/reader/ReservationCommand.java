package org.rsreu.library.command.reader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.reader.ReaderAPI;
import org.rsreu.library.resource.ConfigurationManager;
import org.rsreu.library.databaseutil.entity.Loan;
import org.rsreu.library.databaseutil.entity.User;

import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ReservationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        // Retrieve necessary loan details from the request parameters
        Long inventoryId = Long.parseLong(request.getParameter("inventoryId")); // Assuming inventoryId is sent as a parameter

        // Retrieve user object from the session
        User user = (User) request.getSession().getAttribute("user");
        Long readerId = user.getId(); // Assuming user ID is stored in 'id' attribute of the User object in the session

        // Set other loan details
        String status = "RESERVED"; // Setting status as RESERVED
        Date loanDate = new Date(System.currentTimeMillis()); // Current system date/time
        int daysToAdd = 7; // Due date is 7 days from loan date
        Date dueDate = new Date(loanDate.getTime() + daysToAdd * 24 * 60 * 60 * 1000); // Calculate due date

        // Create a Loan object with the retrieved details
        Loan loan = new Loan();
        loan.setInventoryId(inventoryId);
        loan.setReaderId(readerId);
        loan.setLoanDate(loanDate);
        loan.setDueDate(dueDate);
        loan.setStatus(status);
        // Set other necessary loan details

        // Instantiate your ReaderAPI or service class
        ReaderAPI readerAPI = new ReaderAPI(); // Adjust with the appropriate API or service class name
        try {
            boolean reservationSuccess = readerAPI.createReservation(loan);
            if (reservationSuccess) {
                // Reservation successful
                // You can redirect to a success page or set a success message attribute
                page = "path.page.success";
            } else {
                // Reservation failed
                // You can redirect to an error page or set an error message attribute
                page = "path.page.error";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            // Redirect to an error page or set an error message attribute
            page = "path.page.error";
        }

        return page;
    }
}


