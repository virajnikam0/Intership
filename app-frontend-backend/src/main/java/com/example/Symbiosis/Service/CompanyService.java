package com.example.Symbiosis.Service;

import java.util.List;

import com.example.Symbiosis.Entity.Company;

public interface CompanyService {
	
	public List<Company> getAllCompanies();
	
	public void updateCourseNo();
	
	public void addCompany(String company);
	
	
}
