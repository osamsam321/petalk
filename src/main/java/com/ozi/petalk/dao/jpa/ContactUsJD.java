package com.ozi.petalk.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozi.petalk.model.ContactUs;


@Repository
public interface ContactUsJD  extends JpaRepository<ContactUs, Integer> {

}
