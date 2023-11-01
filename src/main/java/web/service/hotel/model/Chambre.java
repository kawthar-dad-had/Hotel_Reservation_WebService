package web.service.hotel.model;

public class Chambre {
    private String typeChambre;

    public Chambre(String typeChambre) {
        this.setTypeChambre(typeChambre);
    }

	public String getTypeChambre() {
		return typeChambre;
	}

	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}
}
