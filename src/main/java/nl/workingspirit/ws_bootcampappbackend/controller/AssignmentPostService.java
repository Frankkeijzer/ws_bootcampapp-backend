package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import nl.workingspirit.ws_bootcampappbackend.rest.AssignmentEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

@Service
@Transactional
public class AssignmentPostService {
	@Autowired
	AssignmentRepository AssignmentRepository;
	
	public Assignment postAssignment(Assignment assignment) {
		System.out.println("\n hier mottie dus gaan saven");
		return AssignmentRepository.save(assignment);
	}
}
