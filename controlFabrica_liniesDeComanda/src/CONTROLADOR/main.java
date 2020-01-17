package CONTROLADOR;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;

import DADES.SQLLiniesDeComanda;
import DADES.LectorXML;
import DADES.SQLClients;
import DADES.SQLComandas;
import MODEL.Client;
import MODEL.comanda;
import MODEL.lineaComanda;

public class main{
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("-----------------------");
		System.out.println("- Mostrem del fitxer -");
		System.out.println("-----------------------");
		System.out.println();
		
		LectorXML lector1 =  new LectorXML();
		int idClient=0;
		int idComanda=0;
		int status=0;
		String dataOp="";
		String dataFi="";
		float preu=(float) 0.0;
		
		ArrayList<comanda> arrayComan = new ArrayList(); 
		ArrayList<comanda> consulta = new ArrayList(); 
		ArrayList<lineaComanda> lineaComArray = new ArrayList();
		//ArrayList<Client> arrayClient = new ArrayList<Client>();
	//	client clientNou = new client("GGG","ClientNou1","NomPersona1","localitzacioNova1",1111,0);
		
		System.out.println(lector1.getArrayComan2());
		
	/*	System.out.println();
		
		
		System.out.println("----------------------");
		System.out.println("-- Mostrem objectes --");
		System.out.println("----------------------");
		System.out.println();
		System.out.println("Linies de comanda: "+lector1.getLinCom());

	*/
		SQLLiniesDeComanda liniaCom=new SQLLiniesDeComanda();
		liniaCom.conectar();
		
		LectorXML lector = new LectorXML();
		liniaCom.consultaLineaComanda("lineaComanda");
		
		System.out.println(lector.getArrayComand());
		
		
		//liniaCom.insertLineaComanda(lector.getLineaComanPR());
		/*lineaComArray=lector.getLineaComanPR();
		for (int i = 0; i < lineaComArray.size(); i++) {
			
			int idLineaComanda=lineaComArray.get(i).getIdLineaComanda();
			 idComanda = lineaComArray.get(i).getIdComanda();
			int idArticle= lineaComArray.get(i).getIdArticle();
			int unitatsDemandes = lineaComArray.get(i).getUnitatsDemandes();
			int unitatsServides = lineaComArray.get(i).getUnitatsServides();
			 status=lineaComArray.get(i).getStatus();
			lineaComanda comanda1=new lineaComanda(idLineaComanda,idComanda,idArticle,unitatsDemandes,unitatsServides);
			try {
				liniaCom.insertLineaComanda(comanda1);
			
				

				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		
		
	
		
	//}
	
	}
	
}