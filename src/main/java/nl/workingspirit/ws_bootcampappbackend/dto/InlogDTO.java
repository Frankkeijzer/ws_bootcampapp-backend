package nl.workingspirit.ws_bootcampappbackend.dto;

import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.beans.factory.annotation.Autowired;

import nl.workingspirit.ws_bootcampappbackend.controller.InlogService;
import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;
import nl.workingspirit.ws_bootcampappbackend.domein.Rol;

public class InlogDTO {
	

	private String voorNaam;
	private String achterNaam;

	@Enumerated(EnumType.STRING)
	private Rol rol;
	
	@Autowired
	InlogService inlogService;
	
	private InlogDTO (Gebruiker gebruiker) {
		setNaam(gebruiker.getVoornaam());
		setNaam(gebruiker.getAchternaam());
		setRol(gebruiker.getRol());
	}
	
	public static InlogDTO maakInlogDTO (Gebruiker gebruiker) {
		InlogDTO inlogDTO = new InlogDTO(gebruiker);
		return inlogDTO;
	}
	
	public String getNaam() {
		return voorNaam;
	}
	public void setNaam(String voorNaam) {
		this.voorNaam = voorNaam;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public String getAchterNaam() {
		return achterNaam;
	}

	public void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}
	
	
}
