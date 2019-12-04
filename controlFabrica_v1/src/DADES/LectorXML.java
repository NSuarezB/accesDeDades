package DADES;


import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import MODEL.lineaComanda;

import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class LectorXML {

	 ArrayList<lineaComanda> arrayLiniaComan2 = new ArrayList<lineaComanda>();
	 char status;
	 int id_Client;
	 int id_comanda=01;
	 float preu;
	 int quantitat;
	 int linCom;
		
	 public LectorXML(){

      try {
         File inputFile = new File("comanda.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Element principal :" + doc.getDocumentElement().getNodeName());
         System.out.println("client :" + doc.getDocumentElement().getAttribute("id_client"));
         id_Client=Integer.parseInt(doc.getDocumentElement().getAttribute("id_client"));
         NodeList nList = doc.getElementsByTagName("article");
         System.out.println("Status :" + doc.getDocumentElement().getAttribute("status"));
         status=doc.getDocumentElement().getAttribute("status").charAt(0);
         System.out.println();
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
              
               System.out.println("Codi del article : " 
                  + eElement
                  .getElementsByTagName("id")
                  .item(0)
                  .getTextContent());
               System.out.println("Unitats d'articles : " 
                  + eElement
                  .getElementsByTagName("unitats")
                  .item(0)
                  .getTextContent());
               System.out.println("Preu per unitat : " 
                       + eElement
                       .getElementsByTagName("preu")
                       .item(0)
                       .getTextContent());
               
             arrayLiniaComan2.add(new lineaComanda(temp+1,Integer.parseInt(eElement
            		 .getElementsByTagName("id")
                     .item(0)
                     .getTextContent()),
            		 id_comanda,
            		 Integer.parseInt(eElement
                     .getElementsByTagName("unitats")
                     .item(0)
                     .getTextContent()),
            		 Float.parseFloat(eElement
                     .getElementsByTagName("preu")
                     .item(0)
                     .getTextContent()),
            		 status));
            }
            linCom=temp+1;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
	 }
	 
	 public ArrayList<lineaComanda> getArrayLiniaComan2() {
		return arrayLiniaComan2;
	}
	 
	 public int getId_Client() {
		return id_Client;
	}
	 public int getLinCom() {
		return linCom;
	}
	 public int getId_comanda() {
		return id_comanda;
	}
}
 
