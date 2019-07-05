package nl.workingspirit.ws_bootcampappbackend.controller;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentDeleteServiceTest {
     @Mock
    private AssignmentRepository assignmentRepository;

    @InjectMocks
    private AssignmentDeleteService sut;
    
    @Test
    public void deleteAssignmentSucceeds() {	
    	//Given
    	Assignment assignment = new Assignment(2L);
    	Long id = assignment.getId(); 	
    	
    	//Do
    	when(assignmentRepository.findById(id)).thenReturn(Optional.of(assignment));
    	boolean succeeded = sut.deleteAssignment(id);
    	  
    	//Assert
    	Assert.assertTrue(succeeded);
    	Mockito.verify(assignmentRepository).findById(Mockito.eq(id));
    	
    }
    
}
