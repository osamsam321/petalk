package com.ozi.petalk.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.ContactUsJD;
import com.ozi.petalk.model.ContactUs;

@Service
public class ContactUsService {
@Autowired
ContactUsJD contactUsJD;

public Optional<ContactUs> saveNewContactInfo(ContactUs cuInfo) {
	// TODO Auto-generated method stub
	return Optional.of(contactUsJD.save(cuInfo));
}

	
}
