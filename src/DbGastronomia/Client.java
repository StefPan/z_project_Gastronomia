package DbGastronomia;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import z_project_Gastronomia.Cliente;

public class Client {
	
	private static final String URL = "jdbc:mysql://localhost:3306/progettogastronomia";
	private static final String USER = "root";
	private static final String PASSWORD = "13febbraio";
	
	private Integer idClient;
	private String name;
	private String surname;
	private String address;
	private String userName;
	private String password;
	private Integer cap;
	private String city;
	
	public List<Client> listaClienti = new ArrayList();
	
	public Client() {};
	
	public Client(String name, String surname, String address,String userName, String password, Integer cap, String city) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.userName= userName;
		this.password= password;
		this.cap = cap;
		this.city = city;
	}
	public Client(Integer idClient, String name, String surname, String address,String userName, String password, Integer cap, String city) {
		this.idClient = idClient;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.userName= userName;
		this.password= password;
		this.cap = cap;
		this.city = city;
	}
	
	public Integer getIdClient() {
		return this.idClient;
	}
	
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
 	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void addList(Client cliente) {
		List<Client>listaClienti = new ArrayList<>();
		listaClienti.add(cliente);
	}

	public String toString() {
		return "Cliente:\nNome: " + name+ " Surname: "+ surname + " Address: " + address
				+ " Email: " + userName + " Cap: " + cap + " City: "+ city ;
	}
	
	public List<Client> getClientFromFile() throws IOException {
		
		//copio tutto il contenuto del file su stringa
		String dataFile= new String(Files.readAllBytes(Paths.get("fileClienti.txt")),StandardCharsets.UTF_8);
		//creo array di stringhe e ci metto lo split della stringa spittata da ',' e  '\n'
		String[] splitFile = dataFile.split("[,\n]");
		//copio tutto su ArrayList così ci lavoro meglio
		List<String> listadatas = new ArrayList<>();
		
		/*e ora fai in modo di mettere ogni campo in un singolo arraylist 
		 *e poi metti tutto insieme in un unico arraylist e alla fine fai batch 
		 *e insersci dati su Db...Facile no!?..*/ 
		
		//aggiungo tutti gli elementi di splitFile ad una collezione 'listadatas'
		Collections.addAll(listadatas, splitFile);
		System.out.println(listadatas);
		
		List<String> nameList = new ArrayList();
		List<String> surnameList = new ArrayList();
		List<String> addressList = new ArrayList();
		List<String> usernameList = new ArrayList();
		List<String> passwordList = new ArrayList();
		List<Integer> capList = new ArrayList();
		List<String> cityList = new ArrayList();
		
		for(int i=0;i<listadatas.size();i+=8 ) {
			nameList.add(listadatas.get(i).trim());
		}
		for(int i=1;i<listadatas.size();i+=8 ) {
			surnameList.add(listadatas.get(i).trim());
		}
		for(int i=2;i<listadatas.size();i+=8 ) {
			addressList.add(listadatas.get(i).trim());
		}
		for(int i=3;i<listadatas.size();i+=8 ) {
			usernameList.add(listadatas.get(i).trim());
		}
		for(int i=4;i<listadatas.size();i+=8 ) {
			passwordList.add(listadatas.get(i).trim());
		}
		for(int i=5;i<listadatas.size();i+=8 ) {
			capList.add(Integer.parseInt(listadatas.get(i).trim()));
		}
		for(int i=6;i<listadatas.size();i+=8 ) {
			cityList.add(listadatas.get(i));
		}
		
		//ora assegno all'oggetto definitivo la riga dedicata a ciascun cliente....
	
		
		for(int i=0; i<nameList.size(); i++) {
			Client client= new Client(nameList.get(i),surnameList.get(i),
					addressList.get(i),usernameList.get(i), passwordList.get(i),capList.get(i),cityList.get(i));
			
			listaClienti.add(client);
			}
		return listaClienti;
		
	}
			

	public static void populateClientBatchFromFile(List<Client> listaClienti) throws SQLException{
		 
		
		Connection connection = null;
 
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement= connection.createStatement();
			PreparedStatement prestat= connection.prepareCall("INSERT INTO clienti(nome, cognome, indirizzo, email, passwrd, cap, citta)"
					+ "VALUES(?,?,?,?,?,?,?)");
			
			for(int i =0; i< listaClienti.size();i++) {
				Client cliente = listaClienti.get(i);
				prestat.setString(1, cliente.getName());
				prestat.setString(2, cliente.getSurname());
				prestat.setString(3, cliente.getAddress());
				prestat.setString(4, cliente.getUserName());
				prestat.setString(5, cliente.getPassword());
				prestat.setInt(6,cliente.getCap());
				prestat.setString(7, cliente.getCity());
				prestat.addBatch();
			}
			
			prestat.executeBatch();
			
			prestat.close();
			
			
			ResultSet leggoTable = statement.executeQuery("SELECT * FROM clienti;");
			
			while(leggoTable.next()) {
				System.out.println("Cliente: Nome: "+ leggoTable.getString("nome")+""
					+ " Cognome: " + leggoTable.getString("cognome") + ""
					+ " Indirizzo: " + leggoTable.getString("indirizzo")+" "
					+" User: " + leggoTable.getString("email") + " " + " Cap: " + leggoTable.getInt("Cap")
					+" " + " Città: " + leggoTable.getString("citta"));
			}
			
			connection.close();
		
			

		} catch  (SQLException e) {
			e.printStackTrace();
		}
	}



	
}
