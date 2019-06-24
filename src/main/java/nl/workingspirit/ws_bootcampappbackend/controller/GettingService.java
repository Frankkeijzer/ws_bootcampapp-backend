package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.User;

@Service
@Transactional
public class GettingService {
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> getUserByEmailadress(String emailaddress){
		return userRepository.findByEmailaddress(emailaddress);
	}
}
