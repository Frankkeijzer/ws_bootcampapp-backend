package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@Service
@Transactional
public class LessonSubjectsCreateService {
	@Autowired
	LessonSubjectsRepository lessonSubjectsRepository;
	
	public boolean createLessonSubjects(LessonSubjects lessonSubjects) {
		lessonSubjectsRepository.save(lessonSubjects);
		if (lessonSubjectsRepository.findById(lessonSubjects.getId()).isPresent()) {
			System.out.println(lessonSubjects.getId());
			return true;
		}
		else {
			return false;
		}
	}
}
