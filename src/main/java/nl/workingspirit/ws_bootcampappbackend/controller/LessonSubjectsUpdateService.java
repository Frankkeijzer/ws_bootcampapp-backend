package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@Service
@Transactional
public class LessonSubjectsUpdateService {
	@Autowired
	LessonSubjectsRepository lessonSubjectsRepository;
	
	public Optional<LessonSubjects> updateLessonSubject(Long id, LessonSubjects lessonSubject) {
		Optional<LessonSubjects> tempLessonSubject = lessonSubjectsRepository.findById(id);
		if(tempLessonSubject.isPresent()) {
			LessonSubjects target = tempLessonSubject.get();
			target.setTitle(lessonSubject.getTitle());
			target.setCode(lessonSubject.getCode());
			target.setDescription(lessonSubject.getDescription());
			target.setDay(lessonSubject.getDay());
			lessonSubjectsRepository.save(target);
			
			return Optional.of(target);
		}
		else {
			return Optional.empty();
		}
	}
}