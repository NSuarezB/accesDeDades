package MODEL;


public class Client{
	
	private String idClient;
	private String name;
	private String personaContacte;
	private String localitzacio;
	private int codiPostal;
	private int morositat;
	
	
	/* constructor */
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public Client(String idClient,String name,String personaContacte,String localitzacio,int codiPostal,int morositat) {
		
		this.idClient=idClient;
		this.name=name;
		this.personaContacte=personaContacte;
		this.localitzacio=localitzacio;
		this.codiPostal=codiPostal;
		this.morositat=morositat;
		
	}
	
	/* Getters */
	
	
	public String getIdClient() {
		return idClient;
	}
	
	public String getName() {
		return name;
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
	
	public int getMorositat() {
		return morositat;
	}
	
	/* Setters */
	
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

	public void setPersonaContacte(String personaContacte) {
		this.personaContacte = personaContacte;
	}
	
	public void setCodiPostal(int codiPostal) {
		this.codiPostal = codiPostal;
	}
	
	
	
	
	/* Methods */
	
	public void setMorositat(int morositat) {
		this.morositat = morositat;
	}
	
	public void setLocalitzacio(String localitzacio) {
		this.localitzacio = localitzacio;
	}

	@Override
	public String toString() {
		return "client [idClient=" + idClient + ", name=" + name + ", personaContacte=" + personaContacte
				+ ", localitzacio=" + localitzacio + ", codiPostal=" + codiPostal + ", morositat=" + morositat + "]\n";
	}
	
	
	
}