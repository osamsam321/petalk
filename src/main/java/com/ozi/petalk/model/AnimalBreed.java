package com.ozi.petalk.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="animal_breed")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnimalBreed {
	
		@Id
		private int id;
		@Nonnull
		private String animal_breed;
		@Nonnull
		private Timestamp registration_ts;

		@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "role_id", referencedColumnName = "id")
	    private Role rolesMarkedInRegistrationAudit;
		
		@Nonnull 
		private String role_type;
		@ManyToMany(fetch = FetchType.LAZY,
			      cascade = {
			          CascadeType.PERSIST,
			          CascadeType.MERGE
			      }, mappedBy="animalBreeds")
	    public List<Pet> pets;
		
		
	}
