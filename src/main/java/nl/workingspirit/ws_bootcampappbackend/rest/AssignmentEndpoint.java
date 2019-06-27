package nl.workingspirit.ws_bootcampappbackend.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentPostService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentUpdateService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentRequestService;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

@RestController
public class AssignmentEndpoint {

	@Autowired
	AssignmentPostService assignmentPostService;
	@Autowired
	AssignmentUpdateService assignmentUpdateService;
	@Autowired
	AssignmentRequestService assignmentRequestService;

	@PostMapping("AddAssignment")
	public void postAssignment(@RequestBody Assignment assignment) {
		assignmentPostService.postAssignment(assignment);
	}

	@PutMapping("UpdateAssignment")
	public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment) {
		return assignmentUpdateService.updateAssignment(assignment);
	}

	@GetMapping("GetVisibleAssignments")
	public ResponseEntity<List<Assignment>> getVisibleAssignmentsStudentsPage() {
		return ResponseEntity.ok(assignmentRequestService.requestAllVisibleAssignments());
	}
	
	@GetMapping("GetAllAssignments")
	public ResponseEntity<List<Assignment>> getAllAssignmentsDocent() {
		return ResponseEntity.ok(assignmentRequestService.requestAllAssignments());
	}

}
