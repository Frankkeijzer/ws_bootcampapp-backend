package nl.workingspirit.ws_bootcampappbackend.domein;

import org.junit.Test;
import org.junit.Assert;

public class GebruikerTest {
	
	@Test
	public void testGebruiker() {
	Gebruiker sut = maakNieuweGebruiker();
	Assert.assertEquals("testtest", sut.getWachtwoord());
	}
	
	public Gebruiker maakNieuweGebruiker() {
	Gebruiker gebruiker = new Gebruiker();
	gebruiker.setAchternaam("testGebruiker");
	gebruiker.setVoornaam("Testelien");
	gebruiker.setId(100);
	gebruiker.setEmailadres("Testelien@testGebruiker.nl");
	gebruiker.setWachtwoord("testtest");
	gebruiker.setRol(Rol.STUDENT);
	return gebruiker;
}

}