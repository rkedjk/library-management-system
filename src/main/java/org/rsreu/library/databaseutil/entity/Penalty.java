package org.rsreu.library.databaseutil.entity;

import java.sql.Date;

/**
 * The Penalty class represents information about a penalty incurred by a reader.
 */
public class Penalty {

    private Long penaltyId; // Identifier for the penalty
    private Long readerId; // Identifier for the reader associated with the penalty
    private Integer validity; // Validity period of the penalty
    private String reason; // Reason for the penalty
    private Date penaltyDate; // Date when the penalty was imposed
    private Date expirationDate; // Date when the penalty expires
    private Long librarianId; // Identifier for the librarian who issued the penalty

    /**
     * Retrieves the penalty's identifier.
     *
     * @return The penalty's ID
     */
    public Long getPenaltyId() {
        return penaltyId;
    }

    /**
     * Sets the penalty's identifier.
     *
     * @param penaltyId The penalty's ID to set
     */
    public void setPenaltyId(Long penaltyId) {
        this.penaltyId = penaltyId;
    }

    /**
     * Retrieves the reader's identifier associated with this penalty.
     *
     * @return The reader's ID
     */
    public Long getReaderId() {
        return readerId;
    }

    /**
     * Sets the reader's identifier associated with this penalty.
     *
     * @param readerId The reader's ID to set
     */
    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    /**
     * Retrieves the validity period of the penalty.
     *
     * @return The validity period
     */
    public Integer getValidity() {
        return validity;
    }

    /**
     * Sets the validity period of the penalty.
     *
     * @param validity The validity period to set
     */
    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    /**
     * Retrieves the reason for the penalty.
     *
     * @return The reason for the penalty
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the reason for the penalty.
     *
     * @param reason The reason for the penalty to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Retrieves the date when the penalty was imposed.
     *
     * @return The penalty date
     */
    public Date getPenaltyDate() {
        return penaltyDate;
    }

    /**
     * Sets the date when the penalty was imposed.
     *
     * @param penaltyDate The penalty date to set
     */
    public void setPenaltyDate(Date penaltyDate) {
        this.penaltyDate = penaltyDate;
    }

    /**
     * Retrieves the expiration date of the penalty.
     *
     * @return The expiration date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the expiration date of the penalty.
     *
     * @param expirationDate The expiration date to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Retrieves the identifier of the librarian who issued the penalty.
     *
     * @return The librarian's ID
     */
    public Long getLibrarianId() {
        return librarianId;
    }

    /**
     * Sets the identifier of the librarian who issued the penalty.
     *
     * @param librarianId The librarian's ID to set
     */
    public void setLibrarianId(Long librarianId) {
        this.librarianId = librarianId;
    }
}
