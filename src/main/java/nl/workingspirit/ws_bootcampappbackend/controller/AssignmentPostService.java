package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;

@Service
@Transactional
public class AssignmentPostService {
	@Autowired
	AssignmentRepository AssignmentRepository;
	
	public void postAssignment(Assignment assignment) {
		AssignmentRepository.save(assignment);
	}
}
