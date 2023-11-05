package com.ty.company_prc.company_boot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.company_prc.company_boot_app.dao.CompanyDao;
import com.ty.company_prc.company_boot_app.dto.Company;
import com.ty.company_prc.company_boot_app.util.ResponseStructure;


@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	public ResponseStructure<Company> saveCompany(Company company) {
		ResponseStructure<Company> responseStructure = new ResponseStructure<Company>();
		
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(companyDao.saveCompany(company));
		return responseStructure;
	}
	
	public ResponseStructure<Company> getCompanyById(int id) {
		ResponseStructure<Company> responseStructure = new ResponseStructure<Company>();
		
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Found");
		responseStructure.setData(companyDao.getCompanyById(id));
		
		return responseStructure;
	}
	public ResponseStructure<String> deleteCompanyById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Deleted");
		responseStructure.setData(companyDao.deleteCompanyById(id));
		
		return responseStructure;
	}
}
