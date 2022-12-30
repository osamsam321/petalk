package com.ozi.petalk.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="location")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Location {
	@Id
	private int id;
	@Nonnull
	private String address;
	private String address2;
	@Nonnull
	private String home_type;
	private String apartment_room_value;
	private int zip_code;
	@Nonnull
	private String street;
	@Nonnull
	private String state;
	@Nonnull
	private String country;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy="locations")
	
	@OneToOne(mappedBy = "petalkTriggerLocation")
	PetalkDeviceTrigger petalkDeviceTrigger;
}
