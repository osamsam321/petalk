package com.ozi.petalk.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.AnimalBreedList;
@Repository
public interface AnimalBreedListJD extends CrudRepository<AnimalBreedList, Integer> {

}
