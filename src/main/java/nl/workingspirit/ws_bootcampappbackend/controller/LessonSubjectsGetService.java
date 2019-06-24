package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@Service
@Transactional
public class LessonSubjectsGetService {
	@Autowired
	LessonSubjectsRepository lessonSubjectsRepository;
	
	public Iterable<LessonSubjects> getAllLessonSubjects(){
		return lessonSubjectsRepository.findAll();
	}
}
