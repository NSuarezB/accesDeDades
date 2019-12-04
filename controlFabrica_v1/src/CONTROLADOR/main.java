package CONTROLADOR;

import java.util.Arrays;

import DADES.LectorXML;
import MODEL.comanda;

public class main{
	
	public static void main(String[] args) {
		
		System.out.println("-----------------------");
		System.out.println("- Mostrem del fitxer -");
		System.out.println("-----------------------");
		System.out.println();
		LectorXML lector1 =  new LectorXML();
		
		System.out.println();
		
		
		System.out.println("----------------------");
		System.out.println("-- Mostrem objectes --");
		System.out.println("----------------------");
		System.out.println();
		System.out.println("Linies de comanda: "+lector1.getLinCom());
		
		comanda comanda1 = new comanda(lector1.getId_Client(),lector1.getId_comanda(),lector1.getArrayLiniaComan2());
		
		System.out.println();
		System.out.println(comanda1.toString());
		
		
		
	
		
	}
	
	
	
}