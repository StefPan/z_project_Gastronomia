package db.gastronomia;


import java.io.File;
import java.io.FileNotFoundException;
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
import java.util.Scanner;

public class ClientBatch {
	
	private static final String URL = "jdbc:mysql://localhost:3306/progettogastronomia";
	private static final String USER = "root";
	private static final String PASSWORD = "13febbraio";
	
	private static String nome[]= {"Giulia", "Carlo", "Elena","Chiara", "Paolo","Federico"};
	private static String cognome[]= {"Rossi", "Bianchini", "Verdetti","Brini", "Rossetti","Verdi"};
	private static String  indirizzo[]= {"Via Ticino,42", "Via Riccioli,55", "Via Giotto, 88", "Via Gignoro, 62","Via lovini, 1", "Via Fiorelli, 15"};
	private static int cap[]= {12152,65467,12554,12543,24583,98698};
	private static String citta[]= {"Roma", "Firenze", "Milano","Roma", "Palermo","Modena"};
	

	public static String[] getNomi() {
		return nome;
	}

	public static String[] getCognomi() {
		return cognome;
	}

	public static String[] getIndirizzo() {
		return indirizzo;
	}

	public static int[] getCap() {
		return cap;
	}

	public static String[] getCitta() {
		return citta;
	}


	 /*dichiaro variavile di tipo Connection, 
	  * Nel try creo connessione con DriveManager,
	  * creo prestatement "insert into.. value(?,?,?);";
	  * assegno valori con
	  * 		 for(){ prestat.setString(index, nome), 
	  * 			prestat.addBatch;
	  * eseguo batch
	  * chiudo prestat e connessione
	  * scrivo i catch.	
	  * */
	/* E ora vai nel MainDb e richiamalo =) */

	public static void populateClientBatch() throws SQLException{
 
		
			Connection connection = null;
	 
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement= connection.createStatement();
				PreparedStatement prestat= connection.prepareCall("INSERT INTO clienti(nome, cognome, indirizzo, cap, citta)"
						+ "VALUES(?,?,?,?,?)");
				
				for(int i=0; i<6; i++) {
					prestat.setString(1, nome[i]);
					prestat.setString(2, cognome[i]);
					prestat.setString(3, indirizzo[i]);
					
					prestat.setInt(4,cap[i]);
					prestat.setString(5, citta[i]);
					prestat.addBatch();
				}
				
				prestat.executeBatch();
				
				prestat.close();
				
				
				ResultSet leggoTable = statement.executeQuery("SELECT * FROM clienti;");
				
				while(leggoTable.next()) {
					System.out.println("Cliente: Nome: "+ leggoTable.getString("nome")+""
						+ " Cognome: " + leggoTable.getString("cognome") + ""
						+ " Indirizzo: " + leggoTable.getString("indirizzo")+ "Cap: " + leggoTable.getInt("Cap")
						+ " Città: " + leggoTable.getString("citta"));
				}
				
				connection.close();
			
				
 
			} catch  (SQLException e) {
				e.printStackTrace();
			}
		}


}	