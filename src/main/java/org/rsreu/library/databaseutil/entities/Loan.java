package org.rsreu.library.databaseutil.entities;

import java.util.Date;
public class Loan {

	private Long loanId;
	private Long inventoryId;
	private Long readerId;
	private Date loanDate;
	private Date dueDate;
	private Date returnDate;
	private String status;

	// Getters and Setters for LOAN_ID
	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	// Getters and Setters for INVENTORY_ID
	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	// Getters and Setters for READER_ID
	public Long getReaderId() {
		return readerId;
	}

	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}

	// Getters and Setters for LOAN_DATE
	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	// Getters and Setters for DUE_DATE
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	// Getters and Setters for RETURN_DATE
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	// Getters and Setters for STATUS
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

