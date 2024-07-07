package com.example.Symbiosis.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Symbiosis.Entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	

	List<Course> findAllByCompany_Id(Long companyId);

	int countByCompany_Id(Long id);

	

	boolean existsByNameAndCompany_Id(String courseName, Long companyId);

	
	
}
