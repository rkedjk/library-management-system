package org.rsreu.library.databaseutil.api.reader;

import org.rsreu.library.databaseutil.DAO.BookValueDAO;
import org.rsreu.library.databaseutil.DAO.reader.LoanDAO;
import org.rsreu.library.databaseutil.DAO.reader.PenaltyDAO;
import org.rsreu.library.databaseutil.DAO.reader.BookInventoryDAO;
import org.rsreu.library.databaseutil.DAO.reader.BookCatalogDAO;
import org.rsreu.library.databaseutil.OracleConnectionManager;
import org.rsreu.library.databaseutil.entity.BookCatalog;
import org.rsreu.library.databaseutil.entity.BookInventory;
import org.rsreu.library.databaseutil.entity.Loan;
import org.rsreu.library.databaseutil.entity.Penalty;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReaderAPI {
    private final BookCatalogDAO bookCatalogDAO;
    private final BookInventoryDAO bookInventoryDAO;
    private final BookValueDAO bookValueDAO;
    private final LoanDAO loanDAO;
    private final PenaltyDAO penaltyDAO;

    public ReaderAPI() {
        this.bookCatalogDAO = new BookCatalogDAO(OracleConnectionManager.getConnection());
        this.bookInventoryDAO = new BookInventoryDAO(OracleConnectionManager.getConnection());
        this.bookValueDAO = new BookValueDAO(OracleConnectionManager.getConnection());
        this.loanDAO = new LoanDAO(OracleConnectionManager.getConnection());
        this.penaltyDAO = new PenaltyDAO(OracleConnectionManager.getConnection());
    }

    public List<Object> searchBookCatalog(String searchType, String searchValue) throws SQLException {
        List<BookCatalog> bookCatalogList = null;
        switch (searchType.toLowerCase()) {
            case "id":
                Long bookId = Long.parseLong(searchValue);
                BookCatalog bookById = bookCatalogDAO.getBookCatalogById(bookId);
                if (bookById != null) {
                    bookCatalogList = new ArrayList<>();
                    bookCatalogList.add(bookById);
                }
                break;
            case "publisher":
                bookCatalogList = bookCatalogDAO.getBooksByPublisher(searchValue);
                break;
            case "year_published":
                int yearPublished = Integer.parseInt(searchValue);
                bookCatalogList = bookCatalogDAO.getBooksByYearPublished(yearPublished);
                break;
            case "genre":
                bookCatalogList = bookCatalogDAO.getBooksByGenre(searchValue);
                break;
            case "author":
                bookCatalogList = bookCatalogDAO.getBooksByAuthor(searchValue);
                break;
            case "title":
                bookCatalogList = bookCatalogDAO.searchBooksByTitle(searchValue);
                break;
        }
        List<Object> convertedList = new ArrayList<>();
        if (bookCatalogList != null) {
            convertedList.addAll(bookCatalogList);
        }
        return convertedList;
    }

    public List<Object> searchBooks(String searchType, String searchValue) throws SQLException {
        switch (searchType.toLowerCase()) {
            case "inventory_id":
                Long inventoryId = Long.valueOf(searchValue);
                BookInventory inventoryById = bookInventoryDAO.getBookInventoryById(inventoryId);
                return Collections.singletonList(inventoryById);
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

    public boolean createReservation(Loan loan) throws SQLException {
        boolean loanCreated = loanDAO.createLoan(loan);

        BookInventory bookInventory = bookInventoryDAO.getBookInventoryById(loan.getInventoryId());

        // Update the fetched BookInventory object
        if (bookInventory != null) {
            bookInventoryDAO.updateBookInventory(bookInventory);
            return true; // Reservation successful
        }

        return false; // Reservation failed due to inventory not found or other reasons
    }

    public void insertBookInventory(String location, String status, Long bookId) throws SQLException {
        BookInventory bookInventory = new BookInventory();
        bookInventory.setBookId(bookId);
        bookInventory.setLocation(location);
        bookInventory.setStatus(status);
        bookInventoryDAO.insertBookInventory(bookInventory);
    }
    public long reserve(Long bookId) throws SQLException {
        // Получаем объект BookInventory по bookId
        BookInventory bookInventory = bookInventoryDAO.getBookByBookId(bookId);

        // Проверяем, был ли найден объект
        if (bookInventory != null) {
            // Вызываем метод updateInventoryStatusToReserved() с использованием inventoryId
            boolean updateSuccess = bookInventoryDAO.updateInventoryStatusToReserved(bookInventory.getInventoryId());

            // Проверяем успешность обновления и возвращаем bookId, если успешно, или -1 в противном случае
            if (updateSuccess) {
                return bookInventory.getInventoryId();
            } else {
                return -1;
            }
        } else {
            // Если объект не был найден, возвращаем -1
            return -1;
        }
    }

    public BookInventory getBookInventoryById(Long inventoryId) throws SQLException {
        return bookInventoryDAO.getBookInventoryById(inventoryId);
    }

    public void updateBookStatus(String status, Long inventoryId) throws SQLException {
        bookInventoryDAO.updateBookStatus(inventoryId, status);
    }

    public List<Object[]> getNumBooksById(Long bookId) throws SQLException {
        return bookValueDAO.getNumBooksById(bookId);
    }

    public List<Object[]> getAllNumBooks() throws SQLException {
        return bookValueDAO.getAllNumBooks();
    }

    public List<Object[]> getNumBooksByStatus(String status) throws SQLException {
        return bookValueDAO.getNumBooksByStatus(status);
    }

    public List<Object[]> getNumBooksByStatusAndId(String status, Long bookId) throws SQLException {
        return bookValueDAO.getNumBooksByStatusAndId(status, bookId);
    }

    public List<Object> getLoansByReaderId(Long readerId) throws SQLException {
        List<Object> loanList = new ArrayList<>();
        List<Loan> loans = loanDAO.getLoansByReaderId(readerId);

        // Converting Loan objects to Object type
        for (Loan loan : loans) {
            loanList.add(loan);
        }

        return loanList;
    }
    public List<Object> getPenaltiesByReaderId(Long readerId) throws SQLException {
        List<Object> penaltyList = new ArrayList<>();
        List<Penalty> penalties = penaltyDAO.getPenaltiesByReaderId(readerId);

        // Converting Penalty objects to Object type
        for (Penalty penalty : penalties) {
            penaltyList.add(penalty);
        }

        return penaltyList;
    }
}
