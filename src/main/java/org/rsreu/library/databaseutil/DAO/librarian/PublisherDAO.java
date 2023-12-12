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

    public PublisherDAO(Connection connection) {
        this.connection = connection;
    }

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

    public boolean deletePublisherByName(String publisherName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.delete_publisher_by_name"));
        statement.setString(1, publisherName);
        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }

    public boolean insertPublisher(String publisherName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_publisher"));
        statement.setString(1, publisherName);
        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }

    public boolean updatePublisherName(String newPublisherName, String oldPublisherName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_publisher_name"));
        statement.setString(1, newPublisherName);
        statement.setString(2, oldPublisherName);
        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
}
