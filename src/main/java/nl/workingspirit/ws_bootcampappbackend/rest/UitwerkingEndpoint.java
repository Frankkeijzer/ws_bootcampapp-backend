package nl.workingspirit.ws_bootcampappbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.OpslaanService;
import nl.workingspirit.ws_bootcampappbackend.controller.OpvraagService;
import nl.workingspirit.ws_bootcampappbackend.domein.Uitwerking;

@RestController
public class UitwerkingEndpoint {
	
	@Autowired
	OpslaanService opslaanService;
	
	@Autowired
	OpvraagService opvraagService;
	
	@PostMapping("VoegUitwerkingToe")
	public void postUitwerking(@RequestBody Uitwerking uitwerking) {
		opslaanService.postUitwerking(uitwerking);
		
	}
	
}