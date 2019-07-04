package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LessonSubjectsDeleteService {
	@Autowired
	LessonSubjectsRepository lessonSubjectsRepository;
	
	public void deleteLessonSubject(Long id) {
		lessonSubjectsRepository.deleteById(id);
	}
}
