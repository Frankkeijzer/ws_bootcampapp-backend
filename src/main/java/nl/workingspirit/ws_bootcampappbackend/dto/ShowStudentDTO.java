package nl.workingspirit.ws_bootcampappbackend.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

public class ShowStudentDTO {
	
	private String firstName;
	private String lastName;
	private String emailaddress;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public ShowStudentDTO(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.emailaddress = user.getEmailaddress();
		this.role = user.getRole();
	}
}
