package com.example.Symbiosis.Service;

import java.util.List;

import com.example.Symbiosis.Entity.Company;
import com.example.Symbiosis.Entity.Course;

public interface CourseService {
	
	public List<Course> getAllCourseByCompanyId(Long companyId);
	
	public void updateBatchCount();
	
	public void addCourse(String courseName, Long companyId);
}
