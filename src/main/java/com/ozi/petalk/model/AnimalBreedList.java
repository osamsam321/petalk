package com.ozi.petalk.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "animal_breed_list")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnimalBreedList {
	@Id
	@Nonnull
	private int id;
	@Nonnull
	private String animal_breed;
	@Nonnull
	private String scientific_name;
	@Nonnull
	private String generic_name;
	
}
