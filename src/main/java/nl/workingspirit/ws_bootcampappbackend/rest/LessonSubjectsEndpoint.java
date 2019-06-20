package nl.workingspirit.ws_bootcampappbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.SavingService;
import nl.workingspirit.ws_bootcampappbackend.controller.GettingService;
import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@RestController
public class LessonSubjectsEndpoint {

	//@Autowired 
	//LesstofService lesstofService;
	@Autowired
	SavingService savingService;
	@Autowired
	GettingService gettingService;
	
	@PostMapping("AddLessonSubjects")
	public void postLessonSubjects(@RequestBody LessonSubjects lessonSubjects) {
		System.out.println("De lesstof is toegevoegd");
		savingService.postLessonSubjects(lessonSubjects);
		
	}
	
	@GetMapping("GetLessonSubjects")
	public Iterable<LessonSubjects> getAllLessonSubjects(){
		return gettingService.getAllLessonSubjects();
	}
	
	
}
