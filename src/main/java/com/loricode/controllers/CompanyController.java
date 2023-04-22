package com.loricode.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.loricode.dtos.CompanyUserDto;
import com.loricode.model.Company;
import com.loricode.services.CompanyService;


@RestController
@CrossOrigin
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("listFindAll")
	public ResponseEntity<List<Company>> getCompaniesFindAll(){
		
		return ResponseEntity.ok(companyService.getCompaniesFindAll());
		
	}

	@GetMapping("list")
	public ResponseEntity<List<CompanyUserDto>> getListComanies(){
		
		return ResponseEntity.ok(companyService.getListCompanies());
		
	}
	
}
