/**
 *
 */
package com.hungh2002.model.databaseConnectionTest;

// Create an entity to represent an object in the database
public class DatabaseTest {

	// Defines table columns (id, insertResult, updateResult) in the database
	private int id;
	private String insertResult;
	private String updateResult;

	// Empty constructor
	public DatabaseTest() {
	}

	// Getter and setter methods
	public int getId() {
		return id;
	}

	public String getInsertResult() {
		return insertResult;
	}

	public void setInsertResult(String insertResult) {
		this.insertResult = insertResult;
	}

	public String getUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(String updateResult) {
		this.updateResult = updateResult;
	}

}
