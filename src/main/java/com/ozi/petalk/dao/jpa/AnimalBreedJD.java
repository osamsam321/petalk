package com.ozi.petalk.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.AnimalBreed;
import com.ozi.petalk.model.Role;
@Repository
public interface AnimalBreedJD  extends JpaRepository<AnimalBreed, Integer>  {
	 
	 
	


}
