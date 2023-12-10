package org.rsreu.library.databaseutil.businessentites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rsreu.library.databaseutil.resourcer.*;

import org.rsreu.library.databaseutil.entities.*;

public class UserQueriesDAO {

	private Connection connection;

	public UserQueriesDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Books> searchBooksByTitle(String title) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("First query");

		List<Books> books = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, "%" + title + "%");

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



	public List<Books> searchAvailableBooks() throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("Second query");

		List<Books> books = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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

	public List<Books> searchBooksByAuthorId(int authorId) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("Third query");

		List<Books> books = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, authorId);

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

	public List<Books> searchBooksByGenreId(int genreId) throws SQLException {
		final Resourcer RESOURCER = ProjectResourcer.getInstance();
		String query = RESOURCER.getString("Fourth query");

		List<Books> books = new ArrayList<>();

		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, genreId);

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
}
