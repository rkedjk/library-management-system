package org.rsreu.library.databaseutil.entity;

/**
 * The Publisher class represents information about a book publisher.
 */
public class Publisher {

	private String publisherName; // Name of the publisher

	/**
	 * Retrieves the name of the publisher.
	 *
	 * @return The publisher's name
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * Sets the name of the publisher.
	 *
	 * @param publisherName The publisher's name to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
}
