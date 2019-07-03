package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;


@Service
@Transactional
public class AssignmentRequestService {
	
	@Autowired
	private AssignmentRepository assignmentRepository;
	
	
	public List<Assignment> requestAllVisibleAssignments () {
		List<Assignment> assignmentList = assignmentRepository.findAllByVisible(true);
		return assignmentList;
		 
	}
	
	public List <Assignment> requestAllAssignments () {
		List<Assignment> allAssignmentsList = assignmentRepository.findAll();
		return allAssignmentsList;
	}
	
	public Optional<Assignment> requestAssignmentByID(Long id) {
		return assignmentRepository.findById(id);
	
	}
}
