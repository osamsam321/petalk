package com.ozi.petalk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ozi.petalk.model.User;
import com.ozi.petalk.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



@RestController
public class HeadController {
	private static final Logger log = LogManager.getLogger(HeadController.class);

		@Autowired
		UserService userService;
		
		@PostMapping("/petalk/saveUser")
		public ResponseEntity savePetalkUser(@RequestBody User user )
		{	
			 log.info("user details:" + user.toString());
			 return ResponseEntity.of(userService.saveUser(user)); 
		}
		@PostMapping("/petalk/saveUser/{id}")
		public ResponseEntity test(@PathVariable ("id") int id )
		{	
			 return ResponseEntity.ok().build(); 
		}
		
		@GetMapping("/petalk/test")
		public ResponseEntity<Optional<List<User>>> getAllPetalkUser( )
		{	
			return ResponseEntity.ok(userService.getAllPetalkUsers());
		}
	
}
