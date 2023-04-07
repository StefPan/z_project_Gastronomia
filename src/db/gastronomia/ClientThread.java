package db.gastronomia;

import java.sql.SQLException;

public class ClientThread extends Thread{
private GestioneClient client;

/*public ClientThread(GestioneClient client) {
	this.client= client;
}*/
	
	@Override
	public void run() {
		GestioneClient obj = new GestioneClient();
		try {
			obj.logIn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
