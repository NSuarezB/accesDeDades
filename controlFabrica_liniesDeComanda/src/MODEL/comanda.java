package MODEL;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class comanda{
	
	private int idClient;
	private int idComanda;
	float preu;
	SimpleDateFormat elFormat = new SimpleDateFormat("yyyyMMdd");
	private String dataObertura ;
	private String dataFinalitzacio;
	private int status;
	ArrayList<lineaComanda> arrayLiniaComan = new ArrayList<lineaComanda>();
	
	
	/* Constructor */
	
	public comanda() {
		
		this.status='0';
		
	}
	
	public comanda(int idClient) {
		
		this.idClient=idClient;
		this.status='0';
	}
	
	public comanda(int idClient,int idComanda,float preu,int status) {
		
		this.idClient=idClient;
		this.idComanda=idComanda;
		
		this.dataObertura= elFormat.format(new Date());
		this.dataFinalitzacio=dataFinalitzacio;
		this.status=status;
		this.preu=preu;

		
	}
	
	public comanda(ArrayList<lineaComanda> arrayLiniaComan) {
		this.arrayLiniaComan = arrayLiniaComan;
		this.idClient=idClient;
		this.idComanda=idComanda;
		this.preu=preu;
		this.dataObertura= elFormat.format(new Date());
		this.dataFinalitzacio=dataFinalitzacio;
		this.status=status;
		
		
	}
	
	public comanda(int idClient,int idComanda,float preu,String dataObertura,String dataFinalitzacio,int status) {
		
		
		this.idClient=idClient;
		this.idComanda=idComanda;
		this.preu=preu;
		this.dataObertura= elFormat.format(new Date());
		this.dataFinalitzacio=dataFinalitzacio;
		this.status=status;
		
		
	}
	
	public comanda(int idClient,int idComanda,ArrayList<lineaComanda> arrayLiniaComan) {
		
		this.idClient=idClient;
		this.idComanda=idComanda;
		this.dataObertura= elFormat.format(new Date());
		this.status='0';
		this.arrayLiniaComan=arrayLiniaComan;
		
	}
	
	/* Getters */
	
	public int getIdClient() {
		return idClient;
	}
	
	public int getIdComanda() {
		return idComanda;
	}
	
	public float getPreu() {
		return preu;
	}
	
	public String getDataOpertura() {
		return dataObertura;
	}
	
	public String getDataFinalitzacio() {
		return dataFinalitzacio;
	}
	
	public int getStatus() {
		return status;
	}
	
	
	
	/* Setters */
	
	public ArrayList<lineaComanda> getArrayLiniaComan() {
		return arrayLiniaComan;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	public void setDataOpertura(String dataObertura) {
		this.dataObertura = dataObertura;
	}
	
	public void setDataFinalitzacio(String dataFinalitzacio) {
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
		return "\ncomanda [idClient=" + idClient + ", idComanda=" + idComanda + ", preu=" + this.preuTotal(arrayLiniaComan) + "€, dataObertura="
				+ dataObertura + ", dataFinalitzacio=" + dataFinalitzacio + ", status=" + status + ", arrayLiniaComan="
				+ getArrayLiniaComan() + "]\n";
	}

	
	

	
	
}