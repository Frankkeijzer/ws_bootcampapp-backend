package nl.workingspirit.ws_bootcampappbackend.controller;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;


@Service
@Transactional
public class AuthenticatieService {

	public boolean authenticatieGebruiker(Gebruiker gebruiker, String wachtwoord) {
		return gebruiker != null && gebruiker.getWachtwoord().equals(wachtwoord);
	
	}
}


