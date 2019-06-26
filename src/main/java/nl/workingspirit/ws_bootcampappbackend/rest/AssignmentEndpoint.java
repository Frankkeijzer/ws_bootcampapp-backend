package nl.workingspirit.ws_bootcampappbackend.rest;

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
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentPutService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentRequestService;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

@RestController
public class AssignmentEndpoint {

	@Autowired
	AssignmentPostService AssignmentPostService;
	@Autowired
	AssignmentPutService assignmentPutService;
	@Autowired
	AssignmentRequestService assignmentRequestService;

	@PostMapping("AddAssignment")
	public void postAssignment(@RequestBody Assignment assignment) {
		System.out.println("\n doetie of doetie niet" + assignment.getDay());
		AssignmentPostService.postAssignment(assignment);
	}

	@PutMapping("UpdateAssignment")
	public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment) {
		return assignmentPutService.updateAssignment(assignment);
	}

	@GetMapping("GetVisibleAssignments")
	public ResponseEntity<Iterable<Assignment>> getVisibleAssignmentsStudentsPage() {
		Iterable<Assignment> assignmentTemp = assignmentRequestService.requestAllVisibleAssignments();
		return ResponseEntity.ok(assignmentTemp);
	}

}
