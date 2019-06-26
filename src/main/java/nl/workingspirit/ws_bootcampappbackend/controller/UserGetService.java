package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.UserDTO;

@Service
@Transactional
public class UserGetService {
	
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<User> getAllUserInformationById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.map(user -> ResponseEntity.ok(user))
								.orElse(ResponseEntity.notFound().build());
//		if (optionalGebruiker.isPresent()) {
//		return new ResponseEntity<Gebruiker>(optionalGebruiker.get(),HttpStatus.FOUND);			
//	} else {
//		return new ResponseEntity<Gebruiker>(HttpStatus.NOT_FOUND);	
//	}
	}
	
	//Wordt niet meer gebruikt
	public Iterable<User> getAllUsersPerRole(Role role){
		return userRepository.findByRoleOrderByLastNameAsc(role);
	}
	
	public Optional<User> getUserByEmailadress(String emailaddress){
		return userRepository.findByEmailaddress(emailaddress);
	}

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public List<UserDTO> getUsersWithoutPassword(Role role) {
		List<UserDTO> usersList = new ArrayList<>();
		
		for(User user : userRepository.findByRoleOrderByLastNameAsc(role)) {
			usersList.add(new UserDTO(user));
		}
		return usersList;
	}
}

