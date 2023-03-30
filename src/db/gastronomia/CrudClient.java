package db.gastronomia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudClient implements Crud{
ConnectionDb connection = new ConnectionDb();

	private static final String URL = "jdbc:mysql://localhost:3306/progettogastronomia";
	private static final String USER = "root";
	private static final String PASSWORD = "13febbraio";
	
	
	public void createClient() throws SQLException{
		
		//Connection connection= null;
		
		try {
			//CREO CONNESSIONE
			//CREO STATEMENT
			Statement statement =connection.getConnection();
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
			connection.closeConnection();
			}
		}
	
	public void populateClient(Client client) throws SQLException{
		
			
		try {
			
			Statement statement = connection.getConnection();
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
			
			connection.closeConnection();
			
			System.out.println("Inserito nuovo Cliente");
		}catch  (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	
	
public  void populateClientBatch(Client cliente) throws SQLException{
		
		Connection connection = null;
 
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement= connection.createStatement();
			PreparedStatement prestat= connection.prepareCall("INSERT INTO clienti(nome, cognome,  email, passwrd, indirizzo, cap, citta)"
					+ "VALUES(?,?,?,?,?,?,?)");
			
			
				prestat.setString(1, cliente.getName());
				prestat.setString(2, cliente.getSurname());
				prestat.setString(3, cliente.getUserName());
				prestat.setString(4, cliente.getPassword());
				prestat.setString(5, cliente.getAddress());
				prestat.setInt(6,cliente.getCap());
				prestat.setString(7, cliente.getCity());
				prestat.addBatch();
					
			prestat.executeBatch();
			
			prestat.close();
			
			
			ResultSet leggoTable = statement.executeQuery("SELECT * FROM clienti WHERE email= \" " +cliente.getUserName() + " \";");
			
			System.out.println("Registrazione completata.");
			
			while(leggoTable.next()) {
				System.out.println("Cliente: Nome: "+ leggoTable.getString("nome")+""
					+ " Cognome: " + leggoTable.getString("cognome") + ""
					+ " User: " + leggoTable.getString("email") +" " 
					+ " Indirizzo: " + leggoTable.getString("indirizzo")+" "
					+ " Cap: " + leggoTable.getInt("Cap")+ " "
					+ " Città: " + leggoTable.getString("citta"));
			}
		
			connection.close();

		} catch  (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public  void readClient(String email) throws SQLException{
		
		try {
			
			Statement statement= connection.getConnection();

			ResultSet leggoTable = statement.executeQuery("SELECT * FROM clienti WHERE email = \""+ email +"\";");
			

			while(leggoTable.next()) {
				System.out.println("Cliente: Nome: "+ leggoTable.getString("nome")+""
					+ " Cognome: " + leggoTable.getString("cognome") + ""
					+ " User: " + leggoTable.getString("email") +" " 
					+ " Indirizzo: " + leggoTable.getString("indirizzo")+" "
					+ " Cap: " + leggoTable.getInt("Cap")+ " "
					+ " Città: " + leggoTable.getString("citta"));
			}
			
			connection.closeConnection();
		
			

		} catch  (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void deleteClient(String email) throws SQLException{
		
		try {
		Statement statement= connection.getConnection();
		ResultSet leggoTable = statement.executeQuery("Delete * FROM clienti WHERE email = \""+ email +"\";");
		
		connection.closeConnection();
		
		System.out.println("Unscribed. \nSperiamo di rivederti presto.");
	} catch  (SQLException e) {
		e.printStackTrace();
	}
	}
	
	
	@Override
	public void createTable() {
		
	}

	@Override
	public void readTable() {
	
		
	}
	
	
}
