package db.gastronomia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDb {
	private static final String URL = "jdbc:mysql://localhost:3306/progettogastronomia";
	private static final String USER = "root";
	private static final String PASSWORD = "13febbraio";
	Connection connection;
	Statement statement;
	
	
	public Statement  getConnection() {
		
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			statement= connection.createStatement();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	
	
	public void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
