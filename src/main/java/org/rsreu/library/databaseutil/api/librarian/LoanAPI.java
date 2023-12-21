package org.rsreu.library.databaseutil.api.librarian;

import org.rsreu.library.databaseutil.DAO.librarian.LoanDAO;
import org.rsreu.library.databaseutil.entity.Loan;

import org.rsreu.library.databaseutil.OracleConnectionManager;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public class LoanAPI {
    private final LoanDAO loanDAO;

    public LoanAPI() {
        loanDAO = new LoanDAO(OracleConnectionManager.getConnection());
    }

    public void createLoan(Long inventoryId, Long readerId, Date loanDate, Date dueDate, String status) throws SQLException {
        Loan loan = new Loan();
        loan.setInventoryId(inventoryId);
        loan.setReaderId(readerId);
        loan.setLoanDate(loanDate);
        loan.setDueDate(dueDate);
        loan.setStatus(status);
        loanDAO.createLoan(loan);
    }

    public Object getLoanById(Long loanId) throws SQLException {
        return loanDAO.getLoanById(loanId);
    }

    public void updateLoan(Long loanId, Long inventoryId, Long readerId, Date loanDate, Date dueDate, String status, Date returnDate) throws SQLException {
        Loan loan = new Loan();
        loan.setLoanId(loanId);
        loan.setInventoryId(inventoryId);
        loan.setReaderId(readerId);
        loan.setLoanDate(loanDate);
        loan.setDueDate(dueDate);
        loan.setStatus(status);
        loan.setReturnDate(returnDate);
        loanDAO.updateLoan(loan);
    }

    public List<Object> getLoansByReader(Long readerId) throws SQLException {
        List<Loan> loans = loanDAO.getLoansByReaderId(readerId);
        return (List<Object>) (List<?>) loans;
    }

    public List<Object> getLoansByStatus(String status) throws SQLException {
        List<Loan> loans = loanDAO.getLoansByStatus(status);
        return (List<Object>) (List<?>) loans;
    }

    public List<Object> getOverdueLoansByDate(Date date) throws SQLException {
        List<Loan> loans = loanDAO.getOverdueLoansByDate(date);
        return (List<Object>) (List<?>) loans;
    }
}
