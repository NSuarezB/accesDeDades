package CONTROLADOR;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import DADES.LectorXML;
import DADES.SQLClients;
import MODEL.Client;
import MODEL.comanda;

public class main{
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("-----------------------");
		System.out.println("- Mostrem del fitxer -");
		System.out.println("-----------------------");
		System.out.println();
		LectorXML lector1 =  new LectorXML();
		ArrayList<Client> arrayClient = new ArrayList<Client>();
	//	client clientNou = new client("GGG","ClientNou1","NomPersona1","localitzacioNova1",1111,0);
		
		
		System.out.println();
		
		
		System.out.println("----------------------");
		System.out.println("-- Mostrem objectes --");
		System.out.println("----------------------");
		System.out.println();
		System.out.println("Linies de comanda: "+lector1.getLinCom());

		System.out.println(lector1.getArrayComand());
		
		SQLClients conexio = new SQLClients();
		//conexio.conectar();
		//conexio.deleteData("GGG");
		
	//	conexio.updateData("GGG", 2222);
	//	conexio.insertaClients(clientNou);
		
		
		//arrayClient=conexio.consultaClients("clients");
		
		//System.out.println(arrayClient);
		
		
		//System.out.println(conexio.getClients());
		//System.out.println(conexio);
	
		//System.out.println(comanda1.toString());
		
		
		
	
		
	}
	
	
	
}