package nl.workingspirit.ws_bootcampappbackend.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.IterableAssert;
import org.assertj.core.internal.Lists;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentRequestServiceTest {
	Assignment assignment;
	
    @Mock
    private AssignmentRepository assignmentRepository;

    @InjectMocks
    private AssignmentRequestService sut;

    @Before
    public void setUp() {
    	assignment = new Assignment();
    	assignment.setVisible(true);  
    	
    }
    
    @Test
    public void requestAllVisibleAssignmentsTest() {
    	
    	//given / arrange
    	Assignment testAssignment = assignment;
    	List<Assignment> testList = new ArrayList<Assignment>();
    	testList.add(testAssignment);
    	when(assignmentRepository.findAllByVisible(true)).thenReturn(testList);
    	
    	// when / act
    	List<Assignment> resultList = sut.requestAllVisibleAssignments();
    	
    	// then / assert
    	Mockito.verify(assignmentRepository).findAllByVisible(true);  	
    	Assert.assertTrue(resultList.contains(assignment));	
    }
}
