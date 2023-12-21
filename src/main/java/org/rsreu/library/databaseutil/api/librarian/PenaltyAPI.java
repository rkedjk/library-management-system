package org.rsreu.library.databaseutil.api.librarian;

import org.rsreu.library.databaseutil.DAO.librarian.PenaltyDAO;
import org.rsreu.library.databaseutil.entity.Penalty;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import org.rsreu.library.databaseutil.OracleConnectionManager;
public class PenaltyAPI {
    private final PenaltyDAO penaltyDAO;

    public PenaltyAPI() {
        penaltyDAO = new PenaltyDAO(OracleConnectionManager.getConnection());
    }

    public void insertPenalty(Long readerId, String validity, String reason, Date penaltyDate, Date expirationDate, Long librarianId) throws SQLException {
        Penalty penalty = new Penalty();
        penalty.setReaderId(readerId);
        penalty.setValidity(Integer.valueOf(validity));
        penalty.setReason(reason);
        penalty.setPenaltyDate(penaltyDate);
        penalty.setExpirationDate(expirationDate);
        penalty.setLibrarianId(librarianId);
        penaltyDAO.insertPenalty(penalty);
    }

    public void updatePenalty(Long penaltyId, Long readerId, String validity, String reason, Date penaltyDate, Date expirationDate, Long librarianId) throws SQLException {
        Penalty penalty = new Penalty();
        penalty.setPenaltyId(penaltyId);
        penalty.setReaderId(readerId);
        penalty.setValidity(Integer.valueOf(validity));
        penalty.setReason(reason);
        penalty.setPenaltyDate(penaltyDate);
        penalty.setExpirationDate(expirationDate);
        penalty.setLibrarianId(librarianId);
        penaltyDAO.updatePenalty(penalty);
    }

    public Penalty getPenaltyById(Long penaltyId) throws SQLException {
        return penaltyDAO.getPenaltyById(penaltyId);
    }

    public List<Penalty> getPenaltiesByReaderID(Long readerId) throws SQLException {
        return penaltyDAO.getPenaltiesByReaderId(readerId);
    }

    public List<Penalty> getPenaltiesExpiringByDate(Date expirationDate) throws SQLException {
        return penaltyDAO.getPenaltiesExpiringByDate(expirationDate);
    }

    public List<Penalty> getPenaltiesByLibrarianId(Long librarianId) throws SQLException {
        return penaltyDAO.getPenaltiesByLibrarianId(librarianId);
    }

    public void updatePenaltyValidityExpiration(Long penaltyId, String validity, Date expirationDate) throws SQLException {
        penaltyDAO.updatePenaltyValidityExpiration(validity, expirationDate, penaltyId);
    }
}
