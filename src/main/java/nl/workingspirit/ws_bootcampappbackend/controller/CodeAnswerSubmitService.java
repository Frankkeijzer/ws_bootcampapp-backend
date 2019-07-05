package nl.workingspirit.ws_bootcampappbackend.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.Assignment;
import nl.workingspirit.ws_bootcampappbackend.domein.CodeAnswerSubmit;
import nl.workingspirit.ws_bootcampappbackend.domein.User;

@Service
@Transactional
public class CodeAnswerSubmitService {
	
	@Autowired
	CodeAnswerSubmitRepository codeAnswerSubmitRepository;
	
	@Autowired
	AssignmentRepository assignmentRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public void postCodeAnswerSubmit(CodeAnswerSubmit codeAnswerSubmit, Long assignmentId, Long userId) {
		Assignment tempAssignment = assignmentRepo.findById(assignmentId).get();
		tempAssignment.addUitwerking(codeAnswerSubmit);
		
		User tempUser = userRepo.findById(userId).get();
		codeAnswerSubmit.setUser(tempUser);
		tempUser.addCodeAnswer(codeAnswerSubmit);
		codeAnswerSubmitRepository.save(codeAnswerSubmit);
	}

	public List<CodeAnswerSubmit> giveCodeAnswerSubmit(Long id) {
		User tempUser = userRepo.findById(id).get();
		return tempUser.getCodeAnswerSubmit();
	}
}
