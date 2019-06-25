package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

@Service
@Transactional
public class AssignmentPutService {
	
	@Autowired
	AssignmentPutService assignmentGetService;
	
	@Autowired
	AssignmentPostService assignmentPostService;
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment) {
		Optional<Assignment> tempAssignment = assignmentRepository.findById(assignment.getId());
		if(tempAssignment.isPresent()) {
			assignmentPostService.postAssignment(assignment);
			return new ResponseEntity<Assignment>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Assignment>(HttpStatus.BAD_REQUEST);
		}
	}
}
