package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AssignmentDeleteService {

	@Autowired
	AssignmentRepository assignmentRepository;
	
	public boolean deleteAssignment (Long id) {
		if (assignmentRepository.findById(id).isPresent()) {
			assignmentRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
