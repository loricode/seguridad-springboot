package com.loricode.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.loricode.dtos.CompanyDto;
import com.loricode.model.Company;

import jakarta.transaction.Transactional;

@EnableJpaRepositories
@Repository
public interface ICompanyRepository extends JpaRepository<Company, String> {

	  @Transactional
	  @Query(value="{ call sp_get_companies_users() }", nativeQuery = true)
	  public List<CompanyDto> getListCompanies();
	
}
