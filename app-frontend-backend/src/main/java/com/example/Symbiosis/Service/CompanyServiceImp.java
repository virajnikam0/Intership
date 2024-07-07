package com.example.Symbiosis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Symbiosis.Entity.Company;
import com.example.Symbiosis.Entity.Course;
import com.example.Symbiosis.Repository.CompanyRepository;
import com.example.Symbiosis.Repository.CourseRepository;

@Service
public class CompanyServiceImp implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
    private CourseRepository courseRepository;
	
	@Override
	public List<Company> getAllCompanies() {
	       return companyRepository.findAll();
	   }

	@Override
	public void updateCourseNo() {
		List<Company> companies = companyRepository.findAll();
        for (Company company : companies) {
            int courseCount = courseRepository.countByCompany_Id(company.getId());
            System.out.println(courseCount);
            company.setCourseCount(courseCount);
            companyRepository.save(company); 
        }
		
	}

	@Override
	public void addCompany(String comapany) {
		 if (companyRepository.existsByName(comapany)) {
	            throw new IllegalArgumentException("Company with name '" + comapany + "' already exists.");
	        }
		Company company1 = new Company();
		company1.setName(comapany);
		companyRepository.save(company1);
		
	}
	
	

}
