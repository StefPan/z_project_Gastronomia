package it.db.gastronmia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import z_project_Gastronomia.Ordini;

public class MainDb {

	public static void main(String[] args) throws SQLException{
		    //Ufo unicode
	        System.out.println("\uD83D\uDC7D");
	        
	        
	        //LISTA PER INSERIRE PRIMI CLIENTI USANDO utility.populateClient()
	  /*    List<Client> listaClienti = new ArrayList<>();
	        Client client1 = new Client(1,"Mario", "Rossi", "Via Ticino, 41", 51030, "Pistoia");
	        Client client2 = new Client(2,"Luca", "Bianchi", "Via Rossini, 45", 59100, "Prato");
	        Client client3 = new Client(3,"Anna", "Verdi", "Via Dalmazia, 54", 50126, "Firenze");
	        
	        listaClienti.add(client1);
	        listaClienti.add(client2);
	        listaClienti.add(client3);
	    */ 
	        
	        LogInClienti logIn = new LogInClienti();
	        
	        
	        
	        logIn.logIn();
	        
	        
	        
	        
	        /*
	         * gestore per delivery, ..fatta da delivery manager, deliveryboy indirizzo delivery,
	         *  cibo dlivery*/
	        /* Fai check se cliente è registrato e se l'indirizzo è corretto..
	         *  leggi nome cognome e indirizzo.  in caso non esiste il suo cod fiscale si registra,
	         *   poi si procede all'ordine */
	       
	/*        UtilitiesMethods utility = new UtilitiesMethods();
       
/*	        utility.createClient();
		    for(Client client: listaClienti) {
		      utility.populateClient(client);
	        }
		    ClientBatch.populateClientBatch();
		
	*/	
		   
	        
	        
	        
	        
	        
	}
}
