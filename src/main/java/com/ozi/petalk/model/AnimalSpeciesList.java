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
@Table(name = "animal_species_list")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnimalSpeciesList {
	@Id
	@Nonnull
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id;
	@Nonnull
	private String animal_species;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnimal_species() {
		return animal_species;
	}
	public void setAnimal_species(String animal_species) {
		this.animal_species = animal_species;
	}
	
	
}
