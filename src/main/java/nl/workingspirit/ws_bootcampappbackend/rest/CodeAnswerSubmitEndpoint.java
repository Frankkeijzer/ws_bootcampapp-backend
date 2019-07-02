package nl.workingspirit.ws_bootcampappbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.CodeAnswerSubmitService;
import nl.workingspirit.ws_bootcampappbackend.domein.CodeAnswerSubmit;

@RestController
public class CodeAnswerSubmitEndpoint {
	
	@Autowired
	CodeAnswerSubmitService codeAnswerSubmitService;
	
	@PostMapping("AddCodeAnswers/{assignmentId}/{userId}")
	public void postCodeAnswers(@RequestBody CodeAnswerSubmit codeAnswerSubmit, @PathVariable Long assignmentId, @PathVariable Long userId) {
		codeAnswerSubmitService.postCodeAnswerSubmit(codeAnswerSubmit, assignmentId, userId);
	}
}