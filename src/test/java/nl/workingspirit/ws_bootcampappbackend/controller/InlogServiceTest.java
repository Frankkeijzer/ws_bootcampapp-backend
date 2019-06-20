package nl.workingspirit.ws_bootcampappbackend.controller;


import java.util.Optional;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.domein.Rol;
import nl.workingspirit.ws_bootcampappbackend.dto.InlogDTO;

@RunWith(MockitoJUnitRunner.class)
public class InlogServiceTest {
	
	private Gebruiker testGebruiker = new Gebruiker();
	
	@Mock
	private AuthenticatieService authenticatieService;

	@Mock
	private GebruikerRepository gebruikerRepository;
	
	@InjectMocks
	private InlogService sut;

	@Before
	public void setUp () {
		testGebruiker.setEmailadres("test@test.nl");
		testGebruiker.setWachtwoord("test");
		testGebruiker.setAchternaam("Tester");
		testGebruiker.setVoornaam("Test");
		testGebruiker.setRol(Rol.STUDENT);
	}
	
		
	
	@Test
	public void inlogGebruikerGebruikerNietGevonden () {
			
		when(gebruikerRepository.findByEmailadres(anyString())).thenReturn(Optional.empty());
		Optional<InlogDTO> teruggegevenGebruiker = sut.inlogGebruiker(testGebruiker);
		Assert.assertFalse(teruggegevenGebruiker.isPresent()); 
		Mockito.verify(authenticatieService, Mockito.never()).authenticatieGebruiker(any(Gebruiker.class), anyString());
		
		
	}
	
	@Test
	public void inlogGebruikerGebruikerWelGevondenAuthenticatieNok() {
		
		when(gebruikerRepository.findByEmailadres(anyString())).thenReturn(Optional.of(testGebruiker));
		when(authenticatieService.authenticatieGebruiker(any(Gebruiker.class), anyString())).thenReturn(false);
		Optional<InlogDTO> teruggegevenGebruiker = sut.inlogGebruiker(testGebruiker);
		Assert.assertFalse(teruggegevenGebruiker.isPresent());
		Mockito.verify(authenticatieService, Mockito.times(1)).authenticatieGebruiker(any(Gebruiker.class), anyString());
		
		
	}
	
	@Test
	public void inlogGebruikerGebruikerWelGevondenAuthenticatieOk() {
				
		when(gebruikerRepository.findByEmailadres(Mockito.eq("test@test.nl"))).thenReturn(Optional.of(testGebruiker));
		when(authenticatieService.authenticatieGebruiker(Mockito.eq(testGebruiker), Mockito.eq("test"))).thenReturn(true);
		Optional<InlogDTO> teruggegevenGebruiker = sut.inlogGebruiker(testGebruiker);
		Assert.assertTrue(teruggegevenGebruiker.isPresent());
		Mockito.verify(authenticatieService, Mockito.times(1)).authenticatieGebruiker(any(Gebruiker.class), anyString());
		
	}
	



}
