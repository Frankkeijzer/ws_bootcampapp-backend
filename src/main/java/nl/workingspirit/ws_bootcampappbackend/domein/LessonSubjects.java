package nl.workingspirit.ws_bootcampappbackend.domein;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LessonSubjects {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)private Long id;
private String day;
private String title;
@Column(length = 1000)
private String code;
@Column(length = 10000)
private String description;
public Long getId() {
	return id;
}
public String getDay() {
	return day;
}
public void setDay(String day) {
	this.day = day;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getDescription() {
	return description;
}
public void setBeschrijving(String description) {
	this.description = description;
}

}
