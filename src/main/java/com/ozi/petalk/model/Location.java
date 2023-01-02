package com.ozi.petalk.model;


import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy =GenerationType.AUTO)

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
		      }, mappedBy="userLocations")
	Set<User> users;
	
	@OneToOne(mappedBy = "petalkTriggerLocation")
	PetalkDeviceTrigger petalkDeviceTrigger;
	
	public Location(int id, String address, String address2, String home_type, String apartment_room_value,
			int zip_code, String street, String state, String country, PetalkDeviceTrigger petalkDeviceTrigger) {
		super();
		this.id = id;
		this.address = address;
		this.address2 = address2;
		this.home_type = home_type;
		this.apartment_room_value = apartment_room_value;
		this.zip_code = zip_code;
		this.street = street;
		this.state = state;
		this.country = country;
		this.petalkDeviceTrigger = petalkDeviceTrigger;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getHome_type() {
		return home_type;
	}

	public void setHome_type(String home_type) {
		this.home_type = home_type;
	}

	public String getApartment_room_value() {
		return apartment_room_value;
	}

	public void setApartment_room_value(String apartment_room_value) {
		this.apartment_room_value = apartment_room_value;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public PetalkDeviceTrigger getPetalkDeviceTrigger() {
		return petalkDeviceTrigger;
	}

	public void setPetalkDeviceTrigger(PetalkDeviceTrigger petalkDeviceTrigger) {
		this.petalkDeviceTrigger = petalkDeviceTrigger;
	}
	
	
}
