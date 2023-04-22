package com.loricode.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loricode.repositories.ICompanyRepository;
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
		
		List<CompanyUserDto> data = new ArrayList<>();
		
		List<CompanyDto> results = this.iCompanyRepository.getListCompanies();
		
		results.forEach(x -> {
			List<User> userList = new ArrayList<>();
			
			CompanyUserDto company = new CompanyUserDto();	
			
			userList.add(new User(x.getId(), x.getFullName(), x.getEmail()));
			company.setCompanyId(x.getCompanyId());
			company.setName(x.getName());
			company.setDescription(x.getDescription());
			company.setUserList(userList);
			data.add(company);
		});
	
		return data;
	}
	
}
