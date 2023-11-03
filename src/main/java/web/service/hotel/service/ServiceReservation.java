package web.service.hotel.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface ServiceReservation {
	@WebMethod
    String reservation(@WebParam(name = "identifiantAgence")String identifiantAgence, @WebParam(name = "motDePasse") String motDePasse,@WebParam(name = "idOffre") int idOffre,@WebParam(name = "nom") String nom,@WebParam(name = "prenom") String prenom,@WebParam(name = "numeroCarte") String numeroCarte ,@WebParam(name = "cvv") int cvv,@WebParam(name = "dateExpiration") String dateExpiration , @WebParam(name = "dateDebut") String dateDebut,@WebParam(name = "dateFin") String dateFin,@WebParam(name = "nombrePersonnes") int nombrePersonnes, @WebParam(name = "prix") double prix);


}
