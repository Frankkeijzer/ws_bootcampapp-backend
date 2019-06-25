package nl.workingspirit.ws_bootcampappbackend.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentPutService;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentEndpointTest {
//	@Autowired
//	AssignmentPutService assignmentPutService;
	
	@Mock
	AssignmentPutService assignmentPutService;
	
//	@InjectMocks
//	private Assignment assignment;
		
	@Test
	public Assignment newAssignment() {
		Assignment assignment = new Assignment();
//		assignment.
		
		return assignment;
	}
	
	public void testAssignmentEndpointTest() {
//	System.out.println(assignment.getDescription());
//	Assert.assertEquals(assignment, assignmentPutService.updateAssignment(assignment));
	}
}
