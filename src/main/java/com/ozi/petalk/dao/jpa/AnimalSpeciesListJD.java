package com.ozi.petalk.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.AnimalSpeciesList;
@Repository
public interface AnimalSpeciesListJD extends CrudRepository<AnimalSpeciesList, Integer> {

}
