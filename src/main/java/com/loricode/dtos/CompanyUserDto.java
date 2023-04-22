package com.loricode.dtos;

import java.util.List;

import com.loricode.model.User;

public class CompanyUserDto {

	private String companyId;
	
	private String name;
	
	private String description;
	

	public String getCompanyId() {
		return companyId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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
	
	public List<User> userList; 

	
     public CompanyUserDto() {
		
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
