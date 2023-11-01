package web.service.hotel.server;

import web.service.hotel.model.Adresse;
import web.service.hotel.model.AgencePartenaire;
import web.service.hotel.model.Chambre;
import web.service.hotel.model.Client;
import web.service.hotel.model.Hotel;
import web.service.hotel.model.Reservation;

public class Main {

	public static void main(String[] args) {
        Client client1 = new Client("John", "Doe", "1234-5678-9012-3456");
        Adresse adresse1 = new Adresse("France", "Paris", "Rue de Rivoli", "123", "", "48.8566° N, 2.3522° E");
        Hotel hotel1 = new Hotel("Hôtel Parisien", adresse1, 150.0, 4, 2);
        Chambre chambre1 = new Chambre("Chambre double");
        AgencePartenaire agence1 = new AgencePartenaire("Agence A",0.95);
        AgencePartenaire agence2 = new AgencePartenaire("Agence B",0.5);

        // Associez des tarifs d'agences aux hôtels
        hotel1.ajouterTarifAgence(agence1);
        hotel1.ajouterTarifAgence(agence2);

        // Effectuez des réservations en utilisant une agence partenaire
        Reservation reservation1 = new Reservation("2023-11-10", "2023-11-15", 2, client1, hotel1, chambre1, agence1);
        System.out.println("Réservation effectuée via l'agence : " + reservation1.getAgencePartenaire().getNom());
        System.out.println("Client : " + reservation1.getClient().getPrenom() + " " + reservation1.getClient().getNom());
        System.out.println("Hôtel : " + reservation1.getHotel().getNom());
        for (AgencePartenaire agence : hotel1.getTarifsAgences().keySet()) {
            double tarif = hotel1.getTarifsAgences().get(agence);
            System.out.println("Agence " + agence.getNom() + ": " + tarif);
        }	}

}