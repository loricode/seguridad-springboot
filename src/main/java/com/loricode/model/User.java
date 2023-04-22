package com.loricode.model;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {

	@Id
	@Column(length = 36)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy="org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name="fullname", length = 180)
	private String fullName;
	
	@Column(name="email", length = 180, unique = true)
	private String email;
	
	public User() {
		
	}

	public User(String id, String fullName, String email) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getEmail() {
		return email;
	}
	
	@JsonIgnore
	@ManyToOne
    public Company company;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}
}
