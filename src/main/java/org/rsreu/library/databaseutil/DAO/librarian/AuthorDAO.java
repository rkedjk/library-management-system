package org.rsreu.library.databaseutil.DAO.librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.rsreu.library.databaseutil.entity.Author;
import org.rsreu.library.resource.DatabaseManager;

public class AuthorDAO {

    private final Connection connection;

    /**
     * Constructs an AuthorDAO object with a specified database connection.
     *
     * @param connection The database connection to be used by the DAO
     */
    public AuthorDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves all authors from the database.
     *
     * @return A list containing all authors available in the database
     * @throws SQLException If an SQL exception occurs
     */
    public List<Author> getAllAuthors() throws SQLException {
        List<Author> authorList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.select_all_authors"));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Author author = new Author();
            author.setAuthorName(resultSet.getString("AUTHOR_NAME"));
            authorList.add(author);
        }

        return authorList;
    }

    /**
     * Deletes an author from the database based on their name.
     *
     * @param authorName The name of the author to be deleted
     * @return True if deletion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean deleteAuthorByName(String authorName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.delete_author_by_name"));
        statement.setString(1, authorName);
        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }

    /**
     * Inserts a new author into the database.
     *
     * @param authorName The name of the author to be inserted
     * @return True if insertion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean insertAuthor(String authorName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_author"));
        statement.setString(1, authorName);
        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }

    /**
     * Updates the name of an author in the database.
     *
     * @param newAuthorName The new name to update the author to
     * @param oldAuthorName The current name of the author to be updated
     * @return True if update is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean updateAuthorName(String newAuthorName, String oldAuthorName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_author_name"));
        statement.setString(1, newAuthorName);
        statement.setString(2, oldAuthorName);
        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
}
