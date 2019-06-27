package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.UserPostService;
import nl.workingspirit.ws_bootcampappbackend.controller.UserPutService;
import nl.workingspirit.ws_bootcampappbackend.controller.UserGetService;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.UserWithoutEmailDTO;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;

@RestController
public class UserEndpoint {
	
	@Autowired
	UserGetService userGetService;
	@Autowired 
	UserPostService userPostService;
	@Autowired
	UserPutService userPutService;
	
	@PostMapping("addUser")
	public ResponseEntity<User>postUser(@RequestBody User user) {
		return userPostService.postUser(user);
	}
	
	@GetMapping("giveAllUserInformation/{id}")
	public ResponseEntity<User> getAllUserInformationById(@PathVariable Long id) {
		Optional<User> optionalUser = userGetService.getAllUserInformationById(id);
		return optionalUser.map(user -> ResponseEntity.ok(user))
		.orElse(ResponseEntity.of(optionalUser));
	}
	
	@GetMapping("getAllUsers/{role}")
	public ResponseEntity<List<User>> getAllUsersPerRole(@PathVariable Role role){
		return ResponseEntity.ok(userGetService.getAllUsersPerRole(role));
	}
	
	@GetMapping("getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userGetService.getAllUsers());
	}
	
	@PutMapping("UpdateUser")
	public ResponseEntity<User> updateUser(@RequestBody User userInput) {
		Optional<User> optionalUser = userPutService.updateUser(userInput);
		return optionalUser.map(returnUser -> ResponseEntity.ok(returnUser)).orElse(ResponseEntity.of(optionalUser));
	}
	
	@GetMapping("getAllStudentsForDocent")
	public ResponseEntity<List<UserWithoutEmailDTO>> getStudentsWithoutEmailAndPassword(){
		List<UserWithoutEmailDTO> usersDTO = userGetService.getUsersWithoutEmailAndPassword(Role.STUDENT);
		return ResponseEntity.ok(usersDTO);
	}
}
