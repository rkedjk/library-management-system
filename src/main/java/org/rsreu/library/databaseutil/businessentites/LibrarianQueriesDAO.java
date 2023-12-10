package ru.rsreu.Voronin0806.BusinesEntities.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rsreu.library.databaseutil.resourcer.*;

import org.rsreu.library.databaseutil.entities.*;
public class LibrarianQueriesDAO {

	private Connection connection;

	public LibrarianQueriesDAO(Connection connection) {
		this.connection = connection;
	}

	public void insertBook(Books book) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("Fifth query");

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setInt(2, book.getYearPublished());
			preparedStatement.setInt(3, book.getAuthorId());
			preparedStatement.setInt(4, book.getGenreId());
			preparedStatement.setString(5, book.getAvailability());
			preparedStatement.setInt(6, book.getPublisherId());

			preparedStatement.executeUpdate();
		}
	}

	public void updateBookById(Books book) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("query.fourteenth");

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setInt(2, book.getYearPublished());
			preparedStatement.setInt(3, book.getAuthorId());
			preparedStatement.setInt(4, book.getGenreId());
			preparedStatement.setString(5, book.getAvailability());
			preparedStatement.setInt(6, book.getPublisherId());
			preparedStatement.setInt(7, book.getBookId());

			preparedStatement.executeUpdate();
		}
	}

	public List<Books> searchBooksByParameters(String title, int yearPublished, int authorId, int genreId,
											   String availability, int publisherId) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("query.twelfth");

		List<Books> books = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, "%" + title + "%");
			preparedStatement.setInt(2, yearPublished);
			preparedStatement.setInt(3, authorId);
			preparedStatement.setInt(4, genreId);
			preparedStatement.setString(5, availability);
			preparedStatement.setInt(6, publisherId);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Books book = new Books(resultSet.getInt(RESOURCER.getString("books.book_Id")),
							resultSet.getString(RESOURCER.getString("books.title")),
							resultSet.getInt(RESOURCER.getString("books.year_Published")),
							resultSet.getInt(RESOURCER.getString("books.author_Id")),
							resultSet.getInt(RESOURCER.getString("books.genre_Id")),
							resultSet.getString(RESOURCER.getString("books.availability")),
							resultSet.getInt(RESOURCER.getString("books.publisher_Id")));
					books.add(book);
				}
			}
		}

		return books;
	}

	public void insertLoan(int bookId, int readerId, int librarianId) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("query.seventh");

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, bookId);
			preparedStatement.setInt(2, readerId);
			preparedStatement.setDate(3, new Date(System.currentTimeMillis()));
			preparedStatement.setDate(4, new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000)); // текущая
			// дата + 14
			// дней
			preparedStatement.setString(5, "выдана");
			preparedStatement.setInt(6, librarianId);

			preparedStatement.executeUpdate();
		}
	}

	public void updateLoanReturn(int loanId) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("query.eighth");

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// Установить дату возврата
			preparedStatement.setDate(1, new java.sql.Date(System.currentTimeMillis()));

			// Установить статус возвращения
			preparedStatement.setString(2, "возвращена");

			// Установить идентификатор займа
			preparedStatement.setInt(3, loanId);

			// Выполнить SQL-запрос
			preparedStatement.executeUpdate();
		}
	}

	public void insertFine(Fine fine) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("query.ninth");

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// Установить идентификатор читателя
			preparedStatement.setInt(1, fine.getReaderId());

			// Установить сумму штрафа
			preparedStatement.setDouble(2, fine.getAmount());

			// Установить причину штрафа
			preparedStatement.setString(3, fine.getReason());

			// Выполнить SQL-запрос
			preparedStatement.executeUpdate();
		}
	}


}
