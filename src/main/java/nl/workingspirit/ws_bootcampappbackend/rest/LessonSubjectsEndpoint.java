package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.LessonSubjectsRequestService;
import nl.workingspirit.ws_bootcampappbackend.controller.LessonSubjectsCreateService;
import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@RestController
public class LessonSubjectsEndpoint {

	@Autowired
	LessonSubjectsCreateService lessonSubjectsCreateService;
	@Autowired
	LessonSubjectsRequestService lessonSubjectsRequestService;
	
	@PostMapping("AddLessonSubjects")
	public void postLessonSubjects(@RequestBody LessonSubjects lessonSubjects) {
		lessonSubjectsCreateService.createLessonSubjects(lessonSubjects);
	}
	
	@GetMapping("GetLessonSubjects")
	public Iterable<LessonSubjects> getAllLessonSubjects(){
		return lessonSubjectsRequestService.requestAllLessonSubjects();
	}
	
	@GetMapping("GetLessonSubjects/{day}")
	public ResponseEntity<LessonSubjects> getLessonSubjectsByDay(@PathVariable String day){
		return ResponseEntity.ok(lessonSubjectsRequestService.requestLessonSubjectsByDay(day));
	}
}
