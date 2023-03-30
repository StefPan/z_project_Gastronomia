package db.gastronomia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import z_project_Gastronomia.Ordini;

public class GestioneClient {
	/*
	 * private static final String URL =
	 * "jdbc:mysql://localhost:3306/progettogastronomia"; private static final
	 * String USER = "root"; private static final String PASSWORD = "13febbraio";
	 */
	ConnectionDb gestioneDb = new ConnectionDb();
	private PojoClient data = new PojoClient();
	private String answer;
	Ordini ordine = new Ordini();

	Scanner scanner = new Scanner(System.in);

	public void logIn() throws SQLException {

		// Connection connection = null;
		System.out.println("Inserisci il tuo indirizzo email o premi 1 se vuoi registrarti:");
		answer = scanner.nextLine().trim();
		if (answer.equals("1")) {
			subscribe();
		} else {

			try {

				// Creo connesione Db
				Statement statement = gestioneDb.getConnection();
				ResultSet leggiTab1;
				leggiTab1 = statement.executeQuery("SELECT * FROM clienti WHERE email = \"" + answer + "\";");

				// controllo se utente è registrato con quella email
				if (leggiTab1.next()) {

					if (leggiTab1.getString("email").equalsIgnoreCase(answer)) {
						System.out.println("Inserisci Password:");
						answer = scanner.nextLine();

						// se password corretta da il benvenuto e procedo all'ordine
						if (answer.equals(leggiTab1.getString("passwrd"))) {
							System.out.println("Benvenuto " + leggiTab1.getString("nome"));
							ordine.faiOrdine();
						}

						// altrimenti fa inserire la password fino a che non è corretta o l'utente
						// decide di uscire
						else {

							boolean ciclo = true;
							do {
								System.out.println(
										"Inserita una password scorretta: reinserisci la password o premi invio per uscire: ");
								answer = scanner.nextLine();
								if (answer.equals("")) {
									System.out.println("Arrivederci!");
									ciclo = false;

								}
								if (answer.equals(leggiTab1.getString("passwrd"))) {
									System.out.println("Benvenuto " + leggiTab1.getString("nome") + "\n");
									ordine.faiOrdine();
								}

							} while (!answer.equals(leggiTab1.getString("passwrd")) && (ciclo == true));
						}
						
					}
				}
				//utente non registrato:
				else if (leggiTab1.getFetchSize() == 0) {

					System.out.println(
							"Nome utente errato o Utente non registrato, procedere alla registrazione.\nsi/no:");
					answer = scanner.nextLine();
					answer = ordine.checkInput(answer, "si", "no");
					if (answer.equalsIgnoreCase("si")) {
						subscribe();
					} else {
						System.out.print("Grazie per essere passato. A presto!");
						gestioneDb.closeConnection();
					}
				}

				gestioneDb.closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	public void subscribe() throws SQLException {

		do {
			List<Client> clien = new ArrayList<>();
			Client cliente = new Client();

			System.out.print(" Enter Name => ");
			String firstName = scanner.nextLine();
			cliente.setName(firstName);

			System.out.print(" Enter Surname => ");
			answer = scanner.nextLine();
			cliente.setSurname(answer);

			System.out.print(" Enter email => ");
			answer = scanner.nextLine();
			cliente.setUserName(answer);

			System.out.print(" Enter password => ");
			answer = scanner.nextLine();
			cliente.setPassword(answer);

			System.out.print(" Enter address => ");
			answer = scanner.nextLine();
			cliente.setAddress(answer);

			System.out.print(" Enter post code => ");
			int postCode = scanner.nextInt();
			scanner.nextLine();
			cliente.setCap(postCode);

			System.out.print(" Enter City => ");
			answer = scanner.nextLine();
			cliente.setCity(answer);

			System.out.println("I tuoi dati sono corretti?\n" + cliente.toString() + "\nsi/no");
			answer = scanner.nextLine();
			answer = ordine.checkInput(answer, "si", "no");
			if (answer.equalsIgnoreCase("si")) {

				cliente.populateClientBatch(cliente);
				break;
			}
			// se dati non corretti rifà l'iscrizione
			else {
				subscribe();
			}
		} while (!answer.equalsIgnoreCase("no"));
		welcomingNewClient();
	}

	
	public void welcomingNewClient() {

		System.out.println("Registrazione avvenuta correttamente.\n Vuoi procedere al Login? si/no");
		answer = scanner.nextLine();
		answer = ordine.checkInput(answer, "si", "no");
		if (answer.equalsIgnoreCase("si")) {
			ordine.faiOrdine();
		} else {
			System.out.println("Grazie per esserti registrato. A presto.");
		}
	}

	
	
	public void checkAddress() {
		/* TODO
		 * lo richiamo dentro al Fai ordine se il cliente vuole il delivery!
		 * 
		 * // fai metodo per check indirizzo
		 * System.out.println("Il tuo indirizzo è corretto? si/no"); answer=
		 * scanner.nextLine(); //fai do while per controllo risposta e in caso immetti
		 * nuovo indirizzo con update modify...
		 */
} 


}
