package nl.workingspirit.ws_bootcampappbackend.domein;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Assignment {
	@Id
	@GeneratedValue
	private Long id;
	private String level;
	private String day;
	private boolean visible;
	private String description;
	private String title;
	private String codeExample;

	@OneToMany
	private List<CodeAnswerSubmit> codeAnswerSubmit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCodeExample() {
		return codeExample;
	}

	public void setCodeExample(String codeExample) {
		this.codeExample = codeExample;
	}

	public List<CodeAnswerSubmit> getCodeAnswerSubmit() {
		return Collections.unmodifiableList(codeAnswerSubmit);
	}
	
	public void addUitwerking(CodeAnswerSubmit codeAnswerSubmit) {
		this.codeAnswerSubmit.add(codeAnswerSubmit);
	}
	
}
