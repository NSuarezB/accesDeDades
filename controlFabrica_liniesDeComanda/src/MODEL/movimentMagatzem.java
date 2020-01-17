package MODEL;


public class movimentMagatzem{
	
	private int idMov;
	private int idProveidor;
	private int idComponent;
	private int idArticle;
	private char tipusMagatzem;
	private int quantitat;
	private int idMagatzem;
	private String definicioComponents;
	private int x;
	private int y;
	private int z;
	private float preu;
	
	/* Constructor */
	
	public movimentMagatzem(int idMov,int idProveidor,int idComponent,int idArticle,char tipusMoviment,int idMagatzem,int quantitat,String definicioComponents,int x,int y,int z,float preu) {
		
		this.idMov=idMov;
		this.idProveidor=idProveidor;
		this.idComponent=idComponent;
		this.idArticle=idArticle;
		this.tipusMagatzem=tipusMagatzem;
		this.quantitat=quantitat;
		this.idMagatzem=idMagatzem;
		this.definicioComponents=definicioComponents;
		this.x=x;
		this.y=y;
		this.z=z;
		this.preu=preu;
		
	}
	
	
	/* Getters */
	
	
	public int getIdMov() {
		return idMov;
	}
	
	public int getIdProveidor() {
		return idProveidor;
	}
	
	public int getIdComponent() {
		return idComponent;
	}
	public int getIdArticle() {
		return idArticle;
	}
	
	public char getTipusMagatzem() {
		return tipusMagatzem;
	}
	
	
	public int getIdMagatzem() {
		return idMagatzem;
	}
	
	public int getQuantitat() {
		return quantitat;
	}
	
	public String getDefinicioComponents() {
		return definicioComponents;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public float getPreu() {
		return preu;
	}
	
	/* Setters */
	
	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}
	
	public void setIdProveidor(int idProveidor) {
		this.idProveidor = idProveidor;
	}
	
	public void setIdComponent(int idComponent) {
		this.idComponent = idComponent;
	}
	
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	
	public void setTipusMagatzem(char tipusMagatzem) {
		this.tipusMagatzem = tipusMagatzem;
	}
	
	public void setIdMagatzem(int idMagatzem) {
		this.idMagatzem = idMagatzem;
	}
	
	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}
	
	public void setDefinicioComponents(String definicioComponents) {
		this.definicioComponents = definicioComponents;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setZ(int z) {
		this.z = z;
	}
	
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	/* Methods */
	
}