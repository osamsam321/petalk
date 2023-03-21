package com.ozi.petalk.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ozi.petalk.model.ContactUs;
import com.ozi.petalk.model.Pet;
import com.ozi.petalk.model.PetalkDevice;
import com.ozi.petalk.model.PetalkDeviceColorList;
import com.ozi.petalk.model.PetalkDeviceTrigger;
import com.ozi.petalk.model.User;
import com.ozi.petalk.service.ContactUsService;
import com.ozi.petalk.service.PetService;
import com.ozi.petalk.service.PetalkDeviceColorListService;
import com.ozi.petalk.service.PetalkDeviceService;
import com.ozi.petalk.service.PetalkDeviceTriggerService;
import com.ozi.petalk.service.UserService;



@RestController
public class HeadController {
	private static final Logger log = LogManager.getLogger(HeadController.class);

		@Autowired
		UserService userService;
		@Autowired
		PetalkDeviceColorListService petalkDeviceColorListService;
		@Autowired
		PetService petService;
		@Autowired
		PetalkDeviceService petalkDeviceService;
		@Autowired
		PetalkDeviceTriggerService petalkDeviceTriggerService;
		@Autowired
		ContactUsService contactUsService;
		
		@CrossOrigin(origins = "http://localhost:4200/")
		@PostMapping(value = "/petalk/saveUser")
		public ResponseEntity savePetalkUser(@RequestBody User user )
		{	
			 log.info("user details:" + user.toString());
			 return ResponseEntity.of(userService.saveUser(user)); 
		}
		@CrossOrigin(origins = "http://localhost:4200/")
		@PostMapping(value = "/petalk/savePet/{userid}")
		public ResponseEntity savePetalkUser(@PathVariable("userid") long userid, @RequestBody Pet pet )
		{	
			 log.info("user details:" + pet.toString());
			 User user = userService.getById(userid).get();
			 user.getPetsOwnedByUsers().add(pet);
			 return ResponseEntity.of(userService.saveUser(user)); 
		}
		@PostMapping(value = "/petalk/saveColor")
		public ResponseEntity savePetalkUser(@RequestBody PetalkDeviceColorList petalkDeviceColorList )
		{	
			 log.info("color details:" + petalkDeviceColorList.toString());
			 return ResponseEntity.of(petalkDeviceColorListService.save(petalkDeviceColorList)); 
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
		@PostMapping("/petalk/new/pet")
		public ResponseEntity<Optional<Pet>> newPetalkPet(@RequestBody Pet pet)
		{
			return ResponseEntity.ok(petService.savePet(pet));
		}
		@CrossOrigin(origins = "http://localhost:4200/")
		@GetMapping("/petalk/pet/name/{id}")
		public ResponseEntity<Optional<Pet>> getPetById(@PathVariable("id") int id)
		{
			return ResponseEntity.ok(petService.getPetById(id));
		}
		@CrossOrigin(origins = "http://localhost:4200/")
		@GetMapping("/petalk/user/getInfo/{id}")
		public ResponseEntity<User> getUserinfo(@PathVariable("id") Long id)
		{
			return ResponseEntity.ok(userService.getById(id).get());
		}
		@CrossOrigin(origins = "http://localhost:4200/")
		@PostMapping("/petalk/new/petalkEventTrigger/{petalk_device_id}")
		public ResponseEntity<PetalkDevice> addNewPetalkEventTrigger(
				@PathVariable("petalk_device_id") int petalk_device_id, @RequestBody PetalkDeviceTrigger petalkDeviceTrigger)
		{
			log.info("petalk trigger info: " + petalkDeviceTrigger.toString());
			return ResponseEntity.ok(petalkDeviceService.saveNewPetalkDeviceTrigger(petalk_device_id, petalkDeviceTrigger));
		}
		@CrossOrigin(origins = "http://localhost:4200/")
		@PostMapping("/petalk/new/contact_us_message")
		public ResponseEntity<Optional<ContactUs>> newContactMessage(@RequestBody ContactUs cuInfo)
		{
			return ResponseEntity.ok(contactUsService.saveNewContactInfo(cuInfo));
		}
		
		@CrossOrigin(origins = "http://localhost:4200/")
		@PostMapping("/petalk/new/petalk_pet")
		public ResponseEntity<Optional<Pet>> newPet(@RequestBody Pet pet)
		{
			return ResponseEntity.ok(petService.savePet(pet));
		}
//		@CrossOrigin(origins = "http://localhost:4200/")
//		@GetMapping("/petalk/user/getUserPetInfo/{id}")
//		public ResponseEntity<Set<Pet>> getUserPetInfo(@PathVariable("id") Long id)
//		{
//			return ResponseEntity.ok(userService.getById(id).get().getPetsOwnedByUsers());
//		}
//		
		
	
}
