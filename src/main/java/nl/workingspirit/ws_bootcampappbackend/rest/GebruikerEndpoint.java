package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.OpslaanService;
import nl.workingspirit.ws_bootcampappbackend.controller.OpvraagService;
import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.domein.Rol;

@RestController
public class GebruikerEndpoint {
	
	@Autowired
	OpvraagService opvraagService;
	@Autowired 
	OpslaanService opslaanService;
	
	@PostMapping("voegGebruikerToe")
	public ResponseEntity<Gebruiker >postGebruiker(@RequestBody Gebruiker gebruiker) {
		if(!opvraagService.geefGebruikerViaEmail(gebruiker.getEmailadres()).isPresent()) { 
			opslaanService.postGebruiker(gebruiker);
			System.out.println("de gebruiker wordt toegevoegd"); 
			return new ResponseEntity<Gebruiker>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Gebruiker>(HttpStatus.BAD_REQUEST);
	}
	}
	
	@GetMapping("alleGegevensGebruiker/{id}")
	public ResponseEntity<Gebruiker> GegevensOpvragen(@PathVariable Long id) {
		System.out.println("ID: "+id+ ".");
		Optional<Gebruiker> optionalGebruiker = opvraagService.geefGebruiker(id);
		
		return optionalGebruiker.map(gebruiker -> ResponseEntity.ok(gebruiker))
								.orElse(ResponseEntity.notFound().build());
				
//		if (optionalGebruiker.isPresent()) {
//			return new ResponseEntity<Gebruiker>(optionalGebruiker.get(),HttpStatus.FOUND);			
//		} else {
//			return new ResponseEntity<Gebruiker>(HttpStatus.NOT_FOUND);			
//		}
	}
	
	@GetMapping("AlleGebruikers/{rol}")
	public Iterable<Gebruiker> GeefAlleGebruikersPerRol(@PathVariable Rol rol){
		return opvraagService.geefPerRolAlleGebruikers(rol);
	}
	
	@GetMapping("alleGebruikers")
	public Iterable<Gebruiker> geefAlleGebruikers() {
		return opvraagService.geefAlleGebruikers();
	}
	
	@PutMapping("WijzigGebruiker")
	public ResponseEntity<Gebruiker> WijzigGebruiker(@RequestBody Gebruiker gebruiker) {
		Optional<Gebruiker> tempGebruiker = opvraagService.geefGebruiker(gebruiker.getId());
		if(tempGebruiker.isPresent()) {
			opslaanService.wijzigGebruiker(gebruiker);
			return new ResponseEntity<Gebruiker>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Gebruiker>(HttpStatus.BAD_REQUEST);
		}
	}
}

