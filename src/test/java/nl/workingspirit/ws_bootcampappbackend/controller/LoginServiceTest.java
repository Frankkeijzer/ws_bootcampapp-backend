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

import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.dto.LoginDTO;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
	
	private User testUser = new User();
	
	@Mock
	private AuthenticationService authenticationService;

	@Mock
	private UserRepository UserRepository;
	
	@InjectMocks
	private LoginService sut;

	@Before
	public void setUp () {
		testUser.setEmailaddress("test@test.nl");
		testUser.setPassword("test");
		testUser.setLastName("Tester");
		testUser.setFirstName("Test");
		testUser.setRole(Role.STUDENT);
	}
	
		
	
	@Test
	public void inlogGebruikerGebruikerNietGevonden () {
			
		when(UserRepository.findByEmailaddress(anyString())).thenReturn(Optional.empty());
		Optional<LoginDTO> sendUser = sut.userLogin(testUser);
		Assert.assertFalse(sendUser.isPresent()); 
		Mockito.verify(authenticationService, Mockito.never()).userAuthentication(any(User.class), anyString());
		
		
	}
	
	@Test
	public void loginUserIsFoundAuthenticationNok() {
		
		when(UserRepository.findByEmailaddress(anyString())).thenReturn(Optional.of(testUser));
		when(authenticationService.userAuthentication(any(User.class), anyString())).thenReturn(false);
		Optional<LoginDTO> sendUser = sut.userLogin(testUser);
		Assert.assertFalse(sendUser.isPresent());
		Mockito.verify(authenticationService, Mockito.times(1)).userAuthentication(any(User.class), anyString());
		
		
	}
	
	@Test
	public void loginUserIsFoundAuthenticationOk() {
				
		when(UserRepository.findByEmailaddress(Mockito.eq("test@test.nl"))).thenReturn(Optional.of(testUser));
		when(authenticationService.userAuthentication(Mockito.eq(testUser), Mockito.eq("test"))).thenReturn(true);
		Optional<LoginDTO> sendUser = sut.userLogin(testUser);
		Assert.assertTrue(sendUser.isPresent());
		Mockito.verify(authenticationService, Mockito.times(1)).userAuthentication(any(User.class), anyString());
		
	}
	



}
