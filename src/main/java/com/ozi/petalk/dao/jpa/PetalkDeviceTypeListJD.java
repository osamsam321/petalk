package com.ozi.petalk.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.PetalkDeviceTypeList;

@Repository
public interface PetalkDeviceTypeListJD extends CrudRepository<PetalkDeviceTypeList, Integer> {

}
