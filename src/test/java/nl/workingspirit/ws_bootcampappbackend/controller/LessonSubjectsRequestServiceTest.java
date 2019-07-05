package nl.workingspirit.ws_bootcampappbackend.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@RunWith(MockitoJUnitRunner.class)
public class LessonSubjectsRequestServiceTest {
	List<LessonSubjects> testList;
	LessonSubjects lessonsubjects;
	
	
    @Mock
    private LessonSubjectsRepository lessonsubjectsRepository;

    @InjectMocks
    private LessonSubjectsRequestService sut;

    @Before
    public void setUp() {
    	lessonsubjects = new LessonSubjects();
    	testList = new ArrayList<LessonSubjects>();
    	testList.add(lessonsubjects);
    	
    }
    
    @Test
    public void requestAllLessonSubjectsTest() {
    	when(lessonsubjectsRepository.findAll()).thenReturn(Collections.singletonList(lessonsubjects));
    	
    	List<LessonSubjects> resultList = sut.requestAllLessonSubjects();
    	
    	Assert.assertTrue(resultList.size() == 1);
    	
    	LessonSubjects requestedLessonSubjects = resultList.get(0);
    	Assert.assertEquals(lessonsubjects, requestedLessonSubjects);
    }
}
