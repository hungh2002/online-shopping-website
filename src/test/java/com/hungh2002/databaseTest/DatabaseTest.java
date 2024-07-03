package com.hungh2002.databaseTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.hungh2002.config.DBConnection;
import com.hungh2002.model.databaseConnectionTest.DatabaseTestDAO;

// write tests for small pieces of code (unit test)
// --> "https://junit.org/junit5/docs/current/user-guide/"
public class DatabaseTest {

	@BeforeAll
	static void DBConnectionTest() {
		DBConnection connection = new DBConnection();
		assertNotNull(connection);
		connection.close();
	}

	@Test
	public void insertAndUpdateDataTest() {
		DatabaseTestDAO databaseTest = new DatabaseTestDAO();
		databaseTest.insertData();
		databaseTest.updateData();
		databaseTest.close();
	}

	@Test
	public void queryDataTest() {
		DatabaseTestDAO databaseTest = new DatabaseTestDAO();
		databaseTest.queryData();
		databaseTest.queryDataWithCondition();
		databaseTest.close();
	}

	@AfterAll
	static void deleteDataTest() {
		DatabaseTestDAO databaseTest = new DatabaseTestDAO();
		databaseTest.deleteData();
		databaseTest.close();
	}
}
