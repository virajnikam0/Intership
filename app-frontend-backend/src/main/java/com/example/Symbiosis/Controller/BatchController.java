package com.example.Symbiosis.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Symbiosis.Entity.Batch;
import com.example.Symbiosis.Entity.Course;
import com.example.Symbiosis.Service.BatchService;
import com.example.Symbiosis.Service.Studentservice;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
    private Studentservice studentService;
	
	Long idFromCourse;
	
	
	
	

	@GetMapping("/company/courses/batch/{id}")
	public String getDashboard(@PathVariable("id") Long courseId,  Model model) {
		idFromCourse = courseId;
        model.addAttribute("in", "in");
        model.addAttribute("out", "out");
        
        return "batch"; // Name of the Thymeleaf template
    }
	
	  @GetMapping("/company/courses/batch/inHouseBatch/{houseBatch}")
	public String getBatchByhouseBatch(@PathVariable("houseBatch") String hBatch, Model model) {
		  batchService.updateStudentNo();
		  System.out.println(hBatch);
		  String convertedString = hBatch.substring(2, hBatch.length() - 1);
		  List<Batch> batches = batchService.findAllByCourseIdAndHouseBatch(idFromCourse, convertedString);
		  for(Batch a: batches) {
	        	System.out.println(a);
	        }
		  

		  model.addAttribute("batches", batches);

		return "in_batch";
		
	}
	  @PostMapping("/company/courses/addBatch/{courseId}")
	    public String addBatch(
	            @RequestParam("batchName") String batchName,
	            @RequestParam("batchType") String batchType,
	            @PathVariable Long courseId) {
	        batchService.addBatch(batchName, courseId, batchType);

	        // After adding the batch, you can return a success message or redirect to another page
	        return "Batch added successfully";
	    }

}
