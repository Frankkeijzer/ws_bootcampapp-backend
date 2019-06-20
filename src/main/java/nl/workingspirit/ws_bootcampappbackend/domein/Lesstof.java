package nl.workingspirit.ws_bootcampappbackend.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lesstof {
@Id
@GeneratedValue
private Long id;
private String dag;
private String titel;
@Column(length = 1000)
private String code;
@Column(length = 1000)
private String beschrijving;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDag() {
	return dag;
}
public void setDag(String dag) {
	this.dag = dag;
}
public String getTitel() {
	return titel;
}
public void setTitel(String titel) {
	this.titel = titel;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getBeschrijving() {
	return beschrijving;
}
public void setBeschrijving(String beschrijving) {
	this.beschrijving = beschrijving;
}

}
