package com.ozi.petalk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.PetJD;
import com.ozi.petalk.model.Pet;

@Service
public class PetService {

	@Autowired
	PetJD petjd;
	public Optional<Pet> savePet(Pet pet) {
		// TODO Auto-generated method stub
		return Optional.of(petjd.save(pet));
	}
	public Optional<Pet> getPet(int id) {
		return Optional.of((petjd.getById(id)));
	}
	public Optional<Pet> getPetById(int id) {
		return Optional.of((petjd.getPetById(id)));
	}

}
