package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.LoginDTO;


@Service
@Transactional
public class LoginService{
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<LoginDTO> userLogin (User user) {
		String emailaddress = user.getEmailaddress();
		String password = user.getPassword();
		
		Optional<User> userEmail = userRepository.findByEmailaddress(emailaddress);
		
		if (userEmail.isPresent() && authenticationService.userAuthentication(userEmail.get(), password)) {
			return Optional.of(LoginDTO.maakInlogDTO(userEmail.get()));
		} else {
			return Optional.empty();			
		}
		//Optional<Gebruiker> wachtwoordGebruiker = gRepository.findByWachtwoord(wachtwoord);
		//LoginDTO ingelogdeGebruiker = new LoginDTO (emailGebruiker);
	}
}
