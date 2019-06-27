package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import nl.workingspirit.ws_bootcampappbackend.controller.UserGetService;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.UserWithoutEmailDTO;

@RunWith(MockitoJUnitRunner.class)
public class GetAllStudentsDTOEndpointTest {
	
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
	public void testGetUserPerRoleForDocent() {
		Role role = Role.STUDENT;
		Role role2 = Role.DOCENT;
		
		Mockito.when(userGetService.getUsersWithoutEmailAndPassword(Mockito.eq(role))).thenReturn(Collections.singletonList(userDTO));
		
		Iterable<UserWithoutEmailDTO> result = userEndpoint.getUsersPerRole(role, role2);
		
		Iterator<UserWithoutEmailDTO> iterator = result.iterator();
		
		Assert.assertTrue(iterator.hasNext());
		
		UserWithoutEmailDTO opgehaaldeGebruiker = iterator.next();
		
		Assert.assertEquals(user.getFirstName(), opgehaaldeGebruiker.getFirstName());
		Assert.assertEquals(user.getLastName(), opgehaaldeGebruiker.getLastName());
		Assert.assertFalse(iterator.hasNext());
	}
}
