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

import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentDeleteService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentPostService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentUpdateService;
import nl.workingspirit.ws_bootcampappbackend.controller.AssignmentRequestService;
import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;
import nl.workingspirit.ws_bootcampappbackend.domein.User;
import nl.workingspirit.ws_bootcampappbackend.dto.AssignmentDTO;

@RestController
public class AssignmentEndpoint {

	@Autowired
	AssignmentPostService assignmentPostService;
	@Autowired
	AssignmentUpdateService assignmentUpdateService;
	@Autowired
	AssignmentRequestService assignmentRequestService;
	@Autowired
	AssignmentDeleteService assignmentDeleteService;

	@PostMapping("AddAssignment")
	public void postAssignment(@RequestBody Assignment assignment) {
		assignmentPostService.postAssignment(assignment);
	}

	@PutMapping("UpdateAssignment/{id}")
	public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment, @PathVariable Long id) {
		Optional<Assignment> tempAssignment = this.assignmentUpdateService.updateAssignment(id, assignment);
		if (tempAssignment.isPresent()) {
		return ResponseEntity.ok(tempAssignment.get());
		} else {
		return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("GetVisibleAssignments")
	public ResponseEntity<List<Assignment>> getVisibleAssignmentsStudentsPage() {
		return ResponseEntity.ok(assignmentRequestService.requestAllVisibleAssignments());
	}
	
	@GetMapping("GetAllAssignments")
	public ResponseEntity<List<Assignment>> getAllAssignmentsDocent() {
		return ResponseEntity.ok(assignmentRequestService.requestAllAssignments());
	}
	
	@GetMapping("GetAssignment/{id}")
	public ResponseEntity<Optional<Assignment>> getAssignmentByID(@PathVariable Long id){
		return ResponseEntity.ok(assignmentRequestService.requestAssignmentByID(id));
	}

	@PostMapping("DeleteAssignment/{id}")
	public void deleteAssignment (@PathVariable Long id) {
		assignmentDeleteService.deleteAssignment(id);
	}
	
	@GetMapping("GetAssignmentTitle/{id}")
	public ResponseEntity<AssignmentDTO> getAssignmentTitleByCodeAnswerSubmitID(@PathVariable Long id) {
		return ResponseEntity.ok(assignmentRequestService.requestAssignmentTitle(id));
	}
}
