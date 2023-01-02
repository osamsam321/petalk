package com.ozi.petalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.AnimalBreedListJD;
import com.ozi.petalk.model.AnimalBreedList;

@Service
public class AnimalBreedListService {
	@Autowired
	AnimalBreedListJD animalBreedListJD;
	
	public void saveAll(List<AnimalBreedList> abList)
	{
		animalBreedListJD.saveAll(abList);
	}
	
	
}
