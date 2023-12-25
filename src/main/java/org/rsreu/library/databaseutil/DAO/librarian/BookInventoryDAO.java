package org.rsreu.library.databaseutil.DAO.librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.rsreu.library.databaseutil.entity.BookInventory;
import org.rsreu.library.resource.DatabaseManager;

public class BookInventoryDAO {

    private final Connection connection;

    /**
     * Constructs a BookInventoryDAO object with a specified database connection.
     *
     * @param connection The database connection to be used by the DAO
     */
    public BookInventoryDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Inserts book inventory into the database.
     *
     * @param bookInventory The book inventory to be inserted
     * @return True if insertion is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean insertBookInventory(BookInventory bookInventory) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_book_inventory"));

        statement.setLong(1, bookInventory.getBookId());
        statement.setString(2, bookInventory.getLocation());
        statement.setString(3, bookInventory.getStatus());

        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }

    /**
     * Retrieves book inventory by inventory ID.
     *
     * @param inventoryId The inventory ID of the book
     * @return The book inventory corresponding to the inventory ID
     * @throws SQLException If an SQL exception occurs
     */
    public BookInventory getBookInventoryById(Long inventoryId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_book_inventory_by_id"));
        statement.setLong(1, inventoryId);
        ResultSet resultSet = statement.executeQuery();

        BookInventory bookInventory = new BookInventory();
        if (resultSet.next()) {
            bookInventory.setInventoryId(resultSet.getLong("INVENTORY_ID"));
            bookInventory.setBookId(resultSet.getLong("BOOK_ID"));
            bookInventory.setLocation(resultSet.getString("LOCATION"));
            bookInventory.setStatus(resultSet.getString("STATUS"));
        }

        return bookInventory;
    }

    /**
     * Retrieves books by their status.
     *
     * @param status The status of the books to be retrieved
     * @return A list of BookInventory objects matching the specified status
     * @throws SQLException If an SQL exception occurs
     */
    public List<BookInventory> getBooksByStatus(String status) throws SQLException {
        List<BookInventory> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_by_status"));
        statement.setString(1, status);
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

    /**
     * Retrieves books by their book ID.
     *
     * @param bookId The ID of the book to be retrieved
     * @return A list of BookInventory objects matching the specified book ID
     * @throws SQLException If an SQL exception occurs
     */
    public List<BookInventory> getBooksByBookId(Long bookId) throws SQLException {
        List<BookInventory> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_by_book_id"));
        statement.setLong(1, bookId);
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

    /**
     * Updates the status of a book.
     *
     * @param inventoryId The inventory ID of the book
     * @param newStatus   The new status to be set for the book
     * @return True if the update is successful, false otherwise
     * @throws SQLException If an SQL exception occurs
     */
    public boolean updateBookStatus(Long inventoryId, String newStatus) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_book_status"));

        statement.setString(1, newStatus);
        statement.setLong(2, inventoryId);

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }


}
