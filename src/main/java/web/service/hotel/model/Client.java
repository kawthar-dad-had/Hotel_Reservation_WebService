package web.service.hotel.model;

public class Client {
    private String nom;
    private String prenom;
    private String numeroCarte;
    private int cvv;
    private String dateExpiration;

    public Client(String nom, String prenom, String numeroCarte , int cvv , String dateExpiration) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setNumeroCarte(numeroCarte);
        this.setCvv(cvv);
        this.setDateExpiration(dateExpiration);
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

}
