package org.rsreu.library.databaseutil.api.librarian;

import org.rsreu.library.databaseutil.DAO.librarian.BookInventoryDAO;
import org.rsreu.library.databaseutil.entity.BookInventory;
import org.rsreu.library.databaseutil.OracleConnectionManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class BookInventoryAPI {
    private final BookInventoryDAO bookInventoryDAO;

    public BookInventoryAPI() {
        this.bookInventoryDAO = new BookInventoryDAO(OracleConnectionManager.getConnection());
    }

    public List<Object> searchBooks(String searchType, String searchValue) throws SQLException {
        switch (searchType.toLowerCase()) {
            case "inventory_id":
                Long inventoryId = Long.valueOf(searchValue);
                BookInventory inventoryById = bookInventoryDAO.getBookInventoryById(inventoryId);
                return Collections.singletonList((Object) inventoryById);
            case "status":
                switch (searchValue.toUpperCase()) {
                    case "AVAILABLE":
                    case "ON_REPAIR":
                    case "LOST":
                    case "RESERVED":
                        return new ArrayList<>(bookInventoryDAO.getBooksByStatus(searchValue.toUpperCase()));
                    default:
                        throw new IllegalArgumentException("Invalid status provided");
                }
            case "book_id":
                Long bookId = Long.valueOf(searchValue);
                return new ArrayList<>(bookInventoryDAO.getBooksByBookId(bookId));
            default:
                throw new IllegalArgumentException("Invalid search type provided");
        }
    }

    public void insertBookInventory(String location, String status, Long bookId) throws SQLException {
        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId(bookId);
        bookInventory.setLocation(location);
        bookInventory.setStatus(status);
        bookInventoryDAO.insertBookInventory(bookInventory);
    }

    public BookInventory getBookInventoryById(Long inventoryId) throws SQLException {
        return bookInventoryDAO.getBookInventoryById(inventoryId);
    }

    public void updateBookStatus(String status, Long inventoryId) throws SQLException {
        bookInventoryDAO.updateBookStatus(inventoryId,status);
    }

}