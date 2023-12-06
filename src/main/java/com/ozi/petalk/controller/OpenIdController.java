package com.ozi.petalk.controller;

import java.util.Optional;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/login/openid")
public class OpenIdController {
	//full url = http://localhost:8002/login/openid/oauth2.0/github
	RestTemplate rt = new RestTemplate();
	final String GITHUB_OPENID_URL = "http://localhost:8002/login/oauth2/code/github";
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping(value = "/oauth2.0/github")
	public ResponseEntity githubOpenIdLogin()
	{
		ResponseEntity<String> response = rt.getForEntity(GITHUB_OPENID_URL, String.class);
		return response;
	}
	
	//http://localhost:8002/login/openid/sucessful_login
		@CrossOrigin(origins = "http://localhost:4200/")
		@GetMapping(value = "sucessful_login")
		public ResponseEntity loginSuccesfull()
		{
			ResponseEntity<String> response = rt.getForEntity(GITHUB_OPENID_URL, String.class);
			return response;
		}
}
