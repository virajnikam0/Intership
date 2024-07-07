package com.example.Symbiosis.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Symbiosis.Entity.Course;
import com.example.Symbiosis.Service.CourseService;

import jakarta.transaction.Transactional;


@Controller
@Transactional
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/company/courses/{id}")
    public String getCoursesByCompanyId(@PathVariable("id") Long companyId, Model model) {
		courseService.updateBatchCount();
        List<Course> courses = courseService.getAllCourseByCompanyId(companyId);
        for(Course a: courses) {
        	System.out.println(a);
        }
        model.addAttribute("courses", courses);
        
        return "course";
    }
	
	 @PostMapping("/company/course/add/{companyId}")
	    public String addCourse(@PathVariable Long companyId, String courseName) {
	        System.out.println("check");
	        courseService.addCourse(courseName, companyId );
//	        After adding redirect to company page
	        return "company"; 
	    }
}
