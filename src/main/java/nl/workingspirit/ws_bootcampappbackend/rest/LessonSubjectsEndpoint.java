package nl.workingspirit.ws_bootcampappbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.LessonSubjectsGetService;
import nl.workingspirit.ws_bootcampappbackend.controller.LessonSubjectsPostService;
import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@RestController
public class LessonSubjectsEndpoint {

	@Autowired
	LessonSubjectsPostService lessonSubjectsPostService;
	@Autowired
	LessonSubjectsGetService lessonSubjectsGetService;
	
	@PostMapping("AddLessonSubjects")
	public void postLessonSubjects(@RequestBody LessonSubjects lessonSubjects) {
		lessonSubjectsPostService.postLessonSubjects(lessonSubjects);
	}
	
	@GetMapping("GetLessonSubjects")
	public Iterable<LessonSubjects> getAllLessonSubjects(){
		return lessonSubjectsGetService.getAllLessonSubjects();
	}
}
