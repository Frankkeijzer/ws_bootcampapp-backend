package nl.workingspirit.ws_bootcampappbackend.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingspirit.ws_bootcampappbackend.domein.CodeAnswerSubmit;

@Service
@Transactional
public class CodeAnswerSubmitService {
	
	@Autowired
	CodeAnswerSubmitRepository codeAnswerSubmitRepository;
	
	@Autowired
	UserRepository userRepo;
	
	public void postCodeAnswerSubmit(CodeAnswerSubmit codeAnswerSubmit, Long id) {
		codeAnswerSubmit.setUser(userRepo.findById(id).get());
		codeAnswerSubmitRepository.save(codeAnswerSubmit);
	}
}
