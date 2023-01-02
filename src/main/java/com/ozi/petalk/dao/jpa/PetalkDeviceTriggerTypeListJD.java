package com.ozi.petalk.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.PetalkDeviceTriggerTypeList;
@Repository
public interface PetalkDeviceTriggerTypeListJD extends CrudRepository<PetalkDeviceTriggerTypeList, Integer> {

}
