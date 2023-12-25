package org.rsreu.library.databaseutil.entity;

/**
 * The Author class represents information about an author.
 */
public class Author {

	private String authorName; // Name of the author

	/**
	 * Retrieves the name of the author.
	 *
	 * @return The author's name
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Sets the name of the author.
	 *
	 * @param authorName The author's name to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
