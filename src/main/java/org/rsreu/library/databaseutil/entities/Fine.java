package org.rsreu.library.databaseutil.entities;

import java.time.LocalDate;

public class Fine {
	private int fineId;
	private Integer readerId;
	private Integer validity;
	private String reason;
	private LocalDate fineDate;
	private LocalDate expirationDate;

	public Fine(int fineId, Integer readerId, Integer validity, String reason, LocalDate fineDate, LocalDate expirationDate) {
		this.fineId = fineId;
		this.readerId = readerId;
		this.validity = validity;
		this.reason = reason;
		this.fineDate = fineDate;
		this.expirationDate = expirationDate;
	}

	public int getFineId() {
		return fineId;
	}

	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	public Integer getReaderId() {
		return readerId;
	}

	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}

	public Integer getValidity() {
		return validity;
	}

	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public LocalDate getFineDate() {
		return fineDate;
	}

	public void setFineDate(LocalDate fineDate) {
		this.fineDate = fineDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
}
