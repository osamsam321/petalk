package com.ozi.petalk.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.Location;
@Repository
public interface LocationJD extends JpaRepository<Location, Integer> {

}
