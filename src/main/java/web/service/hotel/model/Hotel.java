package web.service.hotel.model;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String nom;
    private Adresse adresse;
    private int nombreEtoiles;
    private Map<AgencePartenaire, Double> tarifsAgences;

    public Hotel(String nom, Adresse adresse, int nombreEtoiles) {
        this.nom = nom;
        this.adresse = adresse;
        this.nombreEtoiles = nombreEtoiles;
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


	public int getNombreEtoiles() {
		return nombreEtoiles;
	}

	public void setNombreEtoiles(int nombreEtoiles) {
		this.nombreEtoiles = nombreEtoiles;
	}


	public Map<AgencePartenaire, Double> getTarifsAgences() {
		return tarifsAgences;
	}



	public void setTarifsAgences(Map<AgencePartenaire, Double> tarifsAgences) {
		this.tarifsAgences = tarifsAgences;
	}

    public void ajouterTarifAgence(AgencePartenaire agence) {
        tarifsAgences.put(agence, agence.getTarif());
    }
}
