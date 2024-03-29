package com.ozi.petalk.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
		@GeneratedValue(strategy =GenerationType.AUTO)

		private long id;
		@Nonnull
		private String pet_name;
		private float pet_weight;
		private String weight_uom_abbr;
		private float pet_height;
		private float pet_width;
		private float pet_length;
		private String lwh_uom_abbr;
		private String color;
	    @Min(value = 0 , message = "Value should be greater then 0")
		private int age;
		@Nonnull
		private String species;
		private String img_relative_path;
		private String img_absolute_path;
		private String img_file_name;		
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
		
		//having this leads to a circular references between this and petalk devices with user petalkdevice in JSON data
//		@ManyToMany(fetch = FetchType.LAZY,
//			      cascade = {
//			          CascadeType.PERSIST,
//			          CascadeType.MERGE
//			      })
//				@JoinTable(
//					    name="pet_petalk_device",
//					    joinColumns=@JoinColumn(name="pet_id"),
//					    inverseJoinColumns=@JoinColumn(name="petalk_device")
//					)
//				 Set <PetalkDevice> petWithPetalkDevices = new HashSet <PetalkDevice> ();
	
		
		@JsonIgnore
		@ManyToMany(fetch = FetchType.LAZY,
			      cascade = {
			          CascadeType.PERSIST,
			          CascadeType.MERGE
			      }, mappedBy="petsOwnedByUsers")
	  public List<User> users;

	  @OneToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE,
			   } )
		private Set<PetalkAppTrigger> petalkAppTrigger;
		

		public long getId() {
			return id;
		}



		public void setId(long id) {
			this.id = id;
		}



		public String getPet_name() {
			return pet_name;
		}



		public void setPet_name(String pet_name) {
			this.pet_name = pet_name;
		}



		public float getPet_weight() {
			return pet_weight;
		}



		public void setPet_weight(float pet_weight) {
			this.pet_weight = pet_weight;
		}



		public String getWeight_uom_abbr() {
			return weight_uom_abbr;
		}



		public void setWeight_uom_abbr(String weight_uom_abbr) {
			this.weight_uom_abbr = weight_uom_abbr;
		}



		public float getPet_height() {
			return pet_height;
		}



		public void setPet_height(float pet_height) {
			this.pet_height = pet_height;
		}



		public float getPet_width() {
			return pet_width;
		}



		public void setPet_width(float pet_width) {
			this.pet_width = pet_width;
		}



		public float getPet_length() {
			return pet_length;
		}



		public void setPet_length(float pet_length) {
			this.pet_length = pet_length;
		}



		public String getLwh_uom_abbr() {
			return lwh_uom_abbr;
		}



		public void setLwh_uom_abbr(String lwh_uom_abbr) {
			this.lwh_uom_abbr = lwh_uom_abbr;
		}



		public String getSpecies() {
			return species;
		}



		public void setSpecies(String species) {
			this.species = species;
		}



		public Set<AnimalBreed> getAnimalBreeds() {
			return animalBreeds;
		}



		public void setAnimalBreeds(Set<AnimalBreed> animalBreeds) {
			this.animalBreeds = animalBreeds;
		}



//		public Set<PetalkDevice> getPetWithPetalkDevices() {
//			return petWithPetalkDevices;
//		}
//
//
//
//		public void setPetWithPetalkDevices(Set<PetalkDevice> petWithPetalkDevices) {
//			this.petWithPetalkDevices = petWithPetalkDevices;
//		}



		public List<User> getUsers() {
			return users;
		}



		public void setUsers(List<User> users) {
			this.users = users;
		}



		public String getColor() {
			return color;
		}



		public void setColor(String color) {
			this.color = color;
		}



		public int getAge() {
			return age;
		}



		public void setAge(int age) {
			this.age = age;
		}
		
		
		
		
		
		
		

}
