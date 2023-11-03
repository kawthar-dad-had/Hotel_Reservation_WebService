package web.service.hotel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;

import web.service.hotel.db.DatabaseConnection;
import web.service.hotel.model.Adresse;
import web.service.hotel.model.Hotel;

import java.sql.Connection;
import java.sql.Statement;
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
	public List<Hotel> consulterDisponibilites(String identifiantAgence, String motDePasse, String dateDebut,
			String dateFin, int nombrePersonnes) {
		try {
            // Create a statement and execute SQL queries
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM your_table";
            ResultSet resultSet = statement.executeQuery(query);

            // Process the results here

            // Close the statement and connection
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions here
        } finally {
            // Close the database connection when done
            dbConnection.closeConnection();
        }
		
		System.out.println(identifiantAgence);
		return hotels;
	}	

}
