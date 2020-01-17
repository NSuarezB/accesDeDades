package DADES;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import MODEL.Client;
import MODEL.comanda;

//import com.sun.security.ntlm.Client;

import MODEL.lineaComanda;


public class SQLComandas {

	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;
	String[] array2=null;
	
	 ArrayList<comanda> arrayComand = new ArrayList<comanda>();
	
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


	public void insertaComanda( comanda coman) throws SQLException {
			
		
		int idClient=coman.getIdClient();
		int idComanda=coman.getIdComanda();
		float preu = coman.getPreu();
		int status = coman.getStatus();
		String dataOp=coman.getDataOpertura();
		String dataFi=coman.getDataFinalitzacio();
		ArrayList<lineaComanda> ted = new ArrayList<lineaComanda>();
		ted=coman.getArrayLiniaComan();
		
	
		
		String sqlInsert = "INSERT INTO comandes (idComanda,idClient,preu,dataObertura,dataFinalitzacio,status) "

		            	+ "VALUES ("+idComanda+","+ idClient+","+preu+","+ dataOp+","+dataFi+","+ status+");";
		
		 System.out.println(sqlInsert);
		 
		 SQLLiniesDeComanda asd = new SQLLiniesDeComanda();
		 ArrayList<lineaComanda> dsa= new ArrayList<lineaComanda>(); 
		 
		 for (int i = 0; i < dsa.size(); i++) {
			int idLineaComanda = dsa.get(i).getIdLineaComanda();
			int idComanda2=dsa.get(i).getIdComanda();
			int idArticle = dsa.get(i).getIdArticle();
			int unitatsDemanades=dsa.get(i).getUnitatsDemandes();
			int unitatsServides=dsa.get(i).getUnitatsServides();
			int status2=dsa.get(i).getStatus();
			 
			asd.insertarLineaComanda(new lineaComanda(idLineaComanda,idComanda2,idArticle,unitatsDemanades,unitatsServides,status2));
			
		}
		 
		 
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
	

	public ArrayList<comanda> consultaComanda(String nombreTabla) throws SQLException {

		conectar();

		ArrayList<comanda> comanda = new ArrayList<comanda>();
		
		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";
		System.out.println("hi");
		
		try {
			System.out.println("dentro del try");
			ResultSet rs = sentencia.executeQuery(consultaSql);
			System.out.println(consultaSql);
			while (rs.next()) {
				System.out.println("dentro del while");

				int ID = rs.getInt("idComanda");
				int Client = rs.getInt("idClient");
				float preu = rs.getFloat("preu");
				String obert = rs.getString("dataObertura");
				String finalitzat =  rs.getString("dataFinalitzacio");
				int status = rs.getInt("status");
			
				System.out.println(ID);
				 comanda.add(new comanda(ID,Client,preu,obert,finalitzat,status));
				
			
				
			}
			
			rs.close();

			sentencia.close();

			c.close();
			

		} catch (Exception e) {

			System.out.println("Fallo al recuperar datos");

		} 
		
		return(comanda);


	}
	
	
/*	public void updateData(String idClient,int cosaCanvi,String cosaCanvi1,String cosaCanvi2,String cosaCanvi3,int cosaCanvi4) throws SQLException {
		
		
		String updateSql = "UPDATE clients SET codiPostal="+ cosaCanvi+",name=\""+ cosaCanvi1+"\",personaContacte=\""+cosaCanvi2+"\",localitzacio= \""+cosaCanvi3+"\",morositat="+cosaCanvi4+" WHERE idClients=\""+idClient+"\";";
		
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
		
		
	} */
	
	public void deleteComanda(int idComanda) throws SQLException {
		
		String deleteSql = "DELETE FROM comandes WHERE idComanda="+idComanda+";";
		
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
	
	public String[] getArray2() {
		return array2;
	}
	
	public void setArray2(String[] array2) {
		this.array2 = array2;
	}
	



}