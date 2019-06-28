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
    	assignment.setLevel("1");   
    	assignment.setVisible(true);
    	
    }
    
    @Test
    public void updateAssignmentTest() {
    	//given / arrange
    	when(assignmentRepository.findById(1L)).thenReturn(Optional.of(assignment));
    	
    	//when / act
    	Assignment update = new Assignment(1L);
    	update.setTitle("Opdracht 22");
    	update.setCodeExample("Code Example");
    	update.setDay("2");
    	update.setDescription("Description");
    	update.setLevel("1");    	
    	update.setVisible(true);
    	Optional<Assignment> result = sut.updateAssignment(update);
    	
    	//then / assert
    	Assert.assertTrue(result.isPresent());
    	Assert.assertEquals(assignment, result.get());
    	Assert.assertEquals(update.getTitle(), result.get().getTitle());
    	Assert.assertEquals(update.getCodeExample(), result.get().getCodeExample());
    	Assert.assertEquals(update.getDay(), result.get().getDay());
    	Assert.assertEquals(update.getDescription(), result.get().getDescription());
    	Assert.assertEquals(update.getLevel(), result.get().getLevel());
    	Mockito.verify(assignmentRepository).save(Mockito.eq(update));
    	
    }
    
}
