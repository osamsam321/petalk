package com.ozi.petalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.PetalkDeviceTriggerTypeListJD;
import com.ozi.petalk.model.PetalkDeviceTriggerTypeList;

@Service
public class PetalkDeviceTriggerTypeListService {
	
	@Autowired
	PetalkDeviceTriggerTypeListJD petalkDeviceTriggerTypeListJD;
	
	public void saveAll(List<PetalkDeviceTriggerTypeList> pt)
	{
		petalkDeviceTriggerTypeListJD.saveAll(pt);
	}

}
