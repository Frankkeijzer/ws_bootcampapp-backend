package nl.workingspirit.ws_bootcampappbackend.controller;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Gebruiker;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticatieServiceTest {

	private Gebruiker testGebruiker = new Gebruiker();
	
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Mock
	private AuthenticatieService authenticatieSrvice;
	
	@InjectMocks
	AuthenticatieService sut;
	
	@Before
	public void setUp () {
		testGebruiker.setEmailadres("test@test.nl");
		testGebruiker.setWachtwoord("test");
	}
	
	@Test
	public void GebruikerIsGelijkAanNull () throws Exception {
		
		//when(sut.authenticatieGebruiker(any(Gebruiker.class), anyString())).thenReturn(false);
	//	Assert.assertFalse(any(Gebruiker.class).equals(null));
	//	Mockito.verify(testGebruiker).equals(isNull());
		
		
		
	}
	
	@Test
	public void GebruikerIsGelijkAanNullWachtwoordNok () {
		
	}
	
	@Test
	public void GebruikerIsGelijkAanNullWachtoordOk () {
		
	}

	
}
