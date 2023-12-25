package com.ozi.petalk.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;

@Entity
@Table(name="petalk_device_type_list")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class PetalkDeviceTypeList {
	
	@Id
	@Nonnull
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id;
	@Nonnull
	private String name;
	@Nonnull
	private LocalDateTime manufactured_ts;
	@Nonnull
	private float cost;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getManufactured_ts() {
		return manufactured_ts;
	}
	public void setManufactured_ts(LocalDateTime manufactured_ts) {
		this.manufactured_ts = manufactured_ts;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	

}
