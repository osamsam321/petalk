package com.ozi.petalk.model;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name="animal_breed")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnimalBreed {
	
		@Id
		@GeneratedValue(strategy =GenerationType.AUTO)
		private int id;
		@Nonnull
		private String animal_breed;
		@Nonnull
		private LocalDateTime registration_ts;

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
		
		
		public AnimalBreed(int id, String animal_breed, LocalDateTime registration_ts, Role rolesMarkedInRegistrationAudit,
				String role_type, List<Pet> pets) {
			super();
			this.id = id;
			this.animal_breed = animal_breed;
			this.registration_ts = registration_ts;
			this.rolesMarkedInRegistrationAudit = rolesMarkedInRegistrationAudit;
			this.role_type = role_type;
			this.pets = pets;
		}
		
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
		public LocalDateTime getRegistration_ts() {
			return registration_ts;
		}
		public void setRegistration_ts(LocalDateTime registration_ts) {
			this.registration_ts = registration_ts;
		}
		public Role getRolesMarkedInRegistrationAudit() {
			return rolesMarkedInRegistrationAudit;
		}
		public void setRolesMarkedInRegistrationAudit(Role rolesMarkedInRegistrationAudit) {
			this.rolesMarkedInRegistrationAudit = rolesMarkedInRegistrationAudit;
		}
		public String getRole_type() {
			return role_type;
		}
		public void setRole_type(String role_type) {
			this.role_type = role_type;
		}
		public List<Pet> getPets() {
			return pets;
		}
		public void setPets(List<Pet> pets) {
			this.pets = pets;
		}
		
		
		
		
	}
