package nl.workingspirit.ws_bootcampappbackend.dto;

import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

public class UserWithoutEmailDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Role role;

	public UserWithoutEmailDTO(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
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
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
