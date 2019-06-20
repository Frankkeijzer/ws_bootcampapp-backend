package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.domein.Lesstof;
import nl.workingspirit.ws_bootcampappbackend.domein.Rol;

@Service
@Transactional
public class OpvraagService {
	@Autowired
	GebruikerRepository gebruikerRepository;
	@Autowired
	LesstofRepository lesstofRepository;
	
	public Iterable<Gebruiker> geefAlleGebruikers() {
		return gebruikerRepository.findAll();
	}
	
	public Iterable<Gebruiker> geefPerRolAlleGebruikers(Rol rol){
		return gebruikerRepository.findByRolOrderByAchternaamAsc(rol);
	}
	
	public Optional<Gebruiker> geefGebruiker(Long id) {
		return gebruikerRepository.findById(id);
	}
	
	public Iterable<Lesstof> geefAlleLesstof(){
		return lesstofRepository.findAll();
	}
	
	public Optional<Gebruiker> geefGebruikerViaEmail(String emailadres){
		return gebruikerRepository.findByEmailadres(emailadres);
	}
	
}
