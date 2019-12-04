package MODEL;


public class client{
	
	private int idClient;
	private String name;
	private String cif;
	private String personaContacte;
	private String localitzacio;
	private int codiPostal;
	private boolean morositat;
	
	
	/* constructor */
	public client(int idClient,String name,String cif,String personaContacte,String localitzacio,String codiPostal) {
		
		this.idClient=idClient;
		
	}
	
	/* Getters */
	
	
	public int getIdClient() {
		return idClient;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCif() {
		return cif;
	}
	
	public String getPersonaContacte() {
		return personaContacte;
	}
	
	public String getLocalitzacio() {
		return localitzacio;
	}
	
	public int getCodiPostal() {
		return codiPostal;
	}
	
	
	/* Setters */
	
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public void setPersonaContacte(String personaContacte) {
		this.personaContacte = personaContacte;
	}
	
	public void setCodiPostal(int codiPostal) {
		this.codiPostal = codiPostal;
	}
	
	
	
	
	/* Methods */
	
	public void setMorositat(boolean morositat) {
		this.morositat = morositat;
	}
	
	public void setLocalitzacio(String localitzacio) {
		this.localitzacio = localitzacio;
	}
	
}