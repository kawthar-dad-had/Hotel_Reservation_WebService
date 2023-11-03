package web.service.hotel.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import web.service.hotel.model.Hotel;

@WebService
public interface ServiceDisponibilite {
	@WebMethod
    List<Hotel> consulterDisponibilites(@WebParam(name = "identifiantAgence")String identifiantAgence, @WebParam(name = "motDePasse") String motDePasse,@WebParam(name = "dateDebut") String dateDebut,@WebParam(name = "dateFin") String dateFin,@WebParam(name = "nombrePersonnes") int nombrePersonnes);
}
