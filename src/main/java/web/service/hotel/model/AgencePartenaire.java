package web.service.hotel.model;

public class AgencePartenaire {

    private String nom;
    private double tarif;

    public AgencePartenaire(String nom, double tarif) {
        this.setNom(nom);
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
}
