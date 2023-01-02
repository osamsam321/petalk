package com.ozi.petalk.model;


import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id;
	@Nonnull
	private LocalDateTime purchase_ts;
	@Nonnull
	private float cost;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private User user;
	
	public PurchaseAudit(int id, LocalDateTime purchase_ts, float cost, User user) {
		super();
		this.id = id;
		this.purchase_ts = purchase_ts;
		this.cost = cost;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getPurchase_ts() {
		return purchase_ts;
	}

	public void setPurchase_ts(LocalDateTime purchase_ts) {
		this.purchase_ts = purchase_ts;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
