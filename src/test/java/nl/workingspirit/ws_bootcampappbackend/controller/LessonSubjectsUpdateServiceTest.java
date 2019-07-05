package nl.workingspirit.ws_bootcampappbackend.controller;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class LessonSubjectsUpdateServiceTest {
	LessonSubjects lessonsubjects;

    @Mock
    private LessonSubjectsRepository lessonsubjectsRepository;

    @InjectMocks
    private LessonSubjectsUpdateService sut;

    @Before
    public void setUp() {
    	lessonsubjects = new LessonSubjects();
    	lessonsubjects.setTitle("Java beginselen");
    	lessonsubjects.setDay("2");   
    	lessonsubjects.setCode("lots of code...");   
    	lessonsubjects.setDescription("abc");   
    }
    
    @Test
    public void updateLessonSubjectsTest() {
    	//given / arrange
    	when(lessonsubjectsRepository.findById(1L)).thenReturn(Optional.of(lessonsubjects));
    	
    	//when / act
    	LessonSubjects update = new LessonSubjects();
    	update.setTitle("Samenwerking");
    	update.setDay("3");
    	update.setCode("Even more code...");
    	update.setDescription("xyz");
    	Optional<LessonSubjects> result = sut.updateLessonSubject(1L, update);
    	
    	//then / assert
    	Assert.assertTrue(result.isPresent());
    	Assert.assertEquals(lessonsubjects, result.get());
    	Assert.assertEquals(update.getTitle(), result.get().getTitle());
    	Assert.assertEquals(update.getDay(), result.get().getDay());
    	Assert.assertEquals(update.getCode(), result.get().getCode());	
    	Assert.assertEquals(update.getDescription(), result.get().getDescription());	
    }
    
}
