package nl.workingspirit.ws_bootcampappbackend.domein;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Sort;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	@Sort
	private String lastName;
	@Column(nullable=false, unique=true) 
	private String emailaddress;
	@Column(nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Role role;
	
	@OneToMany
	private List<CodeAnswerSubmit> codeAnswerSubmit;
	
	public String getFirstName() {
		return firstName;
	}
	public void setVoornaam(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setAchternaam(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<CodeAnswerSubmit> getCodeAnswerSubmit() {
		return Collections.unmodifiableList(codeAnswerSubmit);
	}
	public void addUitwerking(CodeAnswerSubmit codeAnswerSubmit) {
		this.codeAnswerSubmit.add(codeAnswerSubmit);
	}
	

	
}
