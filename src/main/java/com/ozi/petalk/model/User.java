package com.ozi.petalk.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

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
			 Set <Location> locations = new HashSet <Location> ();
	
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
	
	@OneToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy = "user" )
		private Set<PurchaseAudit> purchaseAudit;

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", username=" + username + ", roles=" + roles + ", locations=" + locations + ", petalkDevices="
				+ petalkDevices + ", petsOwnedByUsers=" + petsOwnedByUsers + ", purchaseAudit=" + purchaseAudit + "]";
	}
	
	
			



	
}




