package com.example.Symbiosis.Service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Symbiosis.Entity.Company;
import com.example.Symbiosis.Entity.Course;
import com.example.Symbiosis.Repository.BatchRepository;
import com.example.Symbiosis.Repository.CompanyRepository;
import com.example.Symbiosis.Repository.CourseRepository;

@Service
public class CourseServiceImp implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private BatchRepository batchrepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	

	@Override
	public List<Course> getAllCourseByCompanyId(Long companyId) {
//		courseRepository.findBy(null, null)
		List<Course> courseList = courseRepository.findAllByCompany_Id(companyId);
		return courseList;
	}

	@Override
	public void updateBatchCount() {
		List<Course> Courses = courseRepository.findAll();
        for (Course course : Courses) {
            int batchCount = batchrepository.countByCourse_Id(course.getId());
            System.out.println(batchCount);
            course.setBatchCount(batchCount);
            courseRepository.save(course); 
        }
	}

	@Override
	public void addCourse(String courseName, Long companyId) {
		if (courseRepository.existsByNameAndCompany_Id(courseName, companyId)) {
	        throw new IllegalArgumentException("Course with name '" + courseName + "' already exists for company ID " + companyId);
	    }
		Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company with ID " + companyId + " not found"));

		Course course = new Course();
		course.setName(courseName);
		course.setCompany(company);
		courseRepository.save(course);
		
	}

}
