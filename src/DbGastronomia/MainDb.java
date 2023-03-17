package DbGastronomia;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import z_project_Gastronomia.Ordini;

public class MainDb {
	public static void main(String[] args) throws SQLException, IOException {
		    //Ufo unicode
	        System.out.println("\uD83D\uDC7D");
	        
	        
	        //LISTA PER INSERIRE PRIMI CLIENTI USANDO utility.populateClient()
/*	      List<Client> listaClienti = new ArrayList<>();
	        Client client1 = new Client(10,"Mario", "Rossi", "Via Ticino, 41", "emailacaso@gmail.com", "polino3",51030, "Pistoia");
	        Client client2 = new Client(11,"Luca", "Bianchi", "Via Rossini, 45", "siort@gmail.com", "pasword23",59100, "Prato");
	        Client client3 = new Client(12,"Anna", "Verdi", "Via Dalmazia, 54", "dioerfn@gmail.com", "derftgyh2",50126, "Firenze");
	        
	        listaClienti.add(client1);
	        listaClienti.add(client2);
	        listaClienti.add(client3);
	*/    
	        //popolo classe da file:
	        Client cliente= new Client();
	 /*       List<Client> listaClienti=new ArrayList<>();
	        listaClienti=cliente.getClientFromFile();
	        Client.populateClientBatchFromFile(listaClienti);
	   */     
	        
	       GestioneCliente gestioneCliente = new GestioneCliente();
	        Ordini ordine = new Ordini();
	 //CONTROLLO SELECT SU SINGOLO CLIENTE       
	 //   cliente.resultSetSingolo("stefanialorenz@gmail.com");
	 
	        //faccio il login, che in automatico richiama il metodo subscribe 
	//       gestioneCliente.logIn();
	
	        ordine.faiOrdine();
	        
	       //faccio l'ordine 
	//        ordine.faiOrdine();
	        //richiamo metodo check indirizzo
	        gestioneCliente.checkAddress();
	     
	        
	        
	        /*
	         * gestore per delivery, ..fatta da delivery manager, deliveryboy indirizzo delivery,
	         *  cibo dlivery*/
	        /* Fai check se cliente è registrato e se l'indirizzo è corretto..
	         *  leggi nome cognome e indirizzo.  in caso non esiste il suo cod fiscale si registra,
	         *   poi si procede all'ordine */
	       
	/*       UtilitiesMethods utility = new UtilitiesMethods();
       
	       utility.createClient();
		    for(Client client: listaClienti) {
		      utility.populateClient(client);
	        }
		    ClientBatch.populateClientBatch();
		
		*/
		   
	     //ricorda anche di fare i controlli su inserimento carne insalata ecc.. il camilcaseecc   
	        
	        
	        
	        
	}
}

