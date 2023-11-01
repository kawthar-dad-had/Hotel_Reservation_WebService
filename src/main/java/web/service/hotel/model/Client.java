package web.service.hotel.model;

public class Client {
    private String nom;
    private String prenom;
    private String carteDeCredit;

    public Client(String nom, String prenom, String carteDeCredit) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setCarteDeCredit(carteDeCredit);
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

	public String getCarteDeCredit() {
		return carteDeCredit;
	}

	public void setCarteDeCredit(String carteDeCredit) {
		this.carteDeCredit = carteDeCredit;
	}

}
