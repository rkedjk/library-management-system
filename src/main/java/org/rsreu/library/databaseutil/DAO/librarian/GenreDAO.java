package org.rsreu.library.databaseutil.DAO.librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.rsreu.library.databaseutil.entity.Genre;
import org.rsreu.library.resource.DatabaseManager;

public class GenreDAO {

    private final Connection connection;

    /**
     * Constructs a GenreDAO object with a specified database connection.
     *
     * @param connection The database connection to be used by the DAO
     */
    public GenreDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves all genres from the database.
     *
     * @return A list containing all genres available in the database
     * @throws SQLException If an SQL exception occurs
     */
    public List<Genre> getAllGenres() throws SQLException {
        List<Genre> genreList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.select_all_genres"));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Genre genre = new Genre();
            genre.setGenreName(resultSet.getString("GENRE_NAME"));
            genreList.add(genre);
        }

        return genreList;
    }

    /**
     * Deletes a genre from the database based on its name.
     *
     * @param genreName The name of the genre to be deleted
     * @return True if deletion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean deleteGenreByName(String genreName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.delete_genre_by_name"));
        statement.setString(1, genreName);
        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }

    /**
     * Inserts a new genre into the database.
     *
     * @param genreName The name of the genre to be inserted
     * @return True if insertion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean insertGenre(String genreName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_genre"));
        statement.setString(1, genreName);
        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }

    /**
     * Updates the name of a genre in the database.
     *
     * @param newGenreName The new name to update the genre to
     * @param oldGenreName The current name of the genre to be updated
     * @return True if update is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean updateGenreName(String newGenreName, String oldGenreName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_genre_name"));
        statement.setString(1, newGenreName);
        statement.setString(2, oldGenreName);
        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
}
