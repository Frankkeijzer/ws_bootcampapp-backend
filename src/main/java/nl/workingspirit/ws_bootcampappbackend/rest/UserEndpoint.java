package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.SavingService;
import nl.workingspirit.ws_bootcampappbackend.controller.GettingService;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;

@RestController
public class UserEndpoint {
	
	@Autowired
	GettingService gettingService;
	@Autowired 
	SavingService savingService;
	
	@PostMapping("addUser")
	public ResponseEntity<User >postUser(@RequestBody User user) {
		if(!gettingService.getUserByEmailadress(user.getEmailaddress()).isPresent()) { 
			savingService.postGebruiker(user);
			System.out.println("de gebruiker wordt toegevoegd"); 
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	}
	
	@GetMapping("giveAllUserInformation/{id}")
	public ResponseEntity<User> getAllUserInformationById(@PathVariable Long id) {
		System.out.println("ID: "+id+ ".");
		Optional<User> optionalUser = gettingService.getUser(id);
		
		return optionalUser.map(user -> ResponseEntity.ok(user))
								.orElse(ResponseEntity.notFound().build());
				
//		if (optionalGebruiker.isPresent()) {
//			return new ResponseEntity<Gebruiker>(optionalGebruiker.get(),HttpStatus.FOUND);			
//		} else {
//			return new ResponseEntity<Gebruiker>(HttpStatus.NOT_FOUND);			
//		}
	}
	
	@GetMapping("getAllUsers/{role}")
	public Iterable<User> getAllUsersPerRole(@PathVariable Role role){
//		System.out.println("Binnengekomen rol: " + role);
		return gettingService.getAllUsersPerRole(role);
	}
	
	@GetMapping("getAllUsers")
	public Iterable<User> getAllUsers() {
		return gettingService.getAllUsers();
	}
	
	@PutMapping("UpdateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		Optional<User> tempUser = gettingService.getUser(user.getId());
		if(tempUser.isPresent()) {
			savingService.updateUser(user);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
	}
}

