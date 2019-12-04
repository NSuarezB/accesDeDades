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


public class LectorXML {

	
	 ArrayList<comanda> arrayComand = new ArrayList<comanda>();
	 
	 int id_Artic;
	 String id_Client;
	 int id_comanda;
	 int quantitat;
	 float preu;
	 int unitatServ;
	 
	 char status;
	 char statusAl;
	 
	 int linCom;
	 int numArtic;
	 public LectorXML(){

      try {
         File inputFile = new File("comanda.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         System.out.println("Element principal :" + doc.getDocumentElement().getNodeName());
        
         /***
          * 
          *  
          *  nList - Es una llista amb tots els elements que tinguin com a etiqueta "comanda"
          *
          *  
          *  */
         NodeList nList = doc.getElementsByTagName("comanda");
         
         System.out.println();
         System.out.println("----------------------------");
         
         
         /***
          * 
          *  Fa una iteracio per cada "comada" que troba 
          * 
          *  arrayLiniaComan2(ArrayList<lineaComanda>) - Es una Array list amb linies de comanda
          *  
          *   # L'inicialitzem a cada bucle, per tal d'assegurar-nos de que cada linea de comanda va a cada comanda. 
          *   I no tenir elements repetits(S'acumulin a l'array)
          * 
          * */
         
         
         for (int temp = 0; temp < nList.getLength(); temp++) {
         ArrayList<lineaComanda> arrayLiniaComan2 = new ArrayList<lineaComanda>();
            Node nNode = nList.item(temp);
            System.out.println("***");
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            
            
            
            /***
             * 
             * 
             * 		aList - Es una llista amb l'etiqueta fill de "comanda" 
             * 
             * 	# D'aquesta manera ho fem per cada "comanda".
             * 
             * 	# Si ho fem per "article", ens agafara totes les etiquetes sense diferenciar quina comanda es i en aquest cas ens interesa aixi
             * 
             * 
             * 
             * */
            
            
            NodeList aList = nNode.getChildNodes();
            
            
            /***
             *  
             *   id_Client(String) - Atribut de la id del client
             *   id_comanda(int) - Atribut de la id de la comanda
             *   statusAl(char) - Atribut de l'estatus de la comanda - (A) Comança la comanda / (B) Comanda iniciada
             * 
             * */
            
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE ) {
                Element eElement = (Element) nNode;
                
                System.out.println("Id del client : " 
                        + eElement.getAttribute("id_client"));
                id_Client=eElement.getAttribute("id_client");
                System.out.println("Id de la comanda:"
                        + eElement.getAttribute("id_comanda"));
                id_comanda=Integer.parseInt(eElement.getAttribute("id_comanda"));
                System.out.println("Status:" 
                        + eElement.getAttribute("status"));
                statusAl=eElement.getAttribute("status").charAt(0);
                
            	}
            
            
            /***
             * 
             *	 Iteració per l'element article de cada comanda
             * 
             * 	 # Aquestes variables son les que s'utilitzaran per omplir arrayLiniaComand2
             * 
             * 	 id_Artic - Valor que conté l'etiqueta id
             * 	 quantitat - Valor que conté l'etiqueta unitats
             * 	 unitatServ - Valor que conté l'etiqueta unitatsServides
             * 	 preu - Valor que conté l'etiqueta preu
             * 	 status - Valor que conté l'etiqueta status
             * 
             * 
             * */
            for (int temp2 = 0; temp2 < aList.getLength(); temp2++) {
               Node aNode = aList.item(temp2);
                      
                  if (aNode.getNodeType() == Node.ELEMENT_NODE ) {
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
                     
                        
                      arrayLiniaComan2.add(new lineaComanda(temp2+1,id_Artic,id_comanda,quantitat,preu,status,unitatServ));
                      }

                  
                  }

                        
            /***
             * 
             * if l'estat de la comanda és (A) - Crea la comanda
             * 
             * 
             * */      
            if(statusAl=='A') {  
          		arrayComand.add(new comanda(id_Client,id_comanda,arrayLiniaComan2));
            }
                 
            }
            
            
  
            
         
      } catch (Exception e) {
         e.printStackTrace();
      }
	 }
	 
	
	
	 /***
	  * 
	  *  
	  * 
	  * 
	  * */
	 
	 public ArrayList<comanda> getArrayComand() {
		return arrayComand;
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
 
