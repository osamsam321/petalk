package com.ozi.petalk.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	private int id;
	@Nonnull
	private int user_id;
	@Nonnull
	private Timestamp registration_ts;
	@Nonnull
	private String computer_device_type;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role rolesMarkedInRegistrationAudit;
	
	
}
