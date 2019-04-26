package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	// Private Constructor to enforce usage of factory method
	private ConnectionFactory() {}
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(System.getenv("JDBC_URL"), 
											   System.getenv("JDBC_USERNAME"), 
											   System.getenv("JDBC_PASSWORD"));
		} catch (SQLException e) {
			System.err.println("Error Code: " + e.getErrorCode());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Message: " + e.getMessage());
			throw new RuntimeException("Could not get database connection");
		} catch (ClassNotFoundException e) {
			System.err.println("Could not locate JDBC Driver");
			throw new RuntimeException("Could not locate JDBC driver");
		}
	}
}
