package nl.workingspirit.ws_bootcampappbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingspirit.ws_bootcampappbackend.controller.OpslaanService;
import nl.workingspirit.ws_bootcampappbackend.controller.OpvraagService;
import nl.workingspirit.ws_bootcampappbackend.domein.Lesstof;

@RestController
public class LesstofEndpoint {

	//@Autowired 
	//LesstofService lesstofService;
	@Autowired
	OpslaanService opslaanService;
	@Autowired
	OpvraagService opvraagService;
	
	@PostMapping("VoegLesstofToe")
	public void postLesstof(@RequestBody Lesstof lesstof) {
		System.out.println("De lesstof is toegevoegd");
		opslaanService.postLesstof(lesstof);
		
	}
	
	@GetMapping("VraagLesstofOp")
	public Iterable<Lesstof> getAlleLesstof(){
		return opvraagService.geefAlleLesstof();
	}
	
	
}
