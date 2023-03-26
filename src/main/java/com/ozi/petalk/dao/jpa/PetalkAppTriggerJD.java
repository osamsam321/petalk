/**
 * 
 */
package com.ozi.petalk.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.PetalkAppTrigger;
import com.ozi.petalk.model.PetalkDeviceTrigger;

/**
 * @author osams
 *
 */
@Repository
public interface PetalkAppTriggerJD extends JpaRepository<PetalkAppTrigger, Integer> {
	
}
