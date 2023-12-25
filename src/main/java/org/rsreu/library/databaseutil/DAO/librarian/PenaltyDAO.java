package org.rsreu.library.databaseutil.DAO.librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import org.rsreu.library.databaseutil.entity.Penalty;
import org.rsreu.library.resource.DatabaseManager;
public class PenaltyDAO {
    private final Connection connection;

    public PenaltyDAO(Connection connection) {
        this.connection = connection;
    }
    /**
     * Inserts a penalty entry into the database.
     *
     * @param penalty The Penalty object to be inserted
     * @return True if the insertion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean insertPenalty(Penalty penalty) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_penalty"));

        statement.setLong(1, penalty.getReaderId());
        statement.setLong(2, penalty.getValidity());
        statement.setString(3, penalty.getReason());
        statement.setDate(4, penalty.getPenaltyDate());
        statement.setDate(5, penalty.getExpirationDate());
        statement.setLong(6, penalty.getLibrarianId());

        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }
    /**
     * Updates an existing penalty entry in the database.
     *
     * @param penalty The Penalty object containing updated information
     * @return True if the update is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean updatePenalty(Penalty penalty) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_penalty"));

        statement.setLong(1, penalty.getValidity());
        statement.setString(2, penalty.getReason());
        statement.setDate(3, penalty.getPenaltyDate());
        statement.setDate(4, penalty.getExpirationDate());
        statement.setLong(5, penalty.getLibrarianId());
        statement.setLong(6, penalty.getPenaltyId());
        statement.setLong(7, penalty.getReaderId());

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
    /**
     * Retrieves a penalty by its ID.
     *
     * @param penaltyId The ID of the penalty to be retrieved
     * @return The Penalty object matching the specified ID, or null if not found
     * @throws SQLException If an SQL exception occurs
     */
    public Penalty getPenaltyById(Long penaltyId) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Penalty penalty = null;

        try {
            statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_penalty_by_id"));
            statement.setLong(1, penaltyId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                penalty = new Penalty();
                penalty.setPenaltyId(resultSet.getLong("PENALTY_ID"));
                penalty.setReaderId(resultSet.getLong("READER_ID"));
                penalty.setValidity(resultSet.getInt("VALIDITY"));
                penalty.setReason(resultSet.getString("REASON"));
                penalty.setPenaltyDate(resultSet.getDate("PENALTY_DATE"));
                penalty.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
                penalty.setLibrarianId(resultSet.getLong("LIBRARIAN_ID"));
            }
        } finally {
            // Close resources in reverse order of creation to avoid potential leaks
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

        return penalty;
    }

    /**
     * Retrieves penalties by reader ID.
     *
     * @param readerId The ID of the reader
     * @return A list of Penalty objects associated with the specified reader ID
     * @throws SQLException If an SQL exception occurs
     */
    public List<Penalty> getPenaltiesByReaderId(Long readerId) throws SQLException {
        List<Penalty> penaltyList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_penalties_by_reader"));
        statement.setLong(1, readerId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Penalty penalty = new Penalty();
            penalty.setPenaltyId(resultSet.getLong("PENALTY_ID"));
            penalty.setReaderId(resultSet.getLong("READER_ID"));
            penalty.setValidity(resultSet.getInt("VALIDITY"));
            penalty.setReason(resultSet.getString("REASON"));
            penalty.setPenaltyDate(resultSet.getDate("PENALTY_DATE"));
            penalty.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
            penalty.setLibrarianId(resultSet.getLong("LIBRARIAN_ID"));

            penaltyList.add(penalty);
        }

        return penaltyList;
    }
    /**
     * Retrieves penalties expiring by a given date.
     *
     * @param currentDate The date used to determine expiring penalties
     * @return A list of Penalty objects that are expiring based on the specified date
     * @throws SQLException If an SQL exception occurs
     */
    public List<Penalty> getPenaltiesExpiringByDate(Date currentDate) throws SQLException {
        List<Penalty> penaltyList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_penalties_expiring_by_date"));
        statement.setDate(1, currentDate);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Penalty penalty = new Penalty();
            penalty.setPenaltyId(resultSet.getLong("PENALTY_ID"));
            penalty.setReaderId(resultSet.getLong("READER_ID"));
            penalty.setValidity(resultSet.getInt("VALIDITY"));
            penalty.setReason(resultSet.getString("REASON"));
            penalty.setPenaltyDate(resultSet.getDate("PENALTY_DATE"));
            penalty.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
            penalty.setLibrarianId(resultSet.getLong("LIBRARIAN_ID"));

            penaltyList.add(penalty);
        }

        return penaltyList;
    }
    /**
     * Retrieves penalties by librarian ID.
     *
     * @param librarianId The ID of the librarian
     * @return A list of Penalty objects associated with the specified librarian ID
     * @throws SQLException If an SQL exception occurs
     */
    public List<Penalty> getPenaltiesByLibrarianId(Long librarianId) throws SQLException {
            List<Penalty> penaltyList = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_penalties_by_librarian"));
            statement.setLong(1, librarianId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Penalty penalty = new Penalty();
                penalty.setPenaltyId(resultSet.getLong("PENALTY_ID"));
                penalty.setReaderId(resultSet.getLong("READER_ID"));
                penalty.setValidity(resultSet.getInt("VALIDITY"));
                penalty.setReason(resultSet.getString("REASON"));
                penalty.setPenaltyDate(resultSet.getDate("PENALTY_DATE"));
                penalty.setExpirationDate(resultSet.getDate("EXPIRATION_DATE"));
                penalty.setLibrarianId(resultSet.getLong("LIBRARIAN_ID"));

                penaltyList.add(penalty);
            }

            return penaltyList;
        }
    /**
     * Updates penalty validity and expiration date.
     *
     * @param validity       The new validity status of the penalty
     * @param expirationDate The new expiration date of the penalty
     * @param penaltyId      The ID of the penalty to be updated
     * @return True if the update is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean updatePenaltyValidityExpiration(String validity, Date expirationDate, Long penaltyId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_penalty_validity_expiration"));

        statement.setString(1, validity);
        statement.setDate(2, expirationDate);
        statement.setLong(3, penaltyId);

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
}