package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import nl.workingspirit.ws_bootcampappbackend.domein.User;

@Service
@Transactional
public class UserPutService {
	
	@Autowired
	UserGetService userGetService;
	
	@Autowired
	UserPostService userPostService;
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> updateUser(@RequestBody User user) {
		Optional<User> tempUser = userRepository.findById(user.getId());
		return tempUser;
	}
}
