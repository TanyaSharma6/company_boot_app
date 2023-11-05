package com.ty.company_prc.company_boot_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.company_prc.company_boot_app.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
