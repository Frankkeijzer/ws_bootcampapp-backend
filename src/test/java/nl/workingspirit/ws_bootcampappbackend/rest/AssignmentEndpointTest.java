package nl.workingspirit.ws_bootcampappbackend.rest;

import javax.persistence.Column;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		assignment.setLevel("1");
		assignment.setDay("2");
		assignment.setVisible(true);
		assignment.setDescription("Testdescription");
		assignment.setTitle("TestTitle");
		assignment.setCodeExample("TestExample");
		return assignment;
	}
	
	public void testAssignmentEndpointTest() {
		
		Assert.assertEquals(new ResponseEntity<Assignment>(HttpStatus.OK), assignmentPutService.updateAssignment(newAssignment()));
	}
}
