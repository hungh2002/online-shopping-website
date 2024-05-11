package com.hungh2002.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.hungh2002.config.DBConnection;
import com.hungh2002.model.databaseConnectionTest.DatabaseTestDAO;

// write tests for small pieces of code (unit test)
// --> "https://junit.org/junit5/docs/current/user-guide/"
public class DatabaseTest {

	@Test
	@BeforeAll
	public void DBConnectionTest() {
		DBConnection connection = new DBConnection();
		assertNotNull(connection);
	}

	@Test
	public void insertAndUpdateDataTest() {
		DatabaseTestDAO databaseTest = new DatabaseTestDAO();
		databaseTest.insertData();
		databaseTest.updateData();
	}

	@Test
	public void queryDataTest() {
		DatabaseTestDAO databaseTest = new DatabaseTestDAO();
		databaseTest.queryData();
		databaseTest.queryDataWithCondition();
	}

	@Test
	@AfterAll
	public void deleteDataTest() {
		DatabaseTestDAO databaseTest = new DatabaseTestDAO();
		databaseTest.deleteData();
		databaseTest.close();
	}
}