package com.loricode.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name = "companies")
public class Company {

	@Id
	@Column(length = 36)
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy="org.hibernate.id.UUIDGenerator")
	private String companyId;
	
	@Column(name="name", length = 180)
	private String name;
	
	@Column(name="description", length = 220)
	private String description;
	
	public Company() {
		
	}

	public Company(String companyId, String name, String description) {
		this.companyId = companyId;
		this.name = name;
		this.description = description;
	}

	public String getCompanyId() {
		return companyId;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "company")
    public List<User> usersList = new ArrayList<User>();


	public List<User> getUsersList() {
		return usersList;
	}

	@JsonIgnore
	@Transient
	public String jsonString;
	

	public String getJsonString() {
		return jsonString;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
