package com.ty.company_prc.company_boot_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.company_prc.company_boot_app.dao.CompanyDao;
import com.ty.company_prc.company_boot_app.dao.EmployeeDao;
import com.ty.company_prc.company_boot_app.dto.Employee;
import com.ty.company_prc.company_boot_app.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private CompanyDao companyDao;
	
	
	public ResponseStructure<Employee> saveEmployee(Employee employee,int id) {
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();

		employee.setCompany(companyDao.getCompanyById(id));
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(employeeDao.saveEmployee(employee));
			return responseStructure;
	}
	
	
	public ResponseStructure<Employee> getEmployeeById(int id) {
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();
		
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Found Item");
		responseStructure.setData(employeeDao.getEmployeeById(id));
			return responseStructure;
	
	}
	public ResponseStructure<String> deleteEmployeeById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Item Deleted");
		responseStructure.setData(employeeDao.deleteEmployeeById(id));
		return responseStructure;
	
	}
}
