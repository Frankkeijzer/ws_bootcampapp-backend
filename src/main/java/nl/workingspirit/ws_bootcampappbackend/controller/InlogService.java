package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.dto.InlogDTO;


@Service
@Transactional
public class InlogService{
	@Autowired
	private AuthenticatieService authenticatieService;
	
	@Autowired
	private GebruikerRepository gebruikerRepository;
	
	public Optional<InlogDTO> inlogGebruiker (Gebruiker gebruiker) {
		String emailadres = gebruiker.getEmailadres();
		String wachtwoord = gebruiker.getWachtwoord();
		
		Optional<Gebruiker> emailGebruiker = gebruikerRepository.findByEmailadres(emailadres);
		
		if (emailGebruiker.isPresent() && authenticatieService.authenticatieGebruiker(emailGebruiker.get(), wachtwoord)) {
			return Optional.of(InlogDTO.maakInlogDTO(emailGebruiker.get()));
		} else {
			return Optional.empty();			
		}
		//Optional<Gebruiker> wachtwoordGebruiker = gRepository.findByWachtwoord(wachtwoord);
		//InlogDTO ingelogdeGebruiker = new InlogDTO (emailGebruiker);
	}
	

}
