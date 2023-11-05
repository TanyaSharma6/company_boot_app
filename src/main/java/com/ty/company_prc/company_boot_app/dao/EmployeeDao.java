package com.ty.company_prc.company_boot_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.company_prc.company_boot_app.dto.Employee;
import com.ty.company_prc.company_boot_app.repo.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepository employeeRepository ;
	
	public Employee saveEmployee(Employee employee) {
			return employeeRepository.save(employee);
	}
	
	public Employee getEmployeeById(int id) {
			return employeeRepository.findById(id).get();
	}
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "Deleted";
	}
}
