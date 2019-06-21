package nl.workingspirit.ws_bootcampappbackend.domein;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CodeAnswerSubmit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=10000)
	private String code;
	private Timestamp timeOfSubmit;
	
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
	

}
