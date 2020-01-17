package DADES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import CONTROLADOR.main;
import MODEL.Client;
import MODEL.comanda;
import MODEL.lineaComanda;

public class SQLLiniesDeComanda{
	

	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;
	String[] array2=null;
	
	 ArrayList<lineaComanda> lineaComanda = new ArrayList<lineaComanda>();

	private int idLineaComan;

	private int idComanda;

	private int idArticle;

	private int unitatsDemanades;

	private int unitatsServides;

	private int status;
	
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
	
	
	public ArrayList<MODEL.lineaComanda> consultaLineaComanda(String nombreTabla) throws SQLException {

		conectar();

		ArrayList<lineaComanda> comanda = new ArrayList<lineaComanda>();
		
		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";
		System.out.println("hi");
		
		try {
			System.out.println("dentro del try");
			ResultSet rs = sentencia.executeQuery(consultaSql);
			System.out.println(consultaSql);
			while (rs.next()) {
				System.out.println("dentro del while");

				int idLineaComanda = rs.getInt("idLineaComanda");
				int idComanda = rs.getInt("idComanda");
				int idArticle = rs.getInt("idArticle");
				//float preu=rs.getFloat("preu");
				int unitatsDemanades= rs.getInt("unitatsDemanades");
				int unitatsServides =  rs.getInt("unitatsServides");
				int status = rs.getInt("estatus");
			
				//System.out.println(ID);
				 lineaComanda.add( new lineaComanda(idLineaComanda,idComanda,idArticle,unitatsDemanades,status));
				
			
			}
			
			rs.close();

			sentencia.close();

			c.close();
			

		} catch (Exception e) {

			System.out.println("Fallo al recuperar datos");

		} 
		
		return(lineaComanda);


	}
	
	public void insertarLineaComanda(lineaComanda lineaComanda) throws SQLException {

		 this.idLineaComan=lineaComanda.getIdLineaComanda();

		 this.idComanda=lineaComanda.getIdComanda();

		 this.idArticle=lineaComanda.getIdArticle();

		 this.unitatsDemanades=lineaComanda.getUnitatsDemandes();
		 
		 this.unitatsServides=lineaComanda.getUnitatsServides();
		 
		 this.status=lineaComanda.getStatus();

		String sqlInsert = "INSERT INTO lineaComanda (idLineaComan,idComanda,idArticle,unitatsDemanades,unitatsServides,estatus) "

		            	+ " VALUES ( "+idLineaComan+","+ idComanda+","+idArticle+","+unitatsDemanades+","+unitatsServides+","+ status+");";

		System.out.println(sqlInsert);
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
	
	
	
	
}