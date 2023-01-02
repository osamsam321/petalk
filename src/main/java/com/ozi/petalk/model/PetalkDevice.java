package com.ozi.petalk.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id;
	@NonNull
	private String device_name;
	private LocalDateTime purchased_ts;
	@NonNull
	private LocalDateTime first_used_ts;
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
	
	
	public PetalkDevice(int id, String device_name, LocalDateTime purchased_ts, LocalDateTime first_used_ts, String sku_value,
			String upc_value, String upc_barcode_img_path, List<User> users, List<Pet> pets,
			Set<PetalkDeviceTrigger> petalkDeviceTriggers) {
		super();
		this.id = id;
		this.device_name = device_name;
		this.purchased_ts = purchased_ts;
		this.first_used_ts = first_used_ts;
		this.sku_value = sku_value;
		this.upc_value = upc_value;
		this.upc_barcode_img_path = upc_barcode_img_path;
		this.users = users;
		this.pets = pets;
		this.petalkDeviceTriggers = petalkDeviceTriggers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public LocalDateTime getPurchased_ts() {
		return purchased_ts;
	}

	public void setPurchased_ts(LocalDateTime purchased_ts) {
		this.purchased_ts = purchased_ts;
	}

	public LocalDateTime getFirst_used_ts() {
		return first_used_ts;
	}

	public void setFirst_used_ts(LocalDateTime first_used_ts) {
		this.first_used_ts = first_used_ts;
	}

	public String getSku_value() {
		return sku_value;
	}

	public void setSku_value(String sku_value) {
		this.sku_value = sku_value;
	}

	public String getUpc_value() {
		return upc_value;
	}

	public void setUpc_value(String upc_value) {
		this.upc_value = upc_value;
	}

	public String getUpc_barcode_img_path() {
		return upc_barcode_img_path;
	}

	public void setUpc_barcode_img_path(String upc_barcode_img_path) {
		this.upc_barcode_img_path = upc_barcode_img_path;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Set<PetalkDeviceTrigger> getPetalkDeviceTriggers() {
		return petalkDeviceTriggers;
	}

	public void setPetalkDeviceTriggers(Set<PetalkDeviceTrigger> petalkDeviceTriggers) {
		this.petalkDeviceTriggers = petalkDeviceTriggers;
	}
	
	
}
