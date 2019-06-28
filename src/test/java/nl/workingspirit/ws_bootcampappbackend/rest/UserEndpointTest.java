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
import org.springframework.http.ResponseEntity;

import nl.workingspirit.ws_bootcampappbackend.controller.UserRequestService;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.UserWithoutEmailDTO;

@RunWith(MockitoJUnitRunner.class)
public class UserEndpointTest {
	
	@InjectMocks
	UserEndpoint userEndpoint;
	
	@Mock
	UserRequestService userRequestService;
	
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
	public void testGetAllStudentsForDocentTest() {
		Role role = Role.STUDENT;
		
		Mockito.when(userRequestService.requestUsersWithoutEmailAndPassword(Mockito.eq(role))).thenReturn(Collections.singletonList(userDTO));
		
		ResponseEntity<List<UserWithoutEmailDTO>> result = userEndpoint.getStudentsWithoutEmailAndPassword();
		
		Assert.assertTrue(result.getBody().size() == 1);
		
		UserWithoutEmailDTO requestedUser = result.getBody().get(0);
		
		Assert.assertEquals(user.getFirstName(), requestedUser.getFirstName());
		Assert.assertEquals(user.getLastName(), requestedUser.getLastName());
	}
}

