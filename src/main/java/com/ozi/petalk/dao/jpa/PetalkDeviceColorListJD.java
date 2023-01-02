package com.ozi.petalk.dao.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.PetalkDeviceColorList;
@Repository
public interface PetalkDeviceColorListJD extends  CrudRepository<PetalkDeviceColorList, Integer>  {

}
