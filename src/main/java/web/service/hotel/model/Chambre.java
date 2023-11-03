package web.service.hotel.model;


public class Chambre {
    private String typeChambre;
    private int nombreLits;
    private double prix;
    private Hotel hotel;
    private String imageUrl;
    
    public Chambre(String typeChambre , int nombreLits , double prix , Hotel hotel ) {
        this.setTypeChambre(typeChambre);
        this.setNombreLits(nombreLits);
        this.setPrix(prix);
        this.setHotel(hotel);
    }


	public String getTypeChambre() {
		return typeChambre;
	}

	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}

	public int getNombreLits() {
		return nombreLits;
	}

	public void setNombreLits(int nombreLits) {
		this.nombreLits = nombreLits;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


}
