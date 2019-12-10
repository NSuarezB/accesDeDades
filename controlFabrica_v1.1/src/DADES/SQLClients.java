package DADES;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import MODEL.Client;

//import com.sun.security.ntlm.Client;

import MODEL.lineaComanda;


public class SQLClients {

	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;

	String idClients, name, personaContacte,localitzacio;

	int codiPostal,morositat;
	
	
	/***
	 * 
	 * Conectar() - Comprova si hi ha connexio amb la base de dades
	 * 
	 * 		c - Es la ruta on esta la base de dades 
	 * @return 
	 * 
	 * 
	 * */

	public Connection conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:/home/natalia/muntatge.db");
			System.out.println("Exito al conectar con base de datos");

		} catch (Exception e) {

			System.out.println("Error al conectar con base de datos");

		}
		return null;

	}
	
	/***
	 * 
	 * 
	 *  insertaClients(Object client) - Fa insert a la base de dades
	 *  
	 *  nouClient(client) - Es l'objecte de la classe client
	 *  
	 *   # Totes les dades de les variables son obtingudes de nouClient , mitjançant els get's de la classe client
	 *  
	 *   		idClients(String)  
	 * 			name(String)
	 * 			personaContacte(String)
	 * 			localitzacio(String)
	 * 			codiPostal(int)
	 * 			morositat(int) / hauria de ser un boolean, però l'sqlite no conte aquest typedata
	 * 
	 * 	
	 * 	sqlInsert(String) - Conte la instrucció per insertar el client a la taula de la base de dades
	 * 
	 * 
	 * 	# Si s'executen totes les parts
	 * 
	 * 	try /
	 * 
	 * 		Conectar() - Utilitza el method conectar per tenir la variable c ( c contè la ruta de la base de dades )
	 * 		
	 * 		sentencia - Conte un estat fet a partir de la variable c 
	 * 
	 * 		senencia.executeUpdate(sqlInsert) - Aquesta linia fa un update a la base de dades amb els parametres del client introduit
	 * 
	 * 		
	 * 		sentencia.close
	 * 							-	Tanquem els dos elements
	 * 		c.close
	 * 	
	 * 
	 * 	# Si alguna part no s'executa
	 * 
	 * 		
	 * 		printa - Error al insertar datos en la tabla
	 * 
	 *
	 * 
	 * */


	public void insertaClients(Client nouClient) throws SQLException {

		 this.idClients=nouClient.getIdClient();

		 this.name=nouClient.getName();

		 this.personaContacte=nouClient.getPersonaContacte();

		 this.localitzacio=nouClient.getLocalitzacio();
		 
		 this.codiPostal=nouClient.getCodiPostal();
		 
		 this.morositat=nouClient.getMorositat();

		String sqlInsert = "INSERT INTO clients (idClients,name,personaContacte,localitzacio,codiPostal,morositat) "

		            	+ " VALUES ( \""+idClients+"\",\""+ name+"\",\""+personaContacte+"\",\""+ localitzacio+"\","+codiPostal+","+ morositat+");";


		try {

			conectar();
			
			sentencia = c.createStatement();
			
			sentencia.executeUpdate(sqlInsert);
			
			sentencia.close();

			c.close();

			System.out.println("Datos insertados");

		} catch (Exception e) {

			System.out.println("Error al insertar datos en la tabla");

		}

	}

	
	/**
	 * 
	 * 
	 *  consultaClients()
	 * 
	 * 
	 * */
	

	public ArrayList<Client> consultaClients(String nombreTabla) throws SQLException {

		conectar();

		ArrayList<Client> clients = new ArrayList<Client>();
		
		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";

		
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {

				String ID = rs.getString("idClients");
				String Nombre = rs.getString("name");
				String personaCon = rs.getString("personaContacte");
				String localitzacio = rs.getString("localitzacio");
				int codiPostal = rs.getInt("codiPostal");
				int morositat = rs.getInt("morositat");
				
			 	
				 clients.add(new Client(ID,Nombre,personaCon,localitzacio,codiPostal,morositat));
				
			
				
			}
			
			rs.close();

			sentencia.close();

			c.close();
			

		} catch (Exception e) {

			System.out.println("Fallo al recuperar datos");

		} 
		
		return(clients);


	}
	
	
	public void updateData(String idClient,int cosaCanvi,String cosaCanvi1,String cosaCanvi2,String cosaCanvi3) throws SQLException {
		
		
		String updateSql = "UPDATE clients SET codiPostal="+ cosaCanvi+",name=\""+ cosaCanvi1+"\",personaContacte=\""+cosaCanvi2+"\",localitzacio= \""+cosaCanvi3+"\" WHERE idClients=\""+idClient+"\";";
		
		System.out.println(updateSql);
		try {

			conectar();
			
			sentencia = c.createStatement();
			
			sentencia.executeUpdate(updateSql);
			
			sentencia.close();

			c.close();

			System.out.println("Actualizacion completada");

		} catch(Exception e) {
			
			System.out.println("Error al actualitzar");
			
		}
		
		
	}
	
	public void deleteData(String idClient) throws SQLException {
		
		String deleteSql = "DELETE FROM clients WHERE idClients=\""+idClient+"\""+";";
		
		System.out.println(deleteSql);
		try {

			conectar();
			
			sentencia = c.createStatement();
			
			sentencia.executeUpdate(deleteSql);
			
			sentencia.close();

			c.close();

			System.out.println("Dada esborrada completada");

		} catch(Exception e) {
			
			System.out.println("Error al esborrar");
			
		}
		
		
		
	}
	
	

}