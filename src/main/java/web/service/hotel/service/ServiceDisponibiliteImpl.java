package web.service.hotel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;

import web.service.hotel.db.DatabaseConnection;
import web.service.hotel.model.Adresse;
import web.service.hotel.model.Hotel;
import web.service.hotel.model.Offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebService(endpointInterface="web.service.hotel.service.ServiceDisponibilite")
public class ServiceDisponibiliteImpl implements ServiceDisponibilite {

	private List<Hotel> hotels;
	
	DatabaseConnection dbConnection = new DatabaseConnection();
    
    // Get the database connection
    Connection connection = dbConnection.getConnection();

	
    
	public ServiceDisponibiliteImpl() {
		hotels = new ArrayList<>();
		hotels.addAll(Arrays.asList(
				new Hotel("Hotel1", new Adresse("123 Rue A", "Ville1", "Pays1", null, null, null), 2),
				new Hotel("Hotel2", new Adresse("123 Rue A", "Ville1", "Pays1", null, null, null), 2),
				new Hotel("Hotel3", new Adresse("123 Rue A", "Ville1", "Pays1", null, null, null), 2)
				));
	}
	@Override
	public List<Offre> consulterDisponibilites(String identifiantAgence, String motDePasse, String dateDebut,
			String dateFin, int nombrePersonnes) {
		String id = null;
		double tarif = 1; 
		List<Offre> offres = new ArrayList<>();
		try {
            // Create a statement and execute SQL queries
            
            String query = "SELECT id , tarif FROM AgencePartenaire where nom = ? AND motDePasse = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, identifiantAgence);
            statement.setString(2, motDePasse);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Retrieve data from the result set
                id = resultSet.getString("id");
                tarif = resultSet.getDouble("tarif");
                System.out.println(tarif);
            }
            statement.close();
            String query2 = "SELECT  distinct(c.id) , c.* , h.nom , h.nombreEtoiles\r\n"
            		+ "FROM Chambre c\r\n"
            		+ "JOIN Hotel h ON c.hotel_id = h.id\r\n"
            		+ "JOIN AgenceHotel hap ON c.hotel_id  = hap.hotel_id \r\n"
            		+ "join Reservation r ON r.chambre_id = c.id\r\n"
            		+ "WHERE hap.agencePartenaire_id = ? \r\n"
            		+ "AND c.nombreLits = ? \r\n"
            		+ "AND c.id NOT IN (\r\n"
            		+ "    SELECT r.chambre_id\r\n"
            		+ "    FROM Reservation r\r\n"
            		+ "    WHERE (? BETWEEN r.dateArrivee AND r.dateDepart)\r\n"
            		+ "       OR (? BETWEEN r.dateArrivee AND r.dateDepart)\r\n"
            		+ ");";
            
            
            PreparedStatement statement2 = connection.prepareStatement(query2);
            statement2.setString(1, id);
            statement2.setLong(2,  nombrePersonnes);
            statement2.setString(3, dateDebut);
            statement2.setString(4, dateFin);
            ResultSet resultatFinal = statement2.executeQuery();
            
            while (resultatFinal.next()) {
            	Offre offre = new Offre(resultatFinal.getInt("id"),resultatFinal.getString("typeChambre"),resultatFinal.getInt("nombreLits"),resultatFinal.getDouble("prix")*tarif,resultatFinal.getString("imageUrl"),resultatFinal.getString("nom"),resultatFinal.getInt("nombreEtoiles"));
            	offres.add(offre);
            	
            }
            
            // Process the results here

            // Close the statement and connection
            statement2.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions here
        } finally {
            // Close the database connection when done
            dbConnection.closeConnection();
        }
		return offres;
	}	

}
