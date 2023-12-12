package org.rsreu.library.databaseutil.DAO.reader;

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
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.create_loan"));

        statement.setLong(1, loan.getInventoryId());
        statement.setLong(2, loan.getReaderId());
        statement.setDate(3, loan.getLoanDate());
        statement.setDate(4, loan.getDueDate());
        statement.setString(5, loan.getStatus());

        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }

    public List<Loan> getLoansByReaderId(Long readerId) throws SQLException {
        List<Loan> loanList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.get_loans_by_reader"));
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

            loanList.add(loan);
        }

        return loanList;
    }

}
