package com.ozi.petalk.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String pet_name;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
	private Location petalkTriggerLocation;
	private String triggerType;
	private boolean created_with_application;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy="petalkDeviceTriggers")
  public List<PetalkDevice> petalkDevices;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "pet_id",referencedColumnName = "id" )
  private Pet associatedPet;
  
	

	




	public PetalkDeviceTrigger() {
	super();
	// TODO Auto-generated constructor stub
}
	
	

	public PetalkDeviceTrigger(int id, LocalDateTime trigger_ts, String device_name, String pet_name,
			Location petalkTriggerLocation, String triggerType, boolean created_with_application,
			List<PetalkDevice> petalkDevices, Pet associatedPet) {
		super();
		this.id = id;
		this.trigger_ts = trigger_ts;
		this.device_name = device_name;
		this.pet_name = pet_name;
		this.petalkTriggerLocation = petalkTriggerLocation;
		this.triggerType = triggerType;
		this.created_with_application = created_with_application;
		this.petalkDevices = petalkDevices;
		this.associatedPet = associatedPet;
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
	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}
	

	public List<PetalkDevice> getPetalkDevices() {
		return petalkDevices;
	}

	public void setPetalkDevices(List<PetalkDevice> petalkDevices) {
		this.petalkDevices = petalkDevices;
	}

	public Pet getAssociatedPet() {
		return associatedPet;
	}

	public void setAssociatedPet(Pet associatedPet) {
		this.associatedPet = associatedPet;
	}



	public String getPet_name() {
		return pet_name;
	}



	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}
	


	public boolean isCreated_with_application() {
		return created_with_application;
	}



	public void setCreated_with_application(boolean created_with_application) {
		this.created_with_application = created_with_application;
	}



	@Override
	public String toString() {
		return "PetalkDeviceTrigger [id=" + id + ", trigger_ts=" + trigger_ts + ", device_name=" + device_name
				+ ", pet_name=" + pet_name + ", petalkTriggerLocation=" + petalkTriggerLocation + ", triggerType="
				+ triggerType + ", petalkDevices=" + petalkDevices + ", associatedPet=" + associatedPet + "]";
	}
	
	


	
}
