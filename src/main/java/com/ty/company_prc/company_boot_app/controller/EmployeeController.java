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

import com.ty.company_prc.company_boot_app.dao.EmployeeDao;
import com.ty.company_prc.company_boot_app.dto.Employee;
import com.ty.company_prc.company_boot_app.service.CompanyService;
import com.ty.company_prc.company_boot_app.service.EmployeeService;
import com.ty.company_prc.company_boot_app.util.ResponseStructure;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;	
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@PostMapping("saveemployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee,@RequestParam int id) {
			
		return employeeService.saveEmployee(employee,id);
		
		
	}
	
	@GetMapping("getemployee")
	public ResponseStructure<Employee> getEmployee(@RequestParam int id) {
			
		return employeeService.getEmployeeById(id);
		
	}
	
	@DeleteMapping("deleteemployee")
	public ResponseStructure<String> deleteEmployee(@RequestParam int id) {
			
		return employeeService.deleteEmployeeById(id);
		
	}
	
	
	
	@PutMapping("updateemployee/{companyid}")
	public ResponseStructure<Employee> updateEmployee(@RequestBody Employee employee,@RequestParam int id,@PathVariable int companyid) {
		ResponseStructure<Employee> responseStructure = new ResponseStructure<Employee>();

		Employee employee1 = employeeDao.getEmployeeById(id);
		
		if(employee1 != null) {
			employee.setId(id);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found and updated");
			employeeService.saveEmployee(employee,companyid);
			responseStructure.setData(employeeDao.getEmployeeById(id));
			return responseStructure;		
		}
		
		return responseStructure;
	}
	
}
