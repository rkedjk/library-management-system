package org.rsreu.library.databaseutil.entity;

import java.sql.Date;

/**
 * The Loan class represents information about a library loan.
 */
public class Loan {

	private Long loanId; // Identifier for the loan
	private Long inventoryId; // Identifier for the book inventory associated with the loan
	private Long readerId; // Identifier for the reader
	private Date loanDate; // Date when the book was loaned
	private Date dueDate; // Due date for returning the book
	private Date returnDate; // Date when the book was returned
	private String status; // Status of the loan

	/**
	 * Retrieves the loan's identifier.
	 *
	 * @return The loan's ID
	 */
	public Long getLoanId() {
		return loanId;
	}

	/**
	 * Sets the loan's identifier.
	 *
	 * @param loanId The loan's ID to set
	 */
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	/**
	 * Retrieves the book inventory's identifier associated with this loan.
	 *
	 * @return The book inventory's ID
	 */
	public Long getInventoryId() {
		return inventoryId;
	}

	/**
	 * Sets the book inventory's identifier associated with this loan.
	 *
	 * @param inventoryId The book inventory's ID to set
	 */
	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	/**
	 * Retrieves the reader's identifier associated with this loan.
	 *
	 * @return The reader's ID
	 */
	public Long getReaderId() {
		return readerId;
	}

	/**
	 * Sets the reader's identifier associated with this loan.
	 *
	 * @param readerId The reader's ID to set
	 */
	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}

	/**
	 * Retrieves the loan date.
	 *
	 * @return The loan date
	 */
	public Date getLoanDate() {
		return loanDate;
	}

	/**
	 * Sets the loan date.
	 *
	 * @param loanDate The loan date to set
	 */
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	/**
	 * Retrieves the due date for returning the book.
	 *
	 * @return The due date
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * Sets the due date for returning the book.
	 *
	 * @param dueDate The due date to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Retrieves the return date of the book.
	 *
	 * @return The return date
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * Sets the return date of the book.
	 *
	 * @param returnDate The return date to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * Retrieves the status of the loan.
	 *
	 * @return The loan status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the loan.
	 *
	 * @param status The loan status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
