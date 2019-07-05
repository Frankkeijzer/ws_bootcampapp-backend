package nl.workingspirit.ws_bootcampappbackend.controller;

import org.assertj.core.util.Arrays;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentDeleteServiceTest {
     @Mock
    private AssignmentRepository assignmentRepository;

    @InjectMocks
    private AssignmentDeleteService sut;

    @Before
    public void setUp() {
 
    	
    }

    @After
    public void tearDown() {

    }
    
    @Test
    public void deleteAssignmentSucceeds() {	
    	//Given
    	Assignment assignment = new Assignment(2L);
    	Long id = assignment.getId(); 	
    	
    	//Do
    	when(assignmentRepository.findById(id)).thenReturn(Optional.of(assignment));
    	boolean succeeded = sut.deleteAssignment(id);
    	
    	
    	Assert.assertTrue(succeeded);
    	Mockito.verify(assignmentRepository).findById(Mockito.eq(id));
    	
    }
    
}
