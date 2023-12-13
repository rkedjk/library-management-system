package org.rsreu.library.databaseutil.api.reader;


import org.rsreu.library.databaseutil.DAO.reader.BookCatalogDAO;
import org.rsreu.library.databaseutil.OracleConnectionManager;
import org.rsreu.library.databaseutil.entity.Author;
import org.rsreu.library.databaseutil.entity.BookCatalog;
import org.rsreu.library.databaseutil.entity.Genre;
import org.rsreu.library.databaseutil.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCatalogAPI {
    private final BookCatalogDAO bookCatalogDAO;

    public BookCatalogAPI() {
        // Initialize BookCatalogDAO - You'll need to manage the connection creation here
        this.bookCatalogDAO = new BookCatalogDAO(OracleConnectionManager.getConnection());
        ;
    }

    public List<Object> searchBookCatalog(String searchType, String searchValue) throws SQLException {
        List<BookCatalog> bookCatalogList = null;
        switch (searchType.toLowerCase()) {
            case "id":
                Long bookId = Long.parseLong(searchValue);
                BookCatalog bookById = bookCatalogDAO.getBookCatalogById(bookId);
                if (bookById != null) {
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
        List<Object> convertedList = new ArrayList<>(bookCatalogList);
        return convertedList;
    }


}
