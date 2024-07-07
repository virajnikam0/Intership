package com.example.Symbiosis.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Symbiosis.Entity.Student;

public interface Studentservice {
	
	
	public List<Student> getAllStudentByBatchId(Long batchId);

	

	public Student getStudentById(Long studentId);

	public void saveStudent(String name, Long batchId, String gender, MultipartFile adharCard, MultipartFile incomeCertificate,
			MultipartFile twelfthResult, MultipartFile tenthResult) throws IOException;
	
//	public int countStudentByBatchId(Long batchId);
}
