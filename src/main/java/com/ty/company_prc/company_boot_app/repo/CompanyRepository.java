package com.ty.company_prc.company_boot_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.company_prc.company_boot_app.dto.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
