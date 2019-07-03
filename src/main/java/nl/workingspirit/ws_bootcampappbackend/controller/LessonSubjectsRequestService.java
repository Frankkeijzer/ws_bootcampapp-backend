package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;

@Service
@Transactional
public class LessonSubjectsRequestService {
	@Autowired
	LessonSubjectsRepository lessonSubjectsRepository;
	
	public Iterable<LessonSubjects> requestAllLessonSubjects(){
		return lessonSubjectsRepository.findAll();
	}

	public LessonSubjects requestLessonSubjectsByDay(String day) {
		return lessonSubjectsRepository.findByDay(day);
	}
}
