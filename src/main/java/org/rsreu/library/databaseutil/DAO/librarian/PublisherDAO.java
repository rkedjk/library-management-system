package org.rsreu.library.databaseutil.DAO.librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.rsreu.library.databaseutil.entity.Publisher;
import org.rsreu.library.resource.DatabaseManager;

public class PublisherDAO {

    private final Connection connection;

    /**
     * Constructs a PublisherDAO object with a specified database connection.
     *
     * @param connection The database connection to be used by the DAO
     */
    public PublisherDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Retrieves all publishers from the database.
     *
     * @return A list containing all publishers available in the database
     * @throws SQLException If an SQL exception occurs
     */
    public List<Publisher> getAllPublishers() throws SQLException {
        List<Publisher> publisherList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.select_all_publishers"));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Publisher publisher = new Publisher();
            publisher.setPublisherName(resultSet.getString("PUBLISHER_NAME"));
            publisherList.add(publisher);
        }

        return publisherList;
    }

    /**
     * Deletes a publisher from the database based on its name.
     *
     * @param publisherName The name of the publisher to be deleted
     * @return True if deletion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean deletePublisherByName(String publisherName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.delete_publisher_by_name"));
        statement.setString(1, publisherName);
        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }

    /**
     * Inserts a new publisher into the database.
     *
     * @param publisherName The name of the publisher to be inserted
     * @return True if insertion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean insertPublisher(String publisherName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_publisher"));
        statement.setString(1, publisherName);
        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }

    /**
     * Updates the name of a publisher in the database.
     *
     * @param newPublisherName The new name to update the publisher to
     * @param oldPublisherName The current name of the publisher to be updated
     * @return True if update is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean updatePublisherName(String newPublisherName, String oldPublisherName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_publisher_name"));
        statement.setString(1, newPublisherName);
        statement.setString(2, oldPublisherName);
        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
}
