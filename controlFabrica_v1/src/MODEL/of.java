package MODEL;


public class of{
	
	private int idLineaComanda;
	private int idComanda;
	private char status;
	private int unitats;
	
	
	/* Constructor */
	
	public of(int idLineaComanda,int idComanda,char status,int unitats) {
		
		this.idLineaComanda=idLineaComanda;
		this.idComanda=idComanda;
		this.status=status;
		this.unitats=unitats;
		
		
	}
	
	/* Getters */
	
	public int getIdLineaComanda() {
		return idLineaComanda;
	}
	
	public int getIdComanda() {
		return idComanda;
	}
	
	public char getStatus() {
		return status;
	}
	
	public int getUnitats() {
		return unitats;
	}
	
	
	/* Setters */
	
	public void setIdLineaComanda(int idLineaComanda) {
		this.idLineaComanda = idLineaComanda;
	}
	
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	public void setUnitats(int unitats) {
		this.unitats = unitats;
	}
	
	
	
	/* Methods */
	
	public void restarStock(int menys) {
		
		
		
	}
	
	public void cambiarStatusOF(char status) {
		
		
		
		
	}
	
	
	
}