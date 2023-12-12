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

    public GenreDAO(Connection connection) {
        this.connection = connection;
    }

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

    public boolean deleteGenreByName(String genreName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.delete_genre_by_name"));
        statement.setString(1, genreName);
        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }

    public boolean insertGenre(String genreName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_genre"));
        statement.setString(1, genreName);
        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }

    public boolean updateGenreName(String newGenreName, String oldGenreName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_genre_name"));
        statement.setString(1, newGenreName);
        statement.setString(2, oldGenreName);
        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
}
