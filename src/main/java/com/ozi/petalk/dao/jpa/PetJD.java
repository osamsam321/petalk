package com.ozi.petalk.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.Pet;
@Repository
public interface PetJD extends JpaRepository<Pet, Integer> {

	@Query(
		  value = "select distinct * from ptdb_dev.sbmain.pet p where p.id = ?1", 
		  nativeQuery = true)
	Pet getPetById(int id);
}
