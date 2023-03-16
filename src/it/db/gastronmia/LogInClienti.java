package it.db.gastronmia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import z_project_Gastronomia.Cliente;
import z_project_Gastronomia.Ordini;

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
		Ordini ordine = new Ordini();
		LogInClienti client = new LogInClienti();
		
		Connection connection = null;
		System.out.println("Inserisci il tuo indirizzo email:");
		userEmail = scanner.nextLine();

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet leggiTab1;
			ResultSet leggiTab2;
			leggiTab1 = statement.executeQuery("SELECT * FROM clienti  WHERE email =" + userEmail);

			// controllo se utente è registrato con quella email
			if (leggiTab1.getString("email") != null) {
				System.out.println("Inserisci Password:");
				password = scanner.nextLine();
				leggiTab2 = statement.executeQuery("SELECT passwrd FROM  clienti WHERE email = " + userEmail + ";");

				// se password corretta da il benvenuto
				if (password.equals(leggiTab2.getString("passwrd"))) {
					System.out.println("Benvenuto " + leggiTab1.getString("nome") + "\n");
					// ordine.faiOrdine(); lo faccio sul main.

	/*
 * // fai metodo per check indirizzo
					 * System.out.println("Il tuo indirizzo è corretto? si/no"); answer=
					 * scanner.nextLine(); //fai do while per controllo risposta e in caso immetti
					 * nuovo indirizzo con update modify...
					 */ 
					}
				
				// altrimenti fa inserire la password fino a che non è corretta
				else {
					do {
						System.out.println("Inserita una password scorretta: reinserisci la password: ");
						password = scanner.nextLine();
						if (!password.equals(leggiTab2.getString("passwrd"))) {
							System.out.println("Inserita una password scorretta: reinserisci la password o premi 0 per uscire: ");
							password = scanner.nextLine();
							if(password=="0") {
								System.out.println("Arrivederci!");
								break;
							}
						} else {
							System.out.println("Benvenuto " + leggiTab1.getString("nome") + "\n");
						}
					} while (!password.equals(leggiTab2.getString("passwrd")));

				}

			} else {
				if (leggiTab1.getString("email") == null) {
					System.out.println("Utente non registrato, procedere alla registrazione.\n");
					client.subscribe();
				//	\nInserisci la tua email: ");
					// prosegui a fare la registrazione con scanner.next e poi fai insert into
					// clienti ed inserisci..

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void subscribe() {
		System.out.println("Iscriviti!!!");
	}
}
