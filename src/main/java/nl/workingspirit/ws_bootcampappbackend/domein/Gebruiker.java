package nl.workingspirit.ws_bootcampappbackend.domein;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Sort;


@Entity
public class Gebruiker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String voornaam;
	@Column(nullable=false)
	@Sort
	private String achternaam;
	@Column(nullable=false, unique=true) 
	private String emailadres;
	@Column(nullable=false)
	private String wachtwoord;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Rol rol;
	
	@OneToMany
	private List<Uitwerking> uitwerkingen;
	
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getEmailadres() {
		return emailadres;
	}
	public void setEmailadres(String emailadres) {
		this.emailadres = emailadres;
	}
	public String getWachtwoord() {
		return wachtwoord;
	}
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public List<Uitwerking> getUitwerkingen() {
		return Collections.unmodifiableList(uitwerkingen);
	}
	public void addUitwerking(Uitwerking uitwerking) {
		this.uitwerkingen.add(uitwerking);
	}
	

	
}
