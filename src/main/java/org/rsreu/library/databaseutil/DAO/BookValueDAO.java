package org.rsreu.library.databaseutil.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.rsreu.library.resource.DatabaseManager;

public class BookValueDAO {
    private final Connection connection;

    public BookValueDAO(Connection connection) {
        this.connection = connection;
    }
    public List<Object[]> getNumBooksById(Long bookId) throws SQLException {
        List<Object[]> resultList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.bookvalue.get_num_books_by_id"));
        statement.setLong(1, bookId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Object[] result = new Object[7]; // Change 7 to match the number of columns in the result set
            result[0] = resultSet.getLong("BOOK_ID");
            result[1] = resultSet.getString("TITLE");
            result[2] = resultSet.getInt("YEAR_PUBLISHED");
            result[3] = resultSet.getString("AUTHOR_NAME");
            result[4] = resultSet.getString("GENRE_NAME");
            result[5] = resultSet.getString("PUBLISHER_NAME");
            result[6] = resultSet.getInt("NUM_OF_BOOKS");

            resultList.add(result);
        }

        return resultList;
    }
    public List<Object[]> getAllNumBooks() throws SQLException {
        List<Object[]> resultList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.bookvalue.get_all_num_books"));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Object[] result = new Object[7]; // Change 7 to match the number of columns in the result set
            result[0] = resultSet.getLong("BOOK_ID");
            result[1] = resultSet.getString("TITLE");
            result[2] = resultSet.getInt("YEAR_PUBLISHED");
            result[3] = resultSet.getString("AUTHOR_NAME");
            result[4] = resultSet.getString("GENRE_NAME");
            result[5] = resultSet.getString("PUBLISHER_NAME");
            result[6] = resultSet.getInt("NUM_OF_BOOKS");

            resultList.add(result);
        }

        return resultList;
    }
    public List<Object[]> getNumBooksByStatus(String status) throws SQLException {
        List<Object[]> resultList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.bookvalue.get_num_books_by_status"));
        statement.setString(1, status);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Object[] result = new Object[7]; // Change 7 to match the number of columns in the result set
            result[0] = resultSet.getLong("BOOK_ID");
            result[1] = resultSet.getString("TITLE");
            result[2] = resultSet.getInt("YEAR_PUBLISHED");
            result[3] = resultSet.getString("AUTHOR_NAME");
            result[4] = resultSet.getString("GENRE_NAME");
            result[5] = resultSet.getString("PUBLISHER_NAME");
            result[6] = resultSet.getInt("NUM_OF_BOOKS");

            resultList.add(result);
        }

        return resultList;
    }
    public List<Object[]> getNumBooksByStatusAndId(String status, Long bookId) throws SQLException {
        List<Object[]> resultList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.bookvalue.get_num_books_by_status_and_id"));
        statement.setString(1, status);
        statement.setLong(2, bookId);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Object[] result = new Object[7]; // Change 7 to match the number of columns in the result set
            result[0] = resultSet.getLong("BOOK_ID");
            result[1] = resultSet.getString("TITLE");
            result[2] = resultSet.getInt("YEAR_PUBLISHED");
            result[3] = resultSet.getString("AUTHOR_NAME");
            result[4] = resultSet.getString("GENRE_NAME");
            result[5] = resultSet.getString("PUBLISHER_NAME");
            result[6] = resultSet.getInt("NUM_OF_BOOKS");

            resultList.add(result);
        }

        return resultList;
    }

}
