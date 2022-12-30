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
@Table(name = "petalk_device_color_list")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class PetalkDeviceColorList {
	@Id
	@Nonnull
	private int id;
	private String color;
	
	
}
