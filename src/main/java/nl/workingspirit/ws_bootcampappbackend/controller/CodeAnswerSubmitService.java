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
	
	public void postCodeAnswerSubmit(CodeAnswerSubmit codeAnswerSubmit) {
		codeAnswerSubmitRepository.save(codeAnswerSubmit);
	}
}
