package com.ozi.petalk.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id;
	@Nonnull
	private String animal_breed;
	@Nonnull
	private String scientific_name;
	@Nonnull
	private String generic_name;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnimal_breed() {
		return animal_breed;
	}
	public void setAnimal_breed(String animal_breed) {
		this.animal_breed = animal_breed;
	}
	public String getScientific_name() {
		return scientific_name;
	}
	public void setScientific_name(String scientific_name) {
		this.scientific_name = scientific_name;
	}
	public String getGeneric_name() {
		return generic_name;
	}
	public void setGeneric_name(String generic_name) {
		this.generic_name = generic_name;
	}
	
	
	
}
