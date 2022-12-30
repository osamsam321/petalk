package com.ozi.petalk.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "Pet")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Pet {
		@Id
		@Column(name = "id")
		@Nonnull
		private long id;
		@Nonnull
		private String pet_name;
		private float pet_weight;
		private String weight_uom_abbr;
		private float pet_height;
		private float pet_width;
		private float pet_length;
		private String lwh_uom_abbr;
		@Nonnull
		private String species;
		
		@ManyToMany(fetch = FetchType.LAZY,
	      cascade = {
	          CascadeType.PERSIST,
	          CascadeType.MERGE
	      })
		@JoinTable(
			    name="pet_animal_breed",
			    joinColumns=@JoinColumn(name="pet_id"),
			    inverseJoinColumns=@JoinColumn(name="animal_breed_id")
			)
		 Set <AnimalBreed> animalBreeds = new HashSet <AnimalBreed> ();
		
		@ManyToMany(fetch = FetchType.LAZY,
			      cascade = {
			          CascadeType.PERSIST,
			          CascadeType.MERGE
			      })
				@JoinTable(
					    name="pet_petalk_device",
					    joinColumns=@JoinColumn(name="pet_id"),
					    inverseJoinColumns=@JoinColumn(name="petalk_device")
					)
				 Set <PetalkDevice> petWithPetalkDevices = new HashSet <PetalkDevice> ();
		
		
		
		@ManyToMany(fetch = FetchType.LAZY,
			      cascade = {
			          CascadeType.PERSIST,
			          CascadeType.MERGE
			      }, mappedBy="petsOwnedByUsers")
	  public List<User> users;
		
		

}
