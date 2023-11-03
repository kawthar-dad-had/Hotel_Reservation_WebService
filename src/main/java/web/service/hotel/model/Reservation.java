package web.service.hotel.model;

public class Reservation {
    private String dateArrivee;
    private String dateDepart;
    private int nombrePersonnes;
    private Client client;
    private Hotel hotel;
    private Chambre chambre;
    private AgencePartenaire agencePartenaire;
    private double prix;

    public Reservation(String dateArrivee, String dateDepart, int nombrePersonnes, Client client, Hotel hotel, Chambre chambre, AgencePartenaire agencePartenaire , double prix) {
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.nombrePersonnes = nombrePersonnes;
        this.client = client;
        this.hotel = hotel;
        this.chambre = chambre;
        this.setAgencePartenaire(agencePartenaire);
        this.setPrix(prix);
    }

	public String getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(String dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getNombrePersonnes() {
		return nombrePersonnes;
	}

	public void setNombrePersonnes(int nombrePersonnes) {
		this.nombrePersonnes = nombrePersonnes;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public AgencePartenaire getAgencePartenaire() {
		return agencePartenaire;
	}

	public void setAgencePartenaire(AgencePartenaire agencePartenaire) {
		this.agencePartenaire = agencePartenaire;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
