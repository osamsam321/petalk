package com.ozi.petalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ozi.petalk.dao.jpa.AnimalSpeciesListJD;
import com.ozi.petalk.model.AnimalSpeciesList;

@Service
public class AnimalSpeciesListService {
	

		@Autowired
		AnimalSpeciesListJD animalSpeciesListJD;
		
		public void saveAll(List<AnimalSpeciesList> abList)
		{
			animalSpeciesListJD.saveAll(abList);
		}
		
		
	

}
