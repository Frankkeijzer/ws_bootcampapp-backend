package nl.workingspirit.ws_bootcampappbackend.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.domein.Rol;


public interface GebruikerRepository extends CrudRepository<Gebruiker,Long>{
	Optional<Gebruiker> findByEmailadres(String emailadres);
	Optional<Gebruiker> findByWachtwoord(String wachtwoord);
	List<Gebruiker> findByVoornaamStartingWith(String letter);
	
	Iterable<Gebruiker> findByRolOrderByAchternaamAsc(Rol rol);

}
