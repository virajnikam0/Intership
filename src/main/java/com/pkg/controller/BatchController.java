package com.example.Symbiosis.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Symbiosis.Entity.Batch;
import com.example.Symbiosis.Entity.Course;
import com.example.Symbiosis.Service.BatchService;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	Long idFromCourse;
	
	
	@GetMapping("/about")
	public String getAboutUs() {
		return "about";
	}
	
	
	

	@GetMapping("/company/courses/batch/{id}")
	public String getDashboard(@PathVariable("id") Long courseId,  Model model) {
		idFromCourse = courseId;
        model.addAttribute("in", "in");
        model.addAttribute("out", "out");
        
        return "batch"; // Name of the Thymeleaf template
    }
	
	  @GetMapping("/company/courses/batch/inHouseBatch/{houseBatch}")
	public String getBatchByhouseBatch(@PathVariable("houseBatch") String hBatch, Model model) {
		  System.out.println(hBatch);
		  String convertedString = hBatch.substring(2, hBatch.length() - 1);
		  List<Batch> batches = batchService.findAllByCourseIdAndHouseBatch(idFromCourse, convertedString);
		  for(Batch a: batches) {
	        	System.out.println(a);
	        }
		  
//		  List<Batch> batches1 = batchService.findAllByCourseIdAndHouseBatch(idFromCourse, hBatch);
//		  
//		  List<Batch> newList = new ArrayList<Batch>();
//		  
//		  List<Batch> allByhouseBatch = batchService.findAllByhouseBatch();
//		  
//		  for( Batch bt: allByhouseBatch) {
//			  if(bt.getHouseBatch().equals("in")){
//				  System.out.println("ins");
//				  
//				  newList.add(bt);
//			  }
//		  }
//		  System.out.println(newList);
		  model.addAttribute("batches", batches);

		return "in_batch";
		
	}

}
