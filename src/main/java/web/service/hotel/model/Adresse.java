package web.service.hotel.model;

public class Adresse {
    private String pays;
    private String ville;
    private String rue;
    private String numero;
    private String lieuDit;
    private String positionGPS;

    public Adresse(String pays, String ville, String rue, String numero, String lieuDit, String positionGPS) {
        this.setPays(pays);
        this.setVille(ville);
        this.setRue(rue);
        this.setNumero(numero);
        this.setLieuDit(lieuDit);
        this.setPositionGPS(positionGPS);
    }

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLieuDit() {
		return lieuDit;
	}

	public void setLieuDit(String lieuDit) {
		this.lieuDit = lieuDit;
	}

	public String getPositionGPS() {
		return positionGPS;
	}

	public void setPositionGPS(String positionGPS) {
		this.positionGPS = positionGPS;
	}

}
