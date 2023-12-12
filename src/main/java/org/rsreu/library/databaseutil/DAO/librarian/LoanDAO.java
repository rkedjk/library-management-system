package org.rsreu.library.databaseutil.DAO.librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import org.rsreu.library.databaseutil.entity.Loan;
import org.rsreu.library.resource.DatabaseManager;
public class LoanDAO {

    private final Connection connection;

    public LoanDAO(Connection connection) {
        this.connection = connection;
    }
    public boolean createLoan(Loan loan) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.create_loan"));

        statement.setLong(1, loan.getInventoryId());
        statement.setLong(2, loan.getReaderId());
        statement.setDate(3, loan.getLoanDate());
        statement.setDate(4, loan.getDueDate());
        statement.setString(5, loan.getStatus());

        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }
    public boolean updateInventoryStatusToIssued(Long inventoryId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_inventory_status_issued"));
        statement.setLong(1, inventoryId);

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
    public Loan getLoanById(Long loanId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_loan_by_id"));
        statement.setLong(1, loanId);
        ResultSet resultSet = statement.executeQuery();

        Loan loan = new Loan();
        if (resultSet.next()) {
            loan.setLoanId(resultSet.getLong("LOAN_ID"));
            loan.setInventoryId(resultSet.getLong("INVENTORY_ID"));
            loan.setReaderId(resultSet.getLong("READER_ID"));
            loan.setLoanDate(resultSet.getDate("LOAN_DATE"));
            loan.setDueDate(resultSet.getDate("DUE_DATE"));
            loan.setStatus(resultSet.getString("STATUS"));
        }

        return loan;
    }
    public boolean updateLoan(Loan loan) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_loan"));

        statement.setLong(1, loan.getInventoryId());
        statement.setLong(2, loan.getReaderId());
        statement.setDate(3, loan.getLoanDate());
        statement.setDate(4, loan.getDueDate());
        statement.setString(5, loan.getStatus());
        statement.setDate(6, loan.getReturnDate());
        statement.setLong(7, loan.getLoanId());

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
    public List<Loan> getLoansByReaderId(Long readerId) throws SQLException {
        List<Loan> loanList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_loans_by_reader"));
        statement.setLong(1, readerId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Loan loan = new Loan();
            loan.setLoanId(resultSet.getLong("LOAN_ID"));
            loan.setInventoryId(resultSet.getLong("INVENTORY_ID"));
            loan.setReaderId(resultSet.getLong("READER_ID"));
            loan.setLoanDate(resultSet.getDate("LOAN_DATE"));
            loan.setDueDate(resultSet.getDate("DUE_DATE"));
            loan.setStatus(resultSet.getString("STATUS"));
            loan.setReturnDate(resultSet.getDate("RETURN_DATE"));

            loanList.add(loan);
        }

        return loanList;
    }
    public List<Loan> getLoansByStatus(String status) throws SQLException {
        List<Loan> loanList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_loans_by_status"));
        statement.setString(1, status);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Loan loan = new Loan();
            loan.setLoanId(resultSet.getLong("LOAN_ID"));
            loan.setInventoryId(resultSet.getLong("INVENTORY_ID"));
            loan.setReaderId(resultSet.getLong("READER_ID"));
            loan.setLoanDate(resultSet.getDate("LOAN_DATE"));
            loan.setDueDate(resultSet.getDate("DUE_DATE"));
            loan.setStatus(resultSet.getString("STATUS"));
            loan.setReturnDate(resultSet.getDate("RETURN_DATE"));

            loanList.add(loan);
        }

        return loanList;
    }
    public List<Loan> getOverdueLoansByDate(Date currentDate) throws SQLException {
        List<Loan> loanList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_overdue_loans_by_date"));
        statement.setDate(1, currentDate);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Loan loan = new Loan();
            loan.setLoanId(resultSet.getLong("LOAN_ID"));
            loan.setInventoryId(resultSet.getLong("INVENTORY_ID"));
            loan.setReaderId(resultSet.getLong("READER_ID"));
            loan.setLoanDate(resultSet.getDate("LOAN_DATE"));
            loan.setDueDate(resultSet.getDate("DUE_DATE"));
            loan.setStatus(resultSet.getString("STATUS"));
            loan.setReturnDate(resultSet.getDate("RETURN_DATE"));

            loanList.add(loan);
        }

        return loanList;
    }

}
