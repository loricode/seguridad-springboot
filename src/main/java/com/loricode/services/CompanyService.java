package com.loricode.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loricode.repositories.ICompanyRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loricode.dtos.*;
import com.loricode.model.Company;
import com.loricode.model.User;

@Service
public class CompanyService {

	@Autowired
	private ICompanyRepository iCompanyRepository;
	
	public List<Company> getCompaniesFindAll(){
		return this.iCompanyRepository.findAll();
	}
	
	public List<CompanyUserDto> getListCompanies(){
		
		List<CompanyDto> list = this.iCompanyRepository.getListCompanies();
		
		List<CompanyUserDto> companyUser = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		
	     	list.forEach(x -> {
	     		
	     		CompanyUserDto company = new CompanyUserDto();
	     		
	           try  { 
	        	  
	        	   User[] jsonObj = mapper.readValue(x.getJsonString(), User[].class);
	        	   
	        	   List<User> userList = new ArrayList<>(Arrays.asList(jsonObj));
				  
	        	   company.setCompanyId(x.getCompanyId());
				   company.setDescription(x.getDescription());
				   company.setName(x.getName());
				   company.setUserList(userList);
				   
				   companyUser.add(company);
						  		   
				   
	     	      } catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		    });
		
           return companyUser;
	}
	
}
