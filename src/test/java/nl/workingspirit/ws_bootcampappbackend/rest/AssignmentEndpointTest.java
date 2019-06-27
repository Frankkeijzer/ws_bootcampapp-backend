package nl.workingspirit.ws_bootcampappbackend.rest;

import javax.persistence.Column;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentUpdateService;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentEndpointTest {
//	@Autowired
//	AssignmentUpdateService assignmentUpdateService;
	
	@Mock
	AssignmentUpdateService assignmentUpdateService;
	
//	@InjectMocks
//	private Assignment assignment;
		
	@Test
	public void newAssignment() {
		Assignment assignment = new Assignment();
//		assignment.
		
//		return assignment;
	}
	
	public void testAssignmentEndpointTest() {
//	System.out.println(assignment.getDescription());
//	Assert.assertEquals(assignment, assignmentUpdateService.updateAssignment(assignment));
	}
}
