package com.ozi.petalk.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozi.petalk.controller.HeadController;
import com.ozi.petalk.dao.jpa.PetalkDeviceJD;
import com.ozi.petalk.model.PetalkDevice;
import com.ozi.petalk.model.PetalkDeviceTrigger;
import com.ozi.petalk.model.User;

@Service
public class PetalkDeviceService {
	private static final Logger log = LogManager.getLogger(PetalkDeviceService.class);

		@Autowired
		PetalkDeviceJD petalkDeviceJD;	
		@Autowired
		PetalkDeviceTriggerService petalkDeviceTriggerService;
		
		public PetalkDevice findById(int petalk_device_id) {
			// TODO Auto-generated method stub
			return petalkDeviceJD.findById(petalk_device_id).get();
		}
		public PetalkDevice saveNewPetalkDeviceTrigger(int petalk_device_id, PetalkDeviceTrigger newPetalkDeviceTrigger) {
			// TODO Auto-generated method stub
			PetalkDevice petalkDevice = petalkDeviceJD.getById(petalk_device_id);
			petalkDevice.getPetalkDeviceTriggers().add(newPetalkDeviceTrigger);
			log.info("new petalk event trigger value: " + newPetalkDeviceTrigger.toString());
			return petalkDeviceJD.save(petalkDevice);
			
		}


}
