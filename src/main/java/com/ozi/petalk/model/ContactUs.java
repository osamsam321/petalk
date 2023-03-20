package com.ozi.petalk.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_us")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class ContactUs {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	@Nonnull
	private String name;
	@Nonnull
	private String email;
	@Nonnull
	private String subject;
	@Nonnull
	private String message;
	
	
	public ContactUs() {
		super();
		this.name = "";
		this.email = "";
		this.subject = 	"";
		this.message = "";
	
	}
	public ContactUs(String name, String email, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
