package com.ozi.petalk.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.PetalkAppTriggerJD;
import com.ozi.petalk.dao.jpa.PetalkDeviceTriggerJD;
import com.ozi.petalk.model.PetalkAppTrigger;
import com.ozi.petalk.model.PetalkDevice;

@Service
public class PetalkAppService {
	PetalkAppTriggerJD petalkAppTriggerJD;
	
	public Optional<PetalkAppTrigger>savePetalkAppTrigger(PetalkAppTrigger petalkAppTrigger)
	{
		return Optional.of(petalkAppTriggerJD.save(petalkAppTrigger));
	}
}
