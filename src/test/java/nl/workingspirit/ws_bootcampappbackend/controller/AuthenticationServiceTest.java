package nl.workingspirit.ws_bootcampappbackend.controller;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.User;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationServiceTest {

	private User testUser = new User();
	
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
	
	@Mock
	private AuthenticationService authenticationService;
	
	@InjectMocks
	AuthenticationService sut;
	
	@Before
	public void setUp () {
		testUser.setEmailaddress("test@test.nl");
		testUser.setPassword("test");
	}
	
	@Test
	public void userEqualsNull () throws Exception {
		
		//when(sut.authenticatieGebruiker(any(Gebruiker.class), anyString())).thenReturn(false);
	//	Assert.assertFalse(any(Gebruiker.class).equals(null));
	//	Mockito.verify(testUser).equals(isNull());
		
		
		
	}
	
	@Test
	public void GebruikerIsGelijkAanNullWachtwoordNok () {
		
	}
	
	@Test
	public void GebruikerIsGelijkAanNullWachtoordOk () {
		
	}

	
}
