package DbGastronomia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import z_project_Gastronomia.Ordini;

public class GestioneCliente {
	private static final String URL = "jdbc:mysql://localhost:3306/progettogastronomia";
	private static final String USER = "root";
	private static final String PASSWORD = "13febbraio";

	private Integer idClient;
	private String name;
	private String surname;
	private String address;
	private String email;
	private String password;
	private Integer cap;
	private String city;

	private String answer;
	Ordini ordine = new Ordini();

	Scanner scanner = new Scanner(System.in);

	public void logIn() throws SQLException {

		// Connection connection = null;
		System.out.println("Inserisci il tuo indirizzo email o premi 1 se vuoi registrarti:");
		email = scanner.nextLine().trim();
		if (email.equals("1")) {
			subscribe();
		} else {

			try {
				Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet leggiTab1;
				leggiTab1 = statement.executeQuery("SELECT * FROM clienti WHERE email = \"" + email + "\";");

				// controllo se utente è registrato con quella email
				
				//lunghezza del resultset
	/*			if (leggiTab1.getFetchSize() == 0) {
					do {
					System.out.println("Nome utente errato o Utente non registrato, procedere alla registrazione.\nsi/no:");
					answer = scanner.nextLine();
					}while((leggiTab1.getFetchSize() == 0) || answer.equals("1"));
				}*/
				if (leggiTab1.next()) {
					
					if (leggiTab1.getString("email").equalsIgnoreCase(email)) {
						System.out.println("Inserisci Password:");
						password = scanner.nextLine();

						// se password corretta da il benvenuto
						if (password.equals(leggiTab1.getString("passwrd"))) {
							System.out.println("Benvenuto " + leggiTab1.getString("nome"));// +leggiTab1.getString("nome")
																							// +
																							// "\n");
							ordine.faiOrdine();
						}

						// altrimenti fa inserire la password fino a che non è corretta
						else {
							boolean ciclo = true;
							do {
								System.out.println(
										"Inserita una password scorretta: reinserisci la password premi invio per uscire: ");
								password = scanner.nextLine();
								if (password.equals("")) {
									System.out.println("Arrivederci!");
									ciclo = false;
									// break;
								}
								if (!password.equals(leggiTab1.getString("passwrd"))) {
									System.out.println(
											"Inserita una password scorretta: reinserisci la password o premi invio per uscire: ");
									password = scanner.nextLine();
								}

								else {
									System.out.println("Benvenuto " + leggiTab1.getString("nome") + "\n");
									ordine.faiOrdine();
								}
							} while (!password.equals(leggiTab1.getString("passwrd")) && (ciclo == true));

						}

					}
				} 
				
					
				
				else if (leggiTab1.getFetchSize() == 0) {

					System.out.println("Nome utente errato o Utente non registrato, procedere alla registrazione.\nsi/no:");
					answer = scanner.nextLine();
					answer = ordine.checkInput(answer, "si", "no");
					if (answer.equalsIgnoreCase("si")) {
						subscribe();
					} else {
						System.out.print("Grazie per essere passato. A presto!");
					}

				} 

				connection.close();
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
			surname = scanner.nextLine();
			cliente.setSurname(surname);

			System.out.print(" Enter email => ");
			email = scanner.nextLine();
			cliente.setUserName(email);

			System.out.print(" Enter password => ");
			password = scanner.nextLine();
			cliente.setPassword(password);

			System.out.print(" Enter address => ");
			String address = scanner.nextLine();
			cliente.setAddress(address);

			System.out.print(" Enter post code => ");
			cap = scanner.nextInt();
			scanner.nextLine();
			cliente.setCap(cap);

			System.out.print(" Enter City => ");
			city = scanner.nextLine();
			cliente.setCity(city);

			System.out.println("I tuoi dati sono corretti?\n" + cliente.toString() + "\nsi/no");
			answer = scanner.nextLine();
			answer = ordine.checkInput(answer, "si", "no");
			if (answer.equalsIgnoreCase("si")) {

				cliente.populateClientBatch(cliente);
				break;
				// logIn();
			}
			// se dati non corretti rifà l'iscrizione
			else {
				subscribe();
			}
		} while (!answer.equalsIgnoreCase("no"));
		System.out.println("Fai il login e porcedi con l'ordine:");
		logIn();
	}

	
	
	public void insertNewClient() {

		// fai collegamento con db insert into... con batch

		System.out.println("Registrazione avvenuta correttamente.\n Vuoi porcedere al Login? si/no");
		answer = scanner.nextLine();
		answer = ordine.checkInput(answer, "si", "no");
		if (answer.equalsIgnoreCase("si")) {
			ordine.faiOrdine();
		} else {
			System.out.println("Grazie per esserti registrato. A presto.");
		}
	}

	public void checkAddress() {
		/*
		 * lo richiamo dentro al Fai ordine se il cliente vuole il delivery!
		 * 
		 * // fai metodo per check indirizzo
		 * System.out.println("Il tuo indirizzo è corretto? si/no"); answer=
		 * scanner.nextLine(); //fai do while per controllo risposta e in caso immetti
		 * nuovo indirizzo con update modify...
		 */
	}
}
