package org.rsreu.library.databaseutil.entities;

import java.util.Date;

public class Penalty {

    private Long penaltyId;
    private Long readerId;
    private Integer validity;
    private String reason;
    private Date penaltyDate;
    private Date expirationDate;
    private Long librarianId;

    // Getters and Setters for PENALTY_ID
    public Long getPenaltyId() {
        return penaltyId;
    }

    public void setPenaltyId(Long penaltyId) {
        this.penaltyId = penaltyId;
    }

    // Getters and Setters for READER_ID
    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    // Getters and Setters for VALIDITY
    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    // Getters and Setters for REASON
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    // Getters and Setters for PENALTY_DATE
    public Date getPenaltyDate() {
        return penaltyDate;
    }

    public void setPenaltyDate(Date penaltyDate) {
        this.penaltyDate = penaltyDate;
    }

    // Getters and Setters for EXPIRATION_DATE
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Getters and Setters for LIBRARIAN_ID
    public Long getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(Long librarianId) {
        this.librarianId = librarianId;
    }
}
