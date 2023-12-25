package com.ozi.petalk.model;


import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="registration_audit")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class RegistrationAudit {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id;
	@Nonnull
	private int user_id;
	@Nonnull
	private LocalDateTime registration_ts;
	@Nonnull
	private String computer_device_type;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role rolesMarkedInRegistrationAudit;
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public LocalDateTime getRegistration_ts() {
		return registration_ts;
	}

	public void setRegistration_ts(LocalDateTime registration_ts) {
		this.registration_ts = registration_ts;
	}

	public String getComputer_device_type() {
		return computer_device_type;
	}

	public void setComputer_device_type(String computer_device_type) {
		this.computer_device_type = computer_device_type;
	}

	public Role getRolesMarkedInRegistrationAudit() {
		return rolesMarkedInRegistrationAudit;
	}

	public void setRolesMarkedInRegistrationAudit(Role rolesMarkedInRegistrationAudit) {
		this.rolesMarkedInRegistrationAudit = rolesMarkedInRegistrationAudit;
	}
	
	
}
