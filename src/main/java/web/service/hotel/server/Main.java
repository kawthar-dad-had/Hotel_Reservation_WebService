package web.service.hotel.server;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import web.service.hotel.model.Adresse;
import web.service.hotel.model.AgencePartenaire;
import web.service.hotel.model.Chambre;
import web.service.hotel.model.Client;
import web.service.hotel.model.Hotel;
import web.service.hotel.model.Reservation;
import web.service.hotel.service.ServiceDisponibiliteImpl;
import web.service.hotel.service.ServiceReservationImpl;

public class Main {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/Disponibilitewebservice", new ServiceDisponibiliteImpl());
		Endpoint.publish("http://localhost:8080/reservationhotelwebservice", new ServiceReservationImpl());
		System.err.println("Server Ready");
        Client client1 = new Client("John", "Doe", "1234-5678-9012-3456", 0, null);
        Adresse adresse1 = new Adresse("France", "Paris", "Rue de Rivoli", "123", "", "48.8566° N, 2.3522° E");
        Hotel hotel1 = new Hotel("Hôtel Parisien", adresse1, 4);
        
        Map<Date, Date> disponibilite = new HashMap<>();

        // Ajoutez une période de disponibilité
        Date debut = new Date();  // Date de début
        Date fin = new Date();    // Date de fin
        disponibilite.put(debut, fin);
        
        Chambre chambre1 = new Chambre("Chambre double",2,100.0,hotel1);
        AgencePartenaire agence1 = new AgencePartenaire("Agence A","A1",0.95);
        AgencePartenaire agence2 = new AgencePartenaire("Agence B","A2",0.5);

        // Associez des tarifs d'agences aux hôtels
        hotel1.ajouterTarifAgence(agence1);
        hotel1.ajouterTarifAgence(agence2);

        // Effectuez des réservations en utilisant une agence partenaire
        Reservation reservation1 = new Reservation("2023-11-10", "2023-11-15", 2, client1, hotel1, chambre1, agence1, 0);
        System.out.println("Réservation effectuée via l'agence : " + reservation1.getAgencePartenaire().getNom());
        System.out.println("Client : " + reservation1.getClient().getPrenom() + " " + reservation1.getClient().getNom());
        System.out.println("Hôtel : " + reservation1.getHotel().getNom());
        for (AgencePartenaire agence : hotel1.getTarifsAgences().keySet()) {
            double tarif = hotel1.getTarifsAgences().get(agence);
            System.out.println("Agence " + agence.getNom() + ": " + tarif);
        }	
        }

}
