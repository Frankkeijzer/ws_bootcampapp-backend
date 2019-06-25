package nl.workingspirit.ws_bootcampappbackend.rest;

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
import nl.workingspirit.ws_bootcampappbackend.dto.DTO;
import nl.workingspirit.ws_bootcampappbackend.dto.ShowStudentDTO;
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
		return userGetService.getAllUserInformationById(id);
	}
	
	@GetMapping("getAllUsers/{role}")
	public Iterable<User> getAllUsersPerRole(@PathVariable Role role){
		return userGetService.getAllUsersPerRole(role);
	}
	
	@GetMapping("getAllUsers")
	public Iterable<User> getAllUsers() {
		return userGetService.getAllUsers();
	}
	
	@PutMapping("UpdateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return userPutService.updateUser(user);
	}
	
	// TESTMETHODE VOOR TERUGGEVEN VAN ITERABLE DTO 
	@GetMapping("LaterInvullen/{role}")
	public Iterable<DTO> getUsersPerRole(@PathVariable Role role){
		
	}
}

