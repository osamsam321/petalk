package com.ozi.petalk.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.annotation.Nonnull;

@Entity
@Table(name="petalk_device_type_list")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class PetalkDeviceTypeList {
	
	@Id
	@Nonnull
	private int id;
	@Nonnull
	private String name;
	@Nonnull
	private Timestamp manufactured_ts;
	@Nonnull
	private float cost;
	

}
