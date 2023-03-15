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
		 
		 String userEmail;
		 String password;
		 String answer;
		 
		Connection connection = null;
		System.out.println("Inserisci il tuo indirizzo email:");
		userEmail = scanner.nextLine();

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet leggiTab1;
			ResultSet leggiTab2;
			leggiTab1=statement.executeQuery("SELECT * FROM clienti  WHERE email =" + userEmail);
		//cambia questi leggitab con leggiTab.get...qualcosa...fai check...che non sono stringhe	
			if(leggiTab1.get != null) {
				System.out.println("Inserisci Password:");
				password= scanner.nextLine();
				leggiTab2=statement.executeQuery("SELECT paswrd FROM  clienti WHERE email = " + userEmail + ";");
				if(password.equals(leggiTab2)) {
					System.out.println("Il tuo indirizzo è corretto? si/no");
					answer= scanner.nextLine();
					//fai do while per controllo risposta e in caso immetti nuovo indirizzo con update modify...
				}
			}
			if(leggiTab1.getString("passwrd") ==null) {
				System.out.println("Utente non registrato, procedere alla registrazione.\n\nInserisci la tua email: ");
			//porsegui a fare la registrazione  con scanner.next e poi fai insert into clienti ed inserisci..	
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
