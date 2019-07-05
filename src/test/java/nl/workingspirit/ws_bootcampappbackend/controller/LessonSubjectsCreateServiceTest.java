package nl.workingspirit.ws_bootcampappbackend.controller;

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
    	lessonsubjects.setTitle("Java beginselen");
    	
    	this.sut.createLessonSubjects(lessonsubjects);
    	Mockito.verify(lessonsubjectsRepository).save(Mockito.eq(lessonsubjects));
    	
    }
    
}
