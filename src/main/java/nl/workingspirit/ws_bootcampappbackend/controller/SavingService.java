package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;
import nl.workingspirit.ws_bootcampappbackend.domein.CodeAnswerSubmit;

@Service
@Transactional
public class SavingService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	LessonSubjectsRepository lessonSubjectsRepository;
	@Autowired
	CodeAnswerSubmitRepository codeAnswerSubmitRepository;
	
	public void postGebruiker(User user) {
		userRepository.save(user);
	}
	
	public void postLessonSubjects(LessonSubjects lessonSubjects) {
		lessonSubjectsRepository.save(lessonSubjects);
	}
	public void updateUser(User user) {
		userRepository.save(user);
	}
	public void postCodeAnswerSubmit(CodeAnswerSubmit codeAnswerSubmit) {
		codeAnswerSubmitRepository.save(codeAnswerSubmit);
		
	}
}