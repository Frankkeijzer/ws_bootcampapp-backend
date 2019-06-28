package nl.workingspirit.ws_bootcampappbackend.controller;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentUpdateServiceTest {
	Assignment assignment;

    @Mock
    private AssignmentRepository assignmentRepository;

    @InjectMocks
    private AssignmentUpdateService sut;

    @Before
    public void setUp() {
    	assignment = new Assignment(1L);
    	assignment.setTitle("Opdracht 10");
    	assignment.setVisible(true);
    	
    }
    
    @Test
    public void updateAssignmentTest() {
    	//given / arrange
    	Assignment expectedAssignment = assignment;
    	when(assignmentRepository.findById(1L)).thenReturn(Optional.of(expectedAssignment));
    	
    	//when / act
    	assignment.setTitle("Opdracht 22");
    	assignment.setVisible(true);
    	ResponseEntity<Assignment> result = sut.updateAssignment(assignment);
    	
    	//then / assert
    	Assert.assertEquals(expectedAssignment, result.getBody());
    	Mockito.verify(assignmentRepository).save(Mockito.eq(expectedAssignment));
    	
    }
    
}
