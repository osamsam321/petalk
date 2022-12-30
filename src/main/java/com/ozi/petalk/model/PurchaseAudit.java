package com.ozi.petalk.model;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "purchase_audit")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class PurchaseAudit {
	@Id
	@Nonnull
	private int id;
	@Nonnull
	private Timestamp purchase_ts;
	@Nonnull
	private float cost;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	
}
