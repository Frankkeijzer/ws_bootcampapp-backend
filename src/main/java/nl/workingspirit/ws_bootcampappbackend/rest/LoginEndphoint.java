package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.UserRepository;
import nl.workingspirit.ws_bootcampappbackend.controller.LoginService;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.LoginDTO;

@Configuration
@EnableWebSecurity
@RestController
public class LoginEndphoint extends WebSecurityConfigurerAdapter {
	@Autowired
	LoginService loginService;

	@Autowired
	UserRepository userRepository;
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("**").permitAll().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}

	
	@PostMapping("userLogin")
	public ResponseEntity<LoginDTO> postUserLogin(@RequestBody User user) {
		Optional<LoginDTO> userLogin = loginService.userLogin(user);
		return userLogin.map(inlogDTO -> ResponseEntity.ok(inlogDTO))
				.orElse(ResponseEntity.notFound().build());
	
	}
//	if (inlogGebruiker.isPresent()) {
//	return new ResponseEntity<LoginDTO>(inlogGebruiker.get(),HttpStatus.FOUND);			
//	} else {
//	return new ResponseEntity<LoginDTO>(HttpStatus.NOT_FOUND);
//}
}