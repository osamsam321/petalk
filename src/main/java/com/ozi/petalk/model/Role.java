package com.ozi.petalk.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="role")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Role {
	@Nonnull
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private int id;
	@Nonnull 
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private PETALK_ROLE role_type;
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      }, mappedBy="roles")
    public List<User> users;
	
	@OneToOne(mappedBy = "rolesMarkedInRegistrationAudit")
	RegistrationAudit ra;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, PETALK_ROLE role_type, List<User> users, RegistrationAudit ra) {
		super();
		this.id = id;
		this.role_type = role_type;
		this.users = users;
		this.ra = ra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PETALK_ROLE getRole_type() {
		return role_type;
	}

	public void setRole_type(String PETALK_ROLE) {
		this.role_type = role_type;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public RegistrationAudit getRa() {
		return ra;
	}

	public void setRa(RegistrationAudit ra) {
		this.ra = ra;
	}
	
	
	

}
