package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.domein.Lesstof;
import nl.workingspirit.ws_bootcampappbackend.domein.Uitwerking;

@Service
@Transactional
public class OpslaanService {
	@Autowired
	GebruikerRepository gebruikerRepository;
	@Autowired
	LesstofRepository lesstofRepository;
	@Autowired
	UitwerkingRepository uitwerkingRepository;
	
	public void postGebruiker(Gebruiker gebruiker) {
		gebruikerRepository.save(gebruiker);
	}
	
	public void postLesstof(Lesstof lesstof) {
		lesstofRepository.save(lesstof);
	}
	public void wijzigGebruiker(Gebruiker gebruiker) {
		gebruikerRepository.save(gebruiker);
	}
	public void postUitwerking(Uitwerking uitwerking) {
		uitwerkingRepository.save(uitwerking);
		
	}
}
