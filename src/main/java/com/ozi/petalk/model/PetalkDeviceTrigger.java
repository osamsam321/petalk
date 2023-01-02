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
@Table(name = "petalk_device_trigger")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class PetalkDeviceTrigger {

	@Id
	@Nonnull
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id;
	private LocalDateTime trigger_ts;
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
	

	public PetalkDeviceTrigger(int id, LocalDateTime trigger_ts, String device_name, Location petalkTriggerLocation,
			List<PetalkDevice> petalkDevices) {
		super();
		this.id = id;
		this.trigger_ts = trigger_ts;
		this.device_name = device_name;
		this.petalkTriggerLocation = petalkTriggerLocation;
		this.petalkDevices = petalkDevices;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getTrigger_ts() {
		return trigger_ts;
	}

	public void setTrigger_ts(LocalDateTime trigger_ts) {
		this.trigger_ts = trigger_ts;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public Location getPetalkTriggerLocation() {
		return petalkTriggerLocation;
	}

	public void setPetalkTriggerLocation(Location petalkTriggerLocation) {
		this.petalkTriggerLocation = petalkTriggerLocation;
	}

	public List<PetalkDevice> getPetalkDevices() {
		return petalkDevices;
	}

	public void setPetalkDevices(List<PetalkDevice> petalkDevices) {
		this.petalkDevices = petalkDevices;
	}
	
	
}
