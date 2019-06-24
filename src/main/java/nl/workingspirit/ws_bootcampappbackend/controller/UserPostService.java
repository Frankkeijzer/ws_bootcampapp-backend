package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.User;

@Service
@Transactional
public class UserPostService {

	@Autowired
	UserGetService userGetService;
	
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<User >postUser(User user) {
		if(!userGetService.getUserByEmailadress(user.getEmailaddress()).isPresent()) { 
			userRepository.save(user);
			System.out.println("de gebruiker wordt toegevoegd"); 
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
	
	public void updateUser(User user) {
		userRepository.save(user);
	}
}
