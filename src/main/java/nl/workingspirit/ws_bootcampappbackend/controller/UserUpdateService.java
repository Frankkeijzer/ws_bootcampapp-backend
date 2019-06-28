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
public class UserUpdateService {
	
	@Autowired
	UserRequestService userRequestService;
	
	@Autowired
	UserRepository userRepository;
	
	public boolean updateUser(User user, Long id) {
		Optional<User> tempUser = userRepository.findById(id);
		if(tempUser.isPresent()) {
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
		
	}
}
