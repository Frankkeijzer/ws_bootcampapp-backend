package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.controller.UserGetService;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.UserWithoutEmailDTO;

@RunWith(MockitoJUnitRunner.class)
public class UserEndpointTest {
	
	@InjectMocks
	UserEndpoint userEndpoint;
	
	@Mock
	UserGetService userGetService;
	
	User user = new User();
	UserWithoutEmailDTO userDTO;
	
	@Before
	public void setup() {
		user.setFirstName("Piet");
		user.setLastName("Puk");
		user.setRole(Role.STUDENT);
		
		userDTO = new UserWithoutEmailDTO(user);
	}
	
	@After
	public void teardown() {
		user = null;
	}
	
	@Test
	public void testGetAllStudentsForDocent() {
		Role role = Role.STUDENT;
		
		Mockito.when(userGetService.getUsersWithoutEmailAndPassword(Mockito.eq(role))).thenReturn(Collections.singletonList(userDTO));
		
		List<UserWithoutEmailDTO> result = userEndpoint.getStudentsWithoutEmailAndPassword();
		
		Assert.assertTrue(result.size() == 1);
		
		UserWithoutEmailDTO opgehaaldeGebruiker = result.get(0);
		
		Assert.assertEquals(user.getFirstName(), opgehaaldeGebruiker.getFirstName());
		Assert.assertEquals(user.getLastName(), opgehaaldeGebruiker.getLastName());
	}
}

