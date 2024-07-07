//	package com.example.Symbiosis.Controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.example.Symbiosis.Entity.Student;
//import com.example.Symbiosis.Service.Studentservice;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@Controller
//	public class StudentController {
//		 @Autowired
//		    private Studentservice studentService;
//		 
//		 	
//		 	
//		 	@GetMapping("/add-student")
//		 	public String addStudent() {
//		 		return "add_student";
//		 	}
//
//		 	@PostMapping("/saveStudent")
//		    public String saveStudent(@RequestParam("name") String name,@RequestParam("batch_id") Long batchId,
//		                              @RequestParam("adhar_card") MultipartFile adharCard,
//		                              @RequestParam("income_certificate") MultipartFile incomeCertificate,
//		                              @RequestParam("twelfth_result") MultipartFile twelfthResult,
//		                              @RequestParam("tenth_result") MultipartFile tenthResult,RedirectAttributes redirectAttributes) {
//		        System.out.println(batchId);
//		 		try {
//		            studentService.saveStudent(name, batchId, adharCard, incomeCertificate, twelfthResult, tenthResult);
//		            redirectAttributes.addFlashAttribute("message", "Student added successfully!");
//		        } catch (IOException e) {
//		        	
//		            redirectAttributes.addFlashAttribute("error", "Failed to save student data. Please try again.");
//		        }
//		        return "redirect:/add-student";
//		    }
//		 	
//		 	@GetMapping("/student/{id}")
//		 	public String getSudentByCourseId(@PathVariable("id") Long batchId, Model model) {
//				List<Student> students = studentService.getAllStudentByBatchId(batchId);
//				model.addAttribute("students", students);
//		 		return "student";
//		 		
//		 	}
//	}


package com.example.Symbiosis.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Symbiosis.Entity.Student;
import com.example.Symbiosis.Service.Studentservice;

@Controller
public class StudentController {

    @Autowired
    private Studentservice studentService;
    
    Long currentBatch;
    
    @GetMapping("/add-student/{batchId}")
    public String addStudent(@PathVariable("batchId") Long batchId) {
    	currentBatch = batchId;
        return "add_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@RequestParam("name") String name,
    						  @RequestParam("gender") String gender,
                              @RequestParam("adhar_card") MultipartFile aadharCard,
                              @RequestParam("income_certificate") MultipartFile incomeCertificate,
                              @RequestParam("twelfth_result") MultipartFile twelfthResult,
                              @RequestParam("tenth_result") MultipartFile tenthResult,
                              RedirectAttributes redirectAttributes) {
    	System.out.println(gender);
        try {
            studentService.saveStudent(name, currentBatch, gender , aadharCard, incomeCertificate, twelfthResult, tenthResult);
            
        } catch (IOException e) {
     
        }
        return "student";
    }

    @GetMapping("/student/{id}")
    public String getSudentByCourseId(@PathVariable("id") Long batchId, Model model) {
        List<Student> students = studentService.getAllStudentByBatchId(batchId);
        model.addAttribute("students", students);
        return "student";
    }

//    @GetMapping("/downloadDocument/{studentId}/{documentType}")
//    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable Long studentId, @PathVariable String documentType) {
//        Student student = studentService.getStudentById(studentId);
//        byte[] data = null;
//        String filename = null;
//
//        switch (documentType) {
//            case "adharCard":
//                data = student.getAadharCard();
//                filename = "AadharCard_" + studentId + ".pdf";
//                break;
//            case "incomeCertificate":
//                data = student.getIncomeCertificate();
//                filename = "IncomeCertificate_" + studentId + ".pdf";
//                break;
//            case "twelfthResult":
//                data = student.getTwelfthResult();
//                filename = "TwelfthResult_" + studentId + ".pdf";
//                break;
//            case "tenthResult":
//                data = student.getTenthResult();
//                filename = "TenthResult_" + studentId + ".pdf";
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid document type: " + documentType);
//        }
//
//        if (data == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        ByteArrayResource resource = new ByteArrayResource(data);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//                .body(resource);
//    }
}
