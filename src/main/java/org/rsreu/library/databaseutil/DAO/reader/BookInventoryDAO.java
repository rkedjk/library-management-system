package org.rsreu.library.databaseutil.DAO.reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.rsreu.library.databaseutil.entity.BookInventory;
import org.rsreu.library.resource.DatabaseManager;
public class BookInventoryDAO {

    private final Connection connection;

    public BookInventoryDAO(Connection connection) {
        this.connection = connection;
    }
    public boolean updateBookStatus(String status, Long inventoryId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.update_book_status"));

        statement.setString(1, status);
        statement.setLong(2, inventoryId);

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
    public List<BookInventory> getAvailableBooks() throws SQLException {
        List<BookInventory> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.get_available_books"));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            BookInventory bookInventory = new BookInventory();
            bookInventory.setInventoryId(resultSet.getLong("INVENTORY_ID"));
            bookInventory.setBookId(resultSet.getLong("BOOK_ID"));
            bookInventory.setLocation(resultSet.getString("LOCATION"));
            bookInventory.setStatus(resultSet.getString("STATUS"));

            bookList.add(bookInventory);
        }

        return bookList;
    }

    public boolean updateInventoryStatusToReserved(Long inventoryId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.reader.update_inventory_status_reserved"));
        statement.setLong(1, inventoryId);

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }

}
