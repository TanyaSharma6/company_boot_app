package com.ty.company_prc.company_boot_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.company_prc.company_boot_app.dao.CompanyDao;
import com.ty.company_prc.company_boot_app.dto.Company;
import com.ty.company_prc.company_boot_app.service.CompanyService;
import com.ty.company_prc.company_boot_app.util.ResponseStructure;



@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyDao companyDao;
	
	@PostMapping("savecompany")
	public ResponseStructure<Company> saveCompany(@RequestBody Company company) {
		return companyService.saveCompany(company);
	}
	
	@GetMapping("getcompany")
	public ResponseStructure<Company> getCompany(@RequestParam int id){
		return companyService.getCompanyById(id);
	}
	
	@DeleteMapping("deletecompany")
	public ResponseStructure<String> deleteCompany(@RequestParam int id){
		return companyService.deleteCompanyById(id);
	}
	
	@PutMapping("updatecompany/{id}")
	public ResponseStructure<Company> updateCompany(@RequestBody Company company,@PathVariable int id){
		ResponseStructure<Company> responseStructure = new ResponseStructure<Company>();
		
		Company company2= companyDao.getCompanyById(id);
		
		if(company2!=null) {
			company.setId(id);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(companyDao.saveCompany(company));
			return responseStructure;
			
		}
		
		
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Such ID Found");
		responseStructure.setData(null);
		
		return responseStructure;
	}
}
