package com.ozi.petalk.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "petalk_device_trigger")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class PetalkDeviceTrigger {

	@Id
	@Nonnull
	private int id;
	private Timestamp trigger_ts;
	private String device_name;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
	private Location petalkTriggerLocation;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy="petalkDeviceTriggers")
  public List<PetalkDevice> petalkDevices;
}
