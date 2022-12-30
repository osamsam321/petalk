package com.ozi.petalk.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.Pet;
@Repository
public interface PetJD extends JpaRepository<Pet, Integer> {

}
