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
@Table(name = "petalk_app_trigger")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PetalkAppTrigger {
	@Id
	@Nonnull
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id;
	private LocalDateTime trigger_ts;
	private String pet_name;
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "location_id", referencedColumnName = "id")
//	private Location petalkTriggerLocation;
	private String triggerType;
	
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "pet_id",referencedColumnName = "id" )
  private Pet associatedPet;
  	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy="petalkAppTriggers")
public List<User> users;
	
	


	public PetalkAppTrigger() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public PetalkAppTrigger(int id, LocalDateTime trigger_ts, String pet_name, Location petalkTriggerLocation,
			String triggerType, Pet associatedPet, List<User> users) {
		super();
		this.id = id;
		this.trigger_ts = trigger_ts;
		this.pet_name = pet_name;
//		this.petalkTriggerLocation = petalkTriggerLocation;
		this.triggerType = triggerType;
		this.associatedPet = associatedPet;
		this.users = users;
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


//	public Location getPetalkTriggerLocation() {
//		return petalkTriggerLocation;
//	}
//
//	public void setPetalkTriggerLocation(Location petalkTriggerLocation) {
//		this.petalkTriggerLocation = petalkTriggerLocation;
//	}
	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



	

}
