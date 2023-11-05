package com.ty.company_prc.company_boot_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.company_prc.company_boot_app.dto.Company;
import com.ty.company_prc.company_boot_app.repo.CompanyRepository;


@Repository
public class CompanyDao {

	@Autowired
	private CompanyRepository companyRepository;
	
	public Company saveCompany(Company company) {
		return companyRepository.save(company);
	}
	
	public Company getCompanyById(int id) {
		return companyRepository.findById(id).get();
	}
	
	public String deleteCompanyById(int id) {
		companyRepository.deleteById(id);
		return "Deleted";
	}
	public Company updateCompany(Company company) {
		return companyRepository.save(company);
		
	}
}
