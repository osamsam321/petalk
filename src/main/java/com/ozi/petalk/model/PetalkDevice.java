package com.ozi.petalk.model;

import java.security.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "petalk_device")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PetalkDevice {
	@Id
	@NonNull
	private int id;
	@NonNull
	private String device_name;
	private Timestamp purchased_ts;
	@NonNull
	private Timestamp first_used_ts;
	@NonNull
	private String sku_value;
	@NonNull
	private String upc_value;
	@NonNull
	private String upc_barcode_img_path;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy="petalkDevices")
  public List<User> users;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy="petWithPetalkDevices")
	public List<Pet> pets;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
			@JoinTable(
				    name="petalk_device_petalk_device_trigger",
				    joinColumns=@JoinColumn(name="petalk_device_id"),
				    inverseJoinColumns=@JoinColumn(name="petalk_device_trigger")
				)
			 Set <PetalkDeviceTrigger> petalkDeviceTriggers = new HashSet <PetalkDeviceTrigger> ();
}
