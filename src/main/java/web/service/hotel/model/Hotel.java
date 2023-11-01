package web.service.hotel.model;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String nom;
    private Adresse adresse;
    private double prix;
    private int nombreEtoiles;
    private int nombreLits;
    private Map<AgencePartenaire, Double> tarifsAgences;

    public Hotel(String nom, Adresse adresse, double prix, int nombreEtoiles, int nombreLits) {
        this.nom = nom;
        this.adresse = adresse;
        this.prix = prix;
        this.nombreEtoiles = nombreEtoiles;
        this.nombreLits = nombreLits;
        setTarifsAgences(new HashMap<>());
    }



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getNombreEtoiles() {
		return nombreEtoiles;
	}

	public void setNombreEtoiles(int nombreEtoiles) {
		this.nombreEtoiles = nombreEtoiles;
	}

	public int getNombreLits() {
		return nombreLits;
	}

	public void setNombreLits(int nombreLits) {
		this.nombreLits = nombreLits;
	}



	public Map<AgencePartenaire, Double> getTarifsAgences() {
		return tarifsAgences;
	}



	public void setTarifsAgences(Map<AgencePartenaire, Double> tarifsAgences) {
		this.tarifsAgences = tarifsAgences;
	}

    public void ajouterTarifAgence(AgencePartenaire agence) {
        tarifsAgences.put(agence, this.prix*agence.getTarif());
    }
}
