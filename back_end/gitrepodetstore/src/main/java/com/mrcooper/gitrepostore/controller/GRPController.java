package com.mrcooper.gitrepostore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrcooper.gitrepostore.response.GRPDetResponseDTO;
import com.mrcooper.gitrepostore.service.GRPService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/grp")
public class GRPController {

	@Autowired
	private GRPService grpService;

	@RequestMapping(value = "/storeUserRepo", method = RequestMethod.GET)
	public GRPDetResponseDTO fetchAndStoreGitRepo(@RequestParam String userName) {
		return grpService.getAndStoreGitRepoDet(userName);
	}
	
	@RequestMapping(value = "/getAllRepo", method = RequestMethod.GET)
	public GRPDetResponseDTO getUserRepoDet() {
		return grpService.getAllRepoDet();
	}

}
