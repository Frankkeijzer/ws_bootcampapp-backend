package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

@Service
@Transactional
public class AssignmentUpdateService {
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	public ResponseEntity<Assignment> updateAssignment(Assignment assignment) {
		Optional<Assignment> tempAssignment = assignmentRepository.findById(assignment.getId());
		if(tempAssignment.isPresent()) {
			assignmentRepository.save(assignment);
			return new ResponseEntity<Assignment>(assignment, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Assignment>(HttpStatus.BAD_REQUEST);
		}
	}
}
