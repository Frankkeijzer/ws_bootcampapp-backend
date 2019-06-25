package nl.workingspirit.ws_bootcampappbackend.domein;

import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String level;
	@Column(nullable=false)
	private String day;
	@Column(nullable=false)
	private boolean visible;
	@Column(length = 10000, nullable=false)
	private String description;
	@Column(length = 1000, nullable=false)
	private String title;
	@Column(length = 10000, nullable=false)
	private String codeExample;
	@OneToMany
	private List<CodeAnswerSubmit> codeAnswerSubmit;

	public Long getId() {
		return id;
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
