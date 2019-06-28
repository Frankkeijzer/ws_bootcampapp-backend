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
	
	public Optional<Assignment> updateAssignment(Long id, Assignment assignment) {
		Optional<Assignment> tempAssignment = assignmentRepository.findById(id);
		if(tempAssignment.isPresent()) {
			Assignment target = tempAssignment.get();
			target.setTitle(assignment.getTitle());
			target.setCodeExample(assignment.getCodeExample());
			target.setDescription(assignment.getDescription());
			target.setDay(assignment.getDay());
			target.setLevel(assignment.getLevel());
			assignmentRepository.save(target);
			
			return Optional.of(target);
		}
		else {
			return Optional.empty();
		}
	}
}
