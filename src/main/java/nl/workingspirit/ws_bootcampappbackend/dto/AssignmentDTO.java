package nl.workingspirit.ws_bootcampappbackend.dto;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

public class AssignmentDTO {
	
	private String title;
	
	public AssignmentDTO(Assignment assignment) {
		this.setTitle(assignment.getTitle());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
