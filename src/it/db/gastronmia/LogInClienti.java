package it.db.gastronmia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LogInClienti {

	private static final String URL = "jdbc:mysql://localhost:3306/progettogastronomia";
	private static final String USER = "root";
	private static final String PASSWORD = "13febbraio";

	Scanner scanner = new Scanner(System.in);

	
	public void logIn() throws SQLException {

		 Integer idClient;
		 String name;
		 String surname;
		 String email;
		 String address;
		 Integer cap;
		 String city;
		Connection connection = null;
		String userEmail;
		System.out.println("Inserisci il tuo indirizzo email:");
		userEmail = scanner.nextLine();

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet leggiTab;
			leggiTab=statement.executeQuery("SELECT * FROM clienti  WHERE email =" + userEmail);
			
			if(leggiTab != null)
			if(leggiTab ==null) {
				System.out.println("Utente non registrato, procedere alla registrazione.\n\nInserisci la tua email: ");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
