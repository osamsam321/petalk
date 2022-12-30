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
@Table(name="petalk_device_trigger_type_list")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class PetalkDeviceTriggerTypeList {
	@Id
	@Nonnull
	private int id;
	@Nonnull
	private String trigger_name;
}
