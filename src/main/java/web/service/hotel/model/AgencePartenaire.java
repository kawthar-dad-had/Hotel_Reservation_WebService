package web.service.hotel.model;

public class AgencePartenaire {

    private String nom;
    private String motDePasse;
    private double tarif;

    public AgencePartenaire(String nom,String motDePasse, double tarif) {
        this.setNom(nom);
        this.setMotDePasse(motDePasse);
        this.setTarif(tarif);
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
