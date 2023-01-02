package com.ozi.petalk.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
	private String role_type;
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

	public Role(int id, String role_type, List<User> users, RegistrationAudit ra) {
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

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
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
