package com.ozi.petalk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.PetalkDeviceColorListJD;

import com.ozi.petalk.model.PetalkDeviceColorList;

@Service
public class PetalkDeviceColorListService {

	@Autowired
	PetalkDeviceColorListJD petalkDeviceColorListJD ;
	
	public void saveAll(List<PetalkDeviceColorList> pc)
	{
		petalkDeviceColorListJD.saveAll(pc);
	}
		
	public Optional<PetalkDeviceColorList> save(PetalkDeviceColorList pc)
	{
		return Optional.of(petalkDeviceColorListJD.save(pc));
	}
	
}
