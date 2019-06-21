package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.LessonSubjects;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;

@Service
@Transactional
public class GettingService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	LessonSubjectsRepository lessonSubjectsRepository;
	
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Iterable<User> getAllUsersPerRole(Role role){
		return userRepository.findByRoleOrderByLastNameAsc(role);
	}
	
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}
	
	public Iterable<LessonSubjects> getAllLessonSubjects(){
		return lessonSubjectsRepository.findAll();
	}
	
	public Optional<User> getUserByEmailadress(String emailaddress){
		return userRepository.findByEmailaddress(emailaddress);
	}
}
