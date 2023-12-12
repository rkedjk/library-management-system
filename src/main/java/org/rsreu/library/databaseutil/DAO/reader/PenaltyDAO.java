package org.rsreu.library.databaseutil.DAO.reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.rsreu.library.databaseutil.entity.Penalty;
import org.rsreu.library.resource.DatabaseManager;
public class PenaltyDAO {
    private final Connection connection;

    public PenaltyDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Penalty> getPenaltiesByReaderId(Long readerId) throws SQLException {
        List<Penalty> penaltyList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.get_penalties_by_reader"));
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

}
