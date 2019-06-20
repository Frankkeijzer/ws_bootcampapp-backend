package nl.workingspirit.ws_bootcampappbackend.domein;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Uitwerking {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=10000)
	private String code;
	private Timestamp tijdstip;
	
	@ManyToOne
	private Gebruiker gebruiker;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Timestamp getTijdstip() {
		return tijdstip;
	}
	public void setTijdstip(Timestamp tijdstip) {
		this.tijdstip = tijdstip;
	}
	

}
