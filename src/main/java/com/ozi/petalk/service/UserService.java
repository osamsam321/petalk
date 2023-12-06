package com.ozi.petalk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;*/
import org.springframework.stereotype.Service;

import com.ozi.petalk.dao.jpa.UserJD;
import com.ozi.petalk.model.Role;
import com.ozi.petalk.model.User;

@Service
public class UserService  {
	
	@Autowired
	UserJD userJD;
	public  Optional<User> saveUser(User user)
	{
		//encode the users password
		/*
		 * user.setPassword(getBCryptPasswordEncoder().encode(user.getPassword()));
		 */		return Optional.of(userJD.save(user));
	}
	
	public  Optional<List<User>> getAllPetalkUsers()
	{
		return Optional.of(userJD.findAll());
	}

	public Optional<User> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.of(userJD.getById(id));
	}

//	@Override
//	public UserDetails loadUserByUsername(String username)  {
//		// TODO Auto-generated method stub
//		User user = userJD.findByEmail(username).orElseThrow(() -> new RuntimeException("user not found"));
//		
//		List<GrantedAuthority> grantedAuthoritys = new ArrayList<>();
//		
//		for (Role role: user.getRoles())
//		{
//			grantedAuthoritys.add(new SimpleGrantedAuthority(role.getRole_type().name()));
//		}
//		
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthoritys);
//	}
	
//	@Bean
//	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
	
}
