package z_project_Gastronomia;



public class Cliente {

	private String nome;
	private String cognome;
	private String indirizzo;
	
		
	public Cliente(String nome, String cognome, String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
	
	
}
