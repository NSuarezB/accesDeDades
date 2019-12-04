package MODEL;

import java.util.Date;
import java.util.ArrayList;

public class comanda{
	
	private String idClient;
	private int idComanda;
	float preu;
	private Date dataOpertura = new Date();
	private Date dataFinalitzacio;
	private char status;
	ArrayList<lineaComanda> arrayLiniaComan = new ArrayList<lineaComanda>();
	
	
	/* Constructor */
	
	public comanda() {
		
		this.status='0';
		
	}
	
	public comanda(String idClient) {
		
		this.idClient=idClient;
		this.status='0';
	}
	
	public comanda(String idClient,int idComanda,ArrayList<lineaComanda> arrayLiniaComan) {
		
		this.idClient=idClient;
		this.idComanda=idComanda;
		this.status='0';
		this.arrayLiniaComan=arrayLiniaComan;
		
	}
	
	/* Getters */
	
	public String getIdClient() {
		return idClient;
	}
	
	public int getIdComanda() {
		return idComanda;
	}
	
	public float getPreu() {
		return preu;
	}
	
	public Date getDataOpertura() {
		return dataOpertura;
	}
	
	public Date getDataFinalitzacio() {
		return dataFinalitzacio;
	}
	
	public char getStatus() {
		return status;
	}
	
	
	
	/* Setters */
	
	public ArrayList<lineaComanda> getArrayLiniaComan() {
		return arrayLiniaComan;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	public void setDataOpertura(Date dataOpertura) {
		this.dataOpertura = dataOpertura;
	}
	
	public void setDataFinalitzacio(Date dataFinalitzacio) {
		this.dataFinalitzacio = dataFinalitzacio;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	
	
	/* Methods*/
	
	public static void crearLineaCom() {
		
		
		
		
	}
	
	public float preuTotal(ArrayList<lineaComanda> arrayLiniaComan) {
		
		 for(lineaComanda lineaComanda : arrayLiniaComan) {
				preu += lineaComanda.preulinia;			
			}
			 return preu;
		
		//for (int i=0;i<=1;i++) {
			
		//	arrayLiniaComan.get(i).getPreulinia();
		//	return
			
		//    }
		
		
	}
	
	public static void preuAmbTransport(float preuTransport) {
		
		
		
		
		
	}

	@Override
	public String toString() {
		return "\ncomanda [idClient=" + idClient + ", idComanda=" + idComanda + ", preu=" + this.preuTotal(arrayLiniaComan) + "€, dataOpertura="
				+ dataOpertura + ", dataFinalitzacio=" + dataFinalitzacio + ", status=" + status + ", arrayLiniaComan="
				+ getArrayLiniaComan() + "]\n";
	}

	
	

	
	
}