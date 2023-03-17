package DbGastronomia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	GestioneCliente client = new GestioneCliente();

	Scanner scanner = new Scanner(System.in);

	public void logIn() throws SQLException {

		// Connection connection = null;
		System.out.println("Inserisci il tuo indirizzo email:");
		email = scanner.nextLine();

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet leggiTab1;
			ResultSet leggiTab2;
			leggiTab1 = statement.executeQuery("SELECT * FROM clienti WHERE email = \"" + email + "\";");

			// controllo se utente è registrato con quella email
			if (leggiTab1.next()) {

				if (leggiTab1.getString("email").equalsIgnoreCase(email)) {
					System.out.println("Inserisci Password:");
					password = scanner.nextLine();

					// se password corretta da il benvenuto
					if (password.equals(leggiTab1.getString("passwrd"))) {
						System.out.println("Benvenuto ");// +leggiTab1.getString("nome") + "\n");
						ordine.faiOrdine();
					}

					// altrimenti fa inserire la password fino a che non è corretta
					else {
						boolean ciclo = true;
						do {
							System.out.println("Inserita una password scorretta: reinserisci la password: ");
							password = scanner.nextLine();
							if (!password.equals(leggiTab1.getString("passwrd"))) {
								System.out.println(
										"Inserita una password scorretta: reinserisci la password o premi 0 per uscire: ");
								password = scanner.nextLine();
								if (password.equals("0")) {
									System.out.println("Arrivederci!");
									ciclo = false;
									// break;
								}
							} else {
								System.out.println("Benvenuto " + leggiTab1.getString("nome") + "\n");
							}
						} while (!password.equals(leggiTab1.getString("passwrd")) && (ciclo == true));

					}

				}
			} else if (leggiTab1.getFetchSize() == 0) {

				System.out.println("Utente non registrato, procedere alla registrazione.\nsi/no:");
				answer = scanner.nextLine();
				if()
				client.subscribe();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void subscribe() {
		do {
			System.out.println("Iscriviti:");
			Client cliente = new Client();

			System.out.print(" Enter Name => ");
			String firstName = scanner.nextLine();
			cliente.setName(firstName);

			System.out.print(" Enter Surname => ");
			surname = scanner.nextLine();
			cliente.setSurname(surname);

			System.out.print(" Enter address => ");
			String address = scanner.nextLine();
			cliente.setAddress(address);

			System.out.print(" Enter email => ");
			email = scanner.nextLine();
			cliente.setUserName(email);

			System.out.print(" Enter password => ");
			password = scanner.nextLine();
			cliente.setPassword(password);

			System.out.print(" Enter post code => ");
			cap = scanner.nextInt();
			cliente.setCap(cap);

			System.out.print(" Enter City => ");
			city = scanner.nextLine();
			cliente.setCity(city);

			System.out.println("I tuoi dati sono corretti?\n" + cliente.toString() + "\nsi/no");
			answer = scanner.nextLine();
			ordine.
			if (answer.equalsIgnoreCase("si")) {
				client.insertNewClient();
			}
		} while (!answer.equalsIgnoreCase("no"));
		// else if(answer.equalsIgnoreCase("no")) {

	}

	public void insertNewClient() {
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
