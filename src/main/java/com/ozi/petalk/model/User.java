package com.ozi.petalk.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private long id;
	@Nonnull
	private String first_name;
	@Nonnull
	private String last_name;
	@Nonnull
	private String email;
	@Nonnull
	private String username;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      })
	@JoinTable(
		    name="user_role",
		    joinColumns=@JoinColumn(name="user_id"),
		    inverseJoinColumns=@JoinColumn(name="role_id")
		)
	 Set <Role> roles = new HashSet <Role> ();
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
			@JoinTable(
				    name="user_location",
				    joinColumns=@JoinColumn(name="user_id"),
				    inverseJoinColumns=@JoinColumn(name="location_id")
				)
			 Set <Location> userLocations = new HashSet <Location> ();
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
			@JoinTable(
				    name="user_petalk_devices",
				    joinColumns=@JoinColumn(name="user_id"),
				    inverseJoinColumns=@JoinColumn(name="petalk_device_id")
				)
			 Set <PetalkDevice> petalkDevices = new HashSet <PetalkDevice> ();
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      })
			@JoinTable(
				    name="user_pet",
				    joinColumns=@JoinColumn(name="user_id"),
				    inverseJoinColumns=@JoinColumn(name="pet_id")
				)
			 Set <Pet> petsOwnedByUsers = new HashSet <Pet> ();
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy = "user" )
		private Set<PurchaseAudit> purchaseAudit;

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", username=" + username + ", roles=" + roles + ", locations=" + userLocations + ", petalkDevices="
				+ petalkDevices + ", petsOwnedByUsers=" + petsOwnedByUsers + ", purchaseAudit=" + purchaseAudit + "]";
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String first_name, String last_name, String email, String username, Set<Role> roles,
			Set<Location> userLocations, Set<PetalkDevice> petalkDevices, Set<Pet> petsOwnedByUsers,
			Set<PurchaseAudit> purchaseAudit) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.roles = roles;
		this.userLocations = userLocations;
		this.petalkDevices = petalkDevices;
		this.petsOwnedByUsers = petsOwnedByUsers;
		this.purchaseAudit = purchaseAudit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Location> getuserLocations() {
		return userLocations;
	}

	public void setuserLocations(Set<Location> locations) {
		this.userLocations = locations;
	}

	public Set<PetalkDevice> getPetalkDevices() {
		return petalkDevices;
	}

	public void setPetalkDevices(Set<PetalkDevice> petalkDevices) {
		this.petalkDevices = petalkDevices;
	}

	public Set<Pet> getPetsOwnedByUsers() {
		return petsOwnedByUsers;
	}

	public void setPetsOwnedByUsers(Set<Pet> petsOwnedByUsers) {
		this.petsOwnedByUsers = petsOwnedByUsers;
	}

	public Set<PurchaseAudit> getPurchaseAudit() {
		return purchaseAudit;
	}

	public void setPurchaseAudit(Set<PurchaseAudit> purchaseAudit) {
		this.purchaseAudit = purchaseAudit;
	}
	
	
	
	
			



	
}




