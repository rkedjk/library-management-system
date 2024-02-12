package org.rsreu.library.databaseutil.api.reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rsreu.library.databaseutil.OracleConnectionManager;
import org.rsreu.library.databaseutil.entity.BookCatalog;
public class BookService {
    private Connection connection;
    // Метод для добавления рейтинга к каждой книге в списке

        // Метод для добавления рейтинга к каждой книге в списке
        public List<Object> addRatingToBooks(List<Object> bookList) throws SQLException {
            List<Object> extendedBooks = new ArrayList<>();
            Connection connection = OracleConnectionManager.getConnection(); // Получаем соединение с базой данных

            // Подготовка SQL-запроса для получения рейтинга книги
            String sql = "SELECT RATING FROM BOOK_RATING WHERE BOOK_ID = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Проходимся по каждой книге и добавляем рейтинг
                for (Object book : bookList) {
                    // Предполагаем, что объект имеет метод getBookId() для получения идентификатора книги
                    Long bookId = (Long) book.getClass().getMethod("getBookId").invoke(book);
                    statement.setLong(1, bookId);
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            int rating = resultSet.getInt("RATING");
                            // Создаем новый объект с рейтингом и добавляем в список
                            ExtendedBook extendedBook = new ExtendedBook(book, rating);
                            extendedBooks.add(extendedBook);
                        } else {
                            // Если рейтинг не найден, добавляем книгу без рейтинга
                            extendedBooks.add(book);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.close(); // Закрываем соединение с базой данных
            }

            return extendedBooks;
        }

    // Вспомогательный класс для хранения информации о книге и ее рейтинге
    private class ExtendedBook {
        private BookCatalog bookCatalog;
        private int rating;

        public ExtendedBook(BookCatalog bookCatalog, int rating) {
            this.bookCatalog = bookCatalog;
            this.rating = rating;
        }

        public BookCatalog getBookCatalog() {
            return bookCatalog;
        }

        public void setBookCatalog(BookCatalog bookCatalog) {
            this.bookCatalog = bookCatalog;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }
}
