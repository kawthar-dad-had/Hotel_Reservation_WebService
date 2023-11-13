package web.service.hotel.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebService;

import web.service.hotel.db.DatabaseConnection;

@WebService(endpointInterface="web.service.hotel.service.ServiceReservation")
public class ServiceReservationImpl implements ServiceReservation {

	
	DatabaseConnection dbConnection = new DatabaseConnection();
	Connection connection = dbConnection.getConnection();
	
	
	@Override
	public String reservation(String identifiantAgence, String motDePasse, int idOffre, String nom, String prenom,
			String numeroCarte, int cvv, String dateExpiration, String dateDebut, String dateFin, int nombrePersonnes , double prix) {

		int id = 0;
		String message = "Reservation n'est pas effectué" ;
		
		try {
            // Create a statement and execute SQL queries
            
            String query = "SELECT id  FROM AgencePartenaire where nom = ? AND motDePasse = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, identifiantAgence);
            statement.setString(2, motDePasse);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Retrieve data from the result set
                id = resultSet.getInt("id");
            }
            statement.close();
            
            
            String query2 = "INSERT INTO Reservation\r\n"
            		+ "(dateArrivee , dateDepart,nombrePersonnes,chambre_id,agencePartenaire_id,client_nom,client_prenom,client_numeroCarte,client_cvv,client_dateExpiration,prix)\r\n"
            		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
            
            
            PreparedStatement statement2 = connection.prepareStatement(query2);
            statement2.setString(1, dateDebut);
            statement2.setString(2,  dateFin);
            statement2.setInt(3, nombrePersonnes);
            statement2.setInt(4, idOffre);
            statement2.setInt(5, id);
            statement2.setString(6,  nom);
            statement2.setString(7, prenom);
            statement2.setString(8, numeroCarte);
            statement2.setInt(9, cvv);
            statement2.setString(10,  dateExpiration);
            statement2.setDouble(11, prix);
            int resultatFinal = statement2.executeUpdate();
            
            if(resultatFinal > 0) {
            	message = "Votre reservation est confirmé";
            }
            // Process the results here

            // Close the statement and connection
            statement2.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions here
        }
		return message;
	}

}
