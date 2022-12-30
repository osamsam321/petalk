package com.ozi.petalk.service;

import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator.OfDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.UserJD;
import com.ozi.petalk.model.User;

@Service
public class UserService {
	
	@Autowired
	UserJD userJD;
	public  Optional<User> saveUser(User user)
	{
		return Optional.of(userJD.save(user));
	}
	
	public  Optional<List<User>> getAllPetalkUsers()
	{
		return Optional.of(userJD.findAll());
	}
	
	
	
}
