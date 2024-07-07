//	package com.example.Symbiosis.Service;
//	
//	import java.io.IOException;
//	import java.util.List;
//	
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.stereotype.Service;
//	import org.springframework.web.multipart.MultipartFile;
//	
//	import com.example.Symbiosis.Entity.Student;
//	import com.example.Symbiosis.Repository.StudentRepository;
//	
//	@Service
//	public class StudentServiceImp implements Studentservice {
//		
//		@Autowired
//	    private StudentRepository studentRepository;
//		
//		@Override
//		public void saveStudent(String name,Long batchId, MultipartFile adharCard, MultipartFile incomeCertificate,
//				MultipartFile twelfthResult, MultipartFile tenthResult) throws IOException {
//			Student student = new Student();
//	        student.setName(name);
//	
//	        // Convert MultipartFile to byte array and save to Student entity
//	        student.setAadharCard(adharCard.getBytes());
//	        student.setIncomeCertificate(incomeCertificate.getBytes());
//	        student.setTwelfthResult(twelfthResult.getBytes());
//	        student.setTenthResult(tenthResult.getBytes());
//	
//	        // Save the student entity to the database
//	        studentRepository.save(student);
//			
//		}
//	
//		@Override
//		public List<Student> getAllStudentByBatchId(Long batchId) {
//			List<Student> studentList = studentRepository.findAllByBatch_Id(batchId);
//			return studentList;
//		}
//	
//	}

package com.example.Symbiosis.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Symbiosis.Entity.Batch;
import com.example.Symbiosis.Entity.Student;
import com.example.Symbiosis.Repository.BatchRepository;
import com.example.Symbiosis.Repository.StudentRepository;

@Service
public class StudentServiceImp implements Studentservice {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public void saveStudent(String name, Long batchId,String gender, MultipartFile adharCard, MultipartFile incomeCertificate,
                            MultipartFile twelfthResult, MultipartFile tenthResult) throws IOException {
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        // Convert MultipartFile to byte array and save to Student entity
        student.setAadharCard(adharCard.getBytes());
        student.setIncomeCertificate(incomeCertificate.getBytes());
        student.setTwelfthResult(twelfthResult.getBytes());
        student.setTenthResult(tenthResult.getBytes());

        // Retrieve the Batch entity and set it on the Student entity
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid batch ID: " + batchId));
        student.setBatch(batch);

        // Save the student entity to the database
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudentByBatchId(Long batchId) {
        return studentRepository.findAllByBatch_Id(batchId);
    }

	@Override
	public Student getStudentById(Long studentId) {
		// TODO Auto-generated method stub
		return null;
	}
}

