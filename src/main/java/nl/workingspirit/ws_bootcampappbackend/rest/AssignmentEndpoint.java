package nl.workingspirit.ws_bootcampappbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentPostService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentPutService;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

@RestController
public class AssignmentEndpoint {

	@Autowired
	AssignmentPostService AssignmentPostService;
	@Autowired
	AssignmentPutService assignmentPutService;
	
	@PostMapping("AddAssignment")
	public void postAssignment(@RequestBody Assignment assignment) {
		AssignmentPostService.postAssignment(assignment);
	}
	
	@PutMapping("UpdateAssignment")
	public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment) {
		return assignmentPutService.updateAssignment(assignment);
	}
	
}
