package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.Role;


@Service
@Transactional
public class AssignmentRequestService {
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	
	public Iterable<Assignment> requestAllVisibleAssignments () {
		Iterable<Assignment> assignmentIterable = assignmentRepository.findAllByVisible(true);
		return assignmentIterable;
		 
	}

}