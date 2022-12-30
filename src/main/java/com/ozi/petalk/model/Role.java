package com.ozi.petalk.model;

import java.util.List;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="role")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Role {
	@Nonnull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private int id;
	@Nonnull 
	private String role_type;
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy="roles")
    public List<User> users;
	
	@OneToOne(mappedBy = "rolesMarkedInRegistrationAudit")
	RegistrationAudit ra;
	

}
