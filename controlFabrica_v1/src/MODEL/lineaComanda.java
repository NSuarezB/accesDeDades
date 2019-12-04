package MODEL;


public class lineaComanda{
	
	private int idArticle;
	private int idComanda;
	private int idLineaComanda;
	private int quantitat;
	private float preuUn;
	public float preulinia;
	private char status;
	
	
	/* Constructor */

	public lineaComanda(int idLineaComanda,int idArticle,int idComanda,int quantitat,float preuUn,char status) {
		
		this.idLineaComanda=idLineaComanda;
		this.idArticle=idArticle;
		this.idComanda=idComanda;
		this.quantitat=quantitat;
		this.preulinia=quantitat*preuUn;
		this.preuUn=preuUn;
		this.status=status;

	}
	
	
	
	/* Getters */
	
	public int getIdArticle() {
		return idArticle;
	}
	
	public int getIdComanda() {
		return idComanda;
	}
	
	public int getIdLineaComanda() {
		return idLineaComanda;
	}
	
	public int getQuantitat() {
		return quantitat;
	}
	
	public char getStatus() {
		return status;
	}
	
	/* Setters */
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}
	
	public void setIdLineaComanda(int idLineaComanda) {
		this.idLineaComanda = idLineaComanda;
	}
	
	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	/* Methods */
	
	public static void comprovacioComponents(int idCompo) {
		
		
		
	}
	
	public static void comprovacioArticles(int idArticle) {
		
		
		
		
	}

	public float getPreulinia() {
		return preulinia;
	}

	@Override
	public String toString() {
		return "\nlineaComanda [idLineaComanda=" + idLineaComanda + ", idArticle=" + idArticle + ", idComanda="
				+ idComanda + ", quantitat=" + quantitat + ", preuUn=" + preuUn + "€, preuLinia="+ getPreulinia() +"€, status=" + status + "]";
		
	
	}

	
	
	
}