package nl.workingspirit.ws_bootcampappbackend.controller;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class LessonSubjectsCreateServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private LessonSubjectsRepository lessonsubjectsRepository;

    @InjectMocks
    private LessonSubjectsCreateService sut;

    @Before
    public void setUp() {
    	
    }

    @After
    public void tearDown() {

    }
    
    @Test
    public void createLessonSubjectsTest() {
    	LessonSubjects lessonsubjects = new LessonSubjects();
    	Long id = lessonsubjects.getId();
    	lessonsubjects.setTitle("Java beginselen");
    	
    	when(lessonsubjectsRepository.findById(id)).thenReturn(Optional.of(lessonsubjects));
      	boolean succeeded = sut.createLessonSubjects(lessonsubjects);
   
      	Assert.assertTrue(succeeded);
    	Mockito.verify(lessonsubjectsRepository).save(Mockito.eq(lessonsubjects));
    	
    }
    
}
