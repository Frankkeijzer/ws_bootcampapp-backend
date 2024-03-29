package nl.workingspirit.ws_bootcampappbackend.domein;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class CodeAnswerSubmit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=10000, nullable=false)
	private String code;
	@CreationTimestamp
	private Timestamp timeOfSubmit;
	
	@ManyToOne
	private Assignment assignment;
	
	@ManyToOne
	private User user;
	
	public Long getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Timestamp getTimeOfSubmit() {
		return timeOfSubmit;
	}
	public void setTimeOfSubmit(Timestamp timeOfSubmit) {
		this.timeOfSubmit = timeOfSubmit;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
}
