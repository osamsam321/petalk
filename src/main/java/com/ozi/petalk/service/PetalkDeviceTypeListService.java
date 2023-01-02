package com.ozi.petalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.PetalkDeviceTypeListJD;
import com.ozi.petalk.model.PetalkDeviceTypeList;

@Service
public class PetalkDeviceTypeListService {
	
	@Autowired
	PetalkDeviceTypeListJD petalkDeviceTypeListJD;
	
	public void saveAll(List<PetalkDeviceTypeList> pt)
	{
		petalkDeviceTypeListJD.saveAll(pt);
	}

}
