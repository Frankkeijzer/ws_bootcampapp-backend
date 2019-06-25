package nl.workingspirit.ws_bootcampappbackend.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

public class ShowStudentDTO extends DTO {
	
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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
}
