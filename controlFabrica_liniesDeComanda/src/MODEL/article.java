package MODEL;


public class article{
	
	private int idArticle;
	private String descripcio;
	private float preu;
	private int unitats;
	
	
	/* Constructor */
	
	public article(int idArticle,String descripcio,float preu,int unitats) {
		
		this.idArticle=idArticle;
		this.descripcio=descripcio;
		this.preu=preu;
		this.unitats=unitats;
		
		
	}
	
	/* Getters*/
	
	
	public int getIdArticle() {
		return idArticle;
	}
	
	public String getDescripcio() {
		return descripcio;
	}
	
	public float getPreu() {
		return preu;
	}
	
	public int getUnitats() {
		return unitats;
	}
	
	/* Setters */
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	public void setUnitats(int unitats) {
		this.unitats = unitats;
	}
	
	/* Methods */
	
	public void consultarComponents() {
		
		
		
		
	}
	
	
}