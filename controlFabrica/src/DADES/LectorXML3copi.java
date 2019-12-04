package DADES;


import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import MODEL.comanda;
import MODEL.lineaComanda;

import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class LectorXML3copi {

	 ArrayList<lineaComanda> arrayLiniaComan2 = new ArrayList<lineaComanda>();
	 ArrayList<comanda> arrayComand = new ArrayList<comanda>();
	 int id_Artic;
	 String id_Client;
	 int id_comanda;
	 int quantitat;
	 float preu;
	 int unitatServ;
	 
	 char status;
	 
	 int linCom;
	 int numArtic;
	 public LectorXML3copi(){

      try {
         File inputFile = new File("comanda.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Element principal :" + doc.getDocumentElement().getNodeName());
        
         NodeList nList = doc.getElementsByTagName("comanda");
       //  numArtic=Integer.parseInt(doc.getDocumentElement().getAttribute("num_art"));
         
         
         /* Status de la comanda */

         
         
       //  id_Client=doc.getDocumentElement().getAttribute("id_client");
         //status=doc.getDocumentElement().getAttribute("status").charAt(0);
        
         System.out.println();
         System.out.println("----------------------------");
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("***");
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                
                System.out.println("Id del client : " 
                        + eElement.getAttribute("id_client"));
                id_Client=eElement.getAttribute("id_client");
                System.out.println("Id de la comanda:"
                        + eElement.getAttribute("id_comanda"));
                id_comanda=Integer.parseInt(eElement.getAttribute("id_comanda"));
                System.out.println("Status:" 
                        + eElement.getAttribute("status"));
                
                
            	}
            System.out.println("***");
            System.out.println(id_Client);
           
            System.out.println("cl "+id_Client);
            	
         //   if(id_Client.equals("AA")) {
            	
          //  	System.out.println("hola");
            	
            	NodeList aList = doc.getElementsByTagName("article");
                  for (int temp2 = 0; temp2 < aList.getLength(); temp2++) {
                      Node aNode = aList.item(temp2);
                      System.out.println("\nCurrent Element :" + aNode.getNodeName());
                            
                        if (aNode.getNodeType() == Node.ELEMENT_NODE && id_Client.contentEquals("AA")) {
                         	Element aElement = (Element) aNode;
                            
                            
                            System.out.println("Codi del article : " 
                                    + aElement
                                    .getElementsByTagName("id")
                                    .item(0)
                                    .getTextContent());
                            
                            System.out.println("Unitats d'articles : " 
                                    + aElement
                                    .getElementsByTagName("unitats")
                                    .item(0)
                                    .getTextContent());
                            System.out.println("Unitats servides : " 
                                    + aElement
                                    .getElementsByTagName("unitatsServides")
                                    .item(0)
                                    .getTextContent());
                            System.out.println("Preu per unitat : " 
                                     + aElement
                                      .getElementsByTagName("preu")
                                      .item(0)
                                      .getTextContent());
                            System.out.println("Status per LC : " 
                                    + aElement
                                     .getElementsByTagName("status")
                                     .item(0)
                                     .getTextContent());
                            
                            id_Artic=Integer.parseInt(aElement.getElementsByTagName("id").item(0).getTextContent());
                            quantitat=Integer.parseInt(aElement
                                    .getElementsByTagName("unitats")
                                    .item(0)
                                    .getTextContent());
                            unitatServ=Integer.parseInt(aElement
                                    .getElementsByTagName("unitatsServides")
                                    .item(0)
                                    .getTextContent());
                            
                            preu=Float.parseFloat(aElement
                                    .getElementsByTagName("preu")
                                    .item(0)
                                    .getTextContent());
                            
                            status=aElement.getElementsByTagName("status").item(0).getTextContent().charAt(0);
                           
                            
                            
                            System.out.println("Unitats servides :"+ aElement.getElementsByTagName("unitatsServides").item(0).getTextContent());
                            arrayLiniaComan2.add(new lineaComanda(temp2+1,id_Artic,id_comanda,quantitat,preu,status,unitatServ));
                        
                        
                        }
                        linCom=temp2+1;
                  }
                  
            	
            }
            
            
       		 
         
         
       
                
            
          /*  if (nNode.getNodeType() == Node.ELEMENT_NODE) {
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
            		 
         
            		 
            		 
            		 */
            
            
         
      } catch (Exception e) {
         e.printStackTrace();
      }
	 }
	 
	 public ArrayList<lineaComanda> getArrayLiniaComan2() {
		return arrayLiniaComan2;
	}
	 
	 public String getId_Client() {
		return id_Client;
	}
	 public int getLinCom() {
		return linCom;
	}
	 public int getId_comanda() {
		return id_comanda;
	}
}
 
