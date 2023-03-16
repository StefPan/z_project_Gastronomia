package DbGastronomia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UtilitiesMethods{

	private static final String URL = "jdbc:mysql://localhost:3306/progettogastronomia";
	private static final String USER = "root";
	private static final String PASSWORD = "13febbraio";
	
	
	public void createClient() throws SQLException{
		
		Connection connection= null;
		
		try {
			//CREO CONNESSIONE
			
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			//CREO STATEMENT
			Statement statement = connection.createStatement();
			//ISTRUZIONI STATEMENT
			String createClient = 
					"CREATE TABLE IF NOT EXISTS clienti(\r\n"
							+ "id_clienti INT NOT NULL AUTO_INCREMENT,\r\n"
							+ "nome VARCHAR(255) NOT NULL DEFAULT'-',\r\n"
							+ "cognome VARCHAR(255) DEFAULT '-',\r\n"
							+ "indirizzo VARCHAR(255) DEFAULT '-',\r\n"
							+ "cap VARCHAR(10) DEFAULT '-',\r\n"
							+ "citta VARCHAR(100) DEFAULT '-',\r\n"
							+ "PRIMARY KEY (id_clienti));";
			//ASSEGNA STATEMENT
			statement.execute(createClient);
			//CLOSE CONNECTION
	
			System.out.println("Tabella clienti creata!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				if(connection!=null)
					connection.close();
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		}
	
	public void populateClient(Client client) throws SQLException{
		Connection connection =null;
			
		try {
			connection= DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			String populate=
					"INSERT INTO clienti \n VALUES \n"
					+ "("+ client.getIdClient() + ", " 
					+ "\'" + client.getName() + "\', "
					+ "\"" + client.getSurname() + "\", "
					+ "\'" + client.getAddress() + "\', "
					+ "\'" + client.getCap() + "\', "
					+ "\'" + client.getCity() + "\'"
					+");";
			
			statement.execute(populate);
			
			connection.close();
			
			System.out.println("Inserito nuovo Cliente");
		}finally {}
	}	
	
	/* CREO METODI
	*		1)CONNESSIONE AL DATABASE;
	*		2)CREAZIONE DEGLI STATEMENT E RELATIVE ISTRUZIONI(corpo dello statement);
	*		3)ASSEGNAZIONE DELL'ISTRUZIONE ALLO STATEMENT;
	*		4)CHIUSURA DELLA CONNESSIONE.
	*/

	
	
}
