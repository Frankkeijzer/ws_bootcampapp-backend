package nl.workingspirit.ws_bootcampappbackend.dto;

import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.beans.factory.annotation.Autowired;

import nl.workingspirit.ws_bootcampappbackend.controller.LoginService;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;

public class LoginDTO {
	

	private String firstName;
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Autowired
	LoginService loginService;
	
	private LoginDTO (User user) {
		setName(user.getFirstName());
		setLastName(user.getLastName());
		setRole(user.getRole());
	}
	
	public static LoginDTO maakInlogDTO (User user) {
		LoginDTO loginDTO = new LoginDTO(user);
		return loginDTO;
	}
	
	public String getName() {
		return firstName;
	}
	public void setName(String firstName) {
		this.firstName = firstName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
