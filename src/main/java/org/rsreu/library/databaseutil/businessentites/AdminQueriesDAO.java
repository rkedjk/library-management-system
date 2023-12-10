package org.rsreu.library.databaseutil.businessentites;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.rsreu.library.databaseutil.resourcer.*;

import org.rsreu.library.databaseutil.entities.*;

public class AdminQueriesDAO {
	
	private Connection connection;
	
	public AdminQueriesDAO(Connection connection) {
		this.connection = connection;
	}
	
	 public void insertReader(Reader reader) throws SQLException {
	        final Resourcer RESOURCER = ProjectResourcer.getInstance();
	        String query = RESOURCER.getString("query.sixth");

	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, reader.getName());
	            preparedStatement.setString(2, reader.getContactInfo());
	            preparedStatement.setInt(3, reader.getReaderTicketNumber());

	            preparedStatement.executeUpdate();
	        }
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
	 
	 
	 public void deleteBookById(int bookId) throws SQLException {
			final Resourcer RESOURCER = ProjectResourcer.getInstance();
			String query = RESOURCER.getString("query.sixteenth");

			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setInt(1, bookId);
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
		
		  public void deleteReaderById(int readerId) throws SQLException {
		        final Resourcer RESOURCER = ProjectResourcer.getInstance();
		        String query = RESOURCER.getString("query.thirteenth");

		        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		            preparedStatement.setInt(1, readerId);
		            preparedStatement.executeUpdate();
		        }
		    }
	}


