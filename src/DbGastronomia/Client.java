package DbGastronomia;


import java.util.ArrayList;
import java.util.List;

public class Client {

	private Integer idClient;
	private String name;
	private String surname;
	private String address;
	private String userName;
	private String password;
	private Integer cap;
	private String city;
	
	public Client() {};
	
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
}
