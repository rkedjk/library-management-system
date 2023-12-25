package org.rsreu.library.databaseutil.entity;

/**
 * The Genre class represents information about a book genre.
 */
public class Genre {

	private String genreName; // Name of the genre

	/**
	 * Retrieves the name of the genre.
	 *
	 * @return The genre's name
	 */
	public String getGenreName() {
		return genreName;
	}

	/**
	 * Sets the name of the genre.
	 *
	 * @param genreName The genre's name to set
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
