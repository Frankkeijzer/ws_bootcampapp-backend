package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LessonSubjectsDeleteService {
	@Autowired
	LessonSubjectsRepository lessonSubjectsRepository;
	public boolean deleteLessonSubject (Long id) {
		if (lessonSubjectsRepository.findById(id).isPresent()) {
			lessonSubjectsRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
