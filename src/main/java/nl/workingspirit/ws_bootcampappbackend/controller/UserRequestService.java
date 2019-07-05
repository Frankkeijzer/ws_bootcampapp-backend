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
import nl.workingspirit.ws_bootcampappbackend.dto.UserWithoutEmailDTO;

@Service
@Transactional
public class UserRequestService {
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> requestAllUserInformationById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser;
	}
	
	//Wordt niet meer gebruikt
	public List<User> requestAllUsersPerRole(Role role){
		return userRepository.findByRoleOrderByLastNameAsc(role);
	}
	
	public Optional<User> requestUserByEmailadress(String emailaddress){
		return userRepository.findByEmailaddress(emailaddress);
	}

	public List<User> requestAllUsers() {
		return userRepository.findAll();
	}
	
	public List<UserWithoutEmailDTO> requestUsersWithoutEmailAndPassword(Role role) {
		List<UserWithoutEmailDTO> usersList = new ArrayList<>();
		
		for(User user : userRepository.findByRoleOrderByLastNameAsc(role)) {
			usersList.add(new UserWithoutEmailDTO(user));
		}
		return usersList;
	}
	
	//Wordt nog niet gebruikt
	public List<UserWithoutEmailDTO> requestUsersWithoutPassword(Role role) {
		List<UserWithoutEmailDTO> usersList = new ArrayList<>();
		
		for(User user : userRepository.findByRoleOrderByLastNameAsc(role)) {
			usersList.add(new UserWithoutEmailDTO(user));
		}
		return usersList;
	}
}
