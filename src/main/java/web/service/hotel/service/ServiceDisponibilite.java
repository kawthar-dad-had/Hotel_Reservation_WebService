package web.service.hotel.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import web.service.hotel.model.Hotel;

@WebService
public interface ServiceDisponibilite {
	@WebMethod
    List<Hotel> consulterDisponibilites(String identifiantAgence, String motDePasse, String dateDebut, String dateFin, int nombrePersonnes);
}
