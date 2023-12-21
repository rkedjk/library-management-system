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
    public boolean insertBookInventory(BookInventory bookInventory) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.insert_book_inventory"));

        statement.setLong(1, bookInventory.getBookId());
        statement.setString(2, bookInventory.getLocation());
        statement.setString(3, bookInventory.getStatus());

        int rowsInserted = statement.executeUpdate();

        return rowsInserted > 0;
    }
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
    public boolean updateBookInventory(BookInventory bookInventory) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_book_inventory"));

        statement.setLong(1, bookInventory.getBookId());
        statement.setString(2, bookInventory.getLocation());
        statement.setString(3, bookInventory.getStatus());
        statement.setLong(4, bookInventory.getInventoryId());

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
    public boolean deleteBookInventoryById(Long inventoryId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.delete_book_inventory_by_id"));
        statement.setLong(1, inventoryId);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;
    }
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
    public List<BookInventory> getBooksOnRepair() throws SQLException {
        List<BookInventory> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_books_on_repair"));
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
    public List<BookInventory> getLostBooks() throws SQLException {
        List<BookInventory> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_lost_books"));
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
    public List<BookInventory> getReservedBooks() throws SQLException {
        List<BookInventory> bookList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.get_reserved_books"));
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
    public boolean updateBookStatus(Long inventoryId, String newStatus) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DatabaseManager.getProperty("query.librarian.update_book_status"));

        statement.setString(1, newStatus);
        statement.setLong(2, inventoryId);

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;
    }
}
