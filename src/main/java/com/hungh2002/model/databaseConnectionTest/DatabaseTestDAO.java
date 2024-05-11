package com.hungh2002.model.databaseConnectionTest;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hungh2002.config.DBConnection;

// DAO = Data Access Object
// --> "https://stackoverflow.com/questions/19154202/what-is-data-access-object-dao-in-java"

// To connect to the database, you must extend the DBConnection class
public class DatabaseTestDAO extends DBConnection {

	// After manipulating the database, you must close the connection to avoid
	// running in the background, causing computer failure.
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// Print error if there is a problem
			e.printStackTrace();
		}
	}

	// Insert, select, update, detele table data in the database using SQL statement
	// -> "https://www.w3schools.com/sql/default.asp"

	public void insertData() {

		// SQL statements
		String sqlInsertString = "INSERT INTO database_test (insertResult, updateResult) VALUES (?, ?)";

		// execute sql statement
		try (PreparedStatement insert = connection.prepareStatement(sqlInsertString)) {

			// Replace the first question mark with text
			insert.setString(1, "insert ok");

			// Replace the second question mark with text
			insert.setString(2, "x");

			// execute the SQL statement
			insert.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Database test sql insert statement: " + e);
		}
	}

	public void queryData() {

		// SQL statements
		String sqlQueryString = "SELECT * FROM database_test";

		// execute the SQL statement
		try (PreparedStatement query = connection.prepareStatement(sqlQueryString)) {
			query.executeQuery();

		} catch (SQLException e) {
			System.out.println("Database test sql select statement: " + e);
		}
	}

	public void queryDataWithCondition() {

		// SQL statements
		String sqlQueryString = "SELECT * FROM database_test WHERE insertResult = ?";

		// execute the SQL statement
		try (PreparedStatement query = connection.prepareStatement(sqlQueryString)) {

			// Replace the question mark with text
			query.setString(1, "insert ok");
			query.executeQuery();

		} catch (SQLException e) {
			System.out.println("Database test sql select statement: " + e);
		}
	}

	public void updateData() {

		// SQL statements
		String sqlIupdateString = "UPDATE database_test SET updateResult = ? WHERE insertResult = ?";

		// execute the SQL statement
		try (PreparedStatement update = connection.prepareStatement(sqlIupdateString)) {

			// Replace the first question mark with text
			update.setString(1, "update ok");

			// Replace the second question mark with text
			update.setString(2, "insert ok");
			update.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Database test sql update statement: " + e);
		}
	}

	public void deleteData() {

		// SQL statements
		String sqlDeleteString = "DELETE FROM  database_test WHERE insertResult = ?";

		// execute the SQL statement
		try (PreparedStatement update = connection.prepareStatement(sqlDeleteString)) {

			// Replace the first question mark with text
			update.setString(1, "insert ok");
			update.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Database test sql delete statement: " + e);
		}

	}
}