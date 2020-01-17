package MODEL;

import java.util.ArrayList;

public class lineaComanda{
	
	private int idArticle;
	private int idComanda;
	private int idLineaComanda;
	private int unitatsDemandes;
	private int unitatsServides;
	private float preuUn;
	public float preulinia;
	private int status;
	ArrayList<lineaComanda> lineaComArray = new ArrayList();
	
	
	/* Constructor */
	public lineaComanda(int idLineaComanda,int idComanda,int idArticle,int unitatsDemandes,int status) {
		
		this.idLineaComanda=idLineaComanda;
		this.idArticle=idArticle;
		this.idComanda=idComanda;
		this.unitatsDemandes=unitatsDemandes;
		this.preulinia=unitatsDemandes*preuUn;
		this.preuUn=preuUn;
		this.unitatsServides=unitatsServides;
		this.status=status;

	}

	public lineaComanda(int idLineaComanda,int idComanda,int idArticle,float preuUn,int unitatsDemandes,int status) {
		
		this.idLineaComanda=idLineaComanda;
		this.idArticle=idArticle;
		this.idComanda=idComanda;
		this.unitatsDemandes=unitatsDemandes;
		this.preulinia=unitatsDemandes*preuUn;
		this.preuUn=preuUn;
		this.unitatsServides=unitatsServides;
		this.status=status;

	}
	
	public lineaComanda(ArrayList<lineaComanda> lineaComArray ) {
		this.lineaComArray=lineaComArray;
		
	}
	
	/* Getters */
	public ArrayList<lineaComanda> getLineaComArray() {
		return lineaComArray;
	}
	
	public int getIdArticle() {
		return idArticle;
	}
	
	public int getIdComanda() {
		return idComanda;
	}
	
	public int getIdLineaComanda() {
		return idLineaComanda;
	}
	
	public int getUnitatsDemandes() {
		return unitatsDemandes;
	}
	
	public int getStatus() {
		return status;
	}
	
	public int getUnitatsServides() {
		return unitatsServides;
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
	
	public void setUnitatsDemandes(int unitatsDemandes) {
		this.unitatsDemandes = unitatsDemandes;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	public void setUnitatsServides(int unitatsServides) {
		this.unitatsServides = unitatsServides;
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
				+ idComanda + ", quantitat=" + unitatsDemandes + ", preuUn=" + preuUn + "€, preuLinia="+ getPreulinia() +"€, status=" + status +", Unitats servides="+unitatsServides +"]";
		
	
	}

	
	
	
}