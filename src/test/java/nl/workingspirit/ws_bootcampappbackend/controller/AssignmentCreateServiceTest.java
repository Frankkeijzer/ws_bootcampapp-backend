package nl.workingspirit.ws_bootcampappbackend.controller;

import org.assertj.core.util.Arrays;
import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.*;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentCreateServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private AssignmentRepository assignmentRepository;

    @InjectMocks
    private AssignmentPostService sut;

    @Before
    public void setUp() {
    	
    }

    @After
    public void tearDown() {

    }
    
    @Test
    public void postAssignmentTest() {
    	Assignment assignment = new Assignment(1L);
    	assignment.setTitle("Opdracht 1");
    	
    	this.sut.postAssignment(assignment);
    	Mockito.verify(assignmentRepository).save(Mockito.eq(assignment));
    	
    }
    
}
