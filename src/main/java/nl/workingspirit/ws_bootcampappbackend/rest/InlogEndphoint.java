package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.GebruikerRepository;
import nl.workingspirit.ws_bootcampappbackend.controller.InlogService;
import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.dto.InlogDTO;

@Configuration
@EnableWebSecurity
@RestController
public class InlogEndphoint extends WebSecurityConfigurerAdapter {
	@Autowired
	InlogService inlogService;

	@Autowired
	GebruikerRepository gebruikerRepository;
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("**").permitAll().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}

	
	@PostMapping("inlogGebruiker")
	public ResponseEntity<InlogDTO> postInlogGebruiker(@RequestBody Gebruiker gebruiker) {
		Optional<InlogDTO> inlogGebruiker = inlogService.inlogGebruiker(gebruiker);
		return inlogGebruiker.map(inlogDTO -> ResponseEntity.ok(inlogDTO))
				.orElse(ResponseEntity.notFound().build());
	
	}
//	if (inlogGebruiker.isPresent()) {
//	return new ResponseEntity<InlogDTO>(inlogGebruiker.get(),HttpStatus.FOUND);			
//	} else {
//	return new ResponseEntity<InlogDTO>(HttpStatus.NOT_FOUND);
//}
}