package org.rsreu.library.command.reader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.databaseutil.api.reader.ReaderAPI;
import org.rsreu.library.databaseutil.entity.Loan;
import org.rsreu.library.databaseutil.entity.User;
import org.rsreu.library.resource.ConfigurationManager;

import java.awt.print.Book;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import org.rsreu.library.databaseutil.DAO.reader.BookCatalogDAO;
import org.rsreu.library.databaseutil.DAO.reader.BookInventoryDAO;
public class ReservationCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String page = null;
        ReaderAPI readerAPI = new ReaderAPI();
        // Retrieve necessary loan details from the request parameters
        Long bookId = Long.parseLong(request.getParameter("bookId")); // Assuming inventoryId is sent as a parameter
        Long inventoryId = readerAPI.reserve(bookId);
        // Retrieve user object from the session
        User user = (User) request.getSession().getAttribute("user");
        Long readerId = user.getId(); // Assuming user ID is stored in 'id' attribute of the User object in the session

        // Set other loan details
        String status = "RESERVED"; // Setting status as RESERVED
        Date loanDate = Date.valueOf(LocalDate.now()); // Current system date without time
        int daysToAdd = 7; // Due date is 7 days from loan date
        Date dueDate = Date.valueOf(LocalDate.now().plusDays(daysToAdd)); // Calculate due date without time

        // Create a Loan object with the retrieved details
        Loan loan = new Loan();
        loan.setInventoryId(inventoryId);
        loan.setReaderId(readerId);
        loan.setLoanDate(loanDate);
        loan.setDueDate(dueDate);
        loan.setStatus(status);
        // Set other necessary loan details
        // Instantiate your ReaderAPI or service class
        try {
            boolean reservationSuccess = readerAPI.createReservation(loan);
            if (reservationSuccess) {
                // Reservation successful
                // You can redirect to a success page or set a success message attribute
                page = ConfigurationManager.getProperty("path.page.success");
            } else {
                // Reservation failed
                // You can redirect to an error page or set an error message attribute
                page = ConfigurationManager.getProperty("path.page.error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle SQL exception
            // Redirect to an error page or set an error message attribute
            page = ConfigurationManager.getProperty("path.page.error");
        }

        return page;
    }
}
