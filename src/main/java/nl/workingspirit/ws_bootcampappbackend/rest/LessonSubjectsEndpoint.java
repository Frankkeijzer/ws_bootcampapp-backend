package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.LessonSubjectsRequestService;
import nl.workingspirit.ws_bootcampappbackend.controller.LessonSubjectsUpdateService;
import nl.workingspirit.ws_bootcampappbackend.controller.LessonSubjectsCreateService;
import nl.workingspirit.ws_bootcampappbackend.controller.LessonSubjectsDeleteService;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@RestController
public class LessonSubjectsEndpoint {

	@Autowired
	LessonSubjectsCreateService lessonSubjectsCreateService;
	@Autowired
	LessonSubjectsRequestService lessonSubjectsRequestService;
	@Autowired
	LessonSubjectsUpdateService lessonSubjectsUpdateService;
	@Autowired
	LessonSubjectsDeleteService lessonSubjectsDeleteService;
	
	@PostMapping("AddLessonSubjects")
	public ResponseEntity<HttpStatus> postLessonSubjects(@RequestBody LessonSubjects lessonSubjects) {
		if (lessonSubjectsCreateService.createLessonSubjects(lessonSubjects)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("GetLessonSubjects")
	public Iterable<LessonSubjects> getAllLessonSubjects(){
		return lessonSubjectsRequestService.requestAllLessonSubjects();
	}
	
	@GetMapping("GetLessonSubjects/{day}")
	public ResponseEntity<LessonSubjects> getLessonSubjectsByDay(@PathVariable String day){
		return ResponseEntity.ok(lessonSubjectsRequestService.requestLessonSubjectsByDay(day));
	}
	
	@GetMapping("GetLessonSubjectsByID/{id}")
	public ResponseEntity<Optional<LessonSubjects>> getLessonSubjectsByID(@PathVariable Long id){
		return ResponseEntity.ok(lessonSubjectsRequestService.requestLessonSubjectsByID(id));
	}
	
	@PutMapping("UpdateLessonSubject/{id}")
	public ResponseEntity<LessonSubjects> updateLessonSubjects(@RequestBody LessonSubjects lessonSubject, @PathVariable Long id) {
		Optional<LessonSubjects> tempLessonSubject = this.lessonSubjectsUpdateService.updateLessonSubject(id, lessonSubject);
		if (tempLessonSubject.isPresent()) {
		return ResponseEntity.ok(tempLessonSubject.get());
		} else {
		return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("DeleteLessonSubject/{id}")
	public void deleteLessonSubject (@PathVariable Long id) {
		lessonSubjectsDeleteService.deleteLessonSubject(id);
	}

	
	
}
