package com.example.Symbiosis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Symbiosis.Entity.Company;
import com.example.Symbiosis.Entity.Course;
import com.example.Symbiosis.Service.CompanyService;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class CompanyController {
	 	
		@Autowired 
		private CompanyService companyService;

	    @GetMapping("/home")
	    public String getAllComapany(Model model) {
	    	
	    	companyService.updateCourseNo();
	    	
	    	List<Company> existingCompany = companyService.getAllCompanies();
//	    	
	    	model.addAttribute("companys", existingCompany);
	    	return "company";
	    }
}
