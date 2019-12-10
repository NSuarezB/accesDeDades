package MODEL;


public class proveidor{
	
	private int idProveidor;
	private int idComponent;
	private int quantitat;
	
	/* Constructor */
	
	public proveidor(int idProveidor,int idComponent,int quantitat) {
		
		
		this.idProveidor=idProveidor;
		this.idComponent=idComponent;
		this.quantitat=quantitat;
		
		
	}
	
	
	/* Getters */
	
	public int getIdProveidor() {
		return idProveidor;
	}
	
	public int getIdComponent() {
		return idComponent;
	}
	
	public int getQuantitat() {
		return quantitat;
	}
	
	/* Setters */
	
	public void setIdProveidor(int idProveidor) {
		this.idProveidor = idProveidor;
	}
	
	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}
	
	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}
	
	/* Methods */
	
	public static void demanarComponent(int idComponent,int quantitat) {
		
		
		
	}
	
	
}