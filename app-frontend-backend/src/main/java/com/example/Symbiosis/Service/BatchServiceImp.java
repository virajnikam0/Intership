package com.example.Symbiosis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Symbiosis.Entity.Batch;
import com.example.Symbiosis.Entity.Company;
import com.example.Symbiosis.Entity.Course;
import com.example.Symbiosis.Repository.BatchRepository;
import com.example.Symbiosis.Repository.CourseRepository;
import com.example.Symbiosis.Repository.StudentRepository;

@Service
public class BatchServiceImp implements BatchService{
	
	@Autowired
	private BatchRepository batchRpository;

	@Autowired
    private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRpository;
	
	@Override
	public List<Batch> findAllByhouseBatch() {
	
		return batchRpository.findAll();
	}

	@Override
	public List<Batch> findAllByCourseId(Long CourseId) {
		List<Batch> batchList = batchRpository.findAllBycourse_id(CourseId);
		return batchList;
	}

	@Override
	public List<Batch> findAllByCourseIdAndHouseBatch(Long courseId, String houseBatch) {
		return batchRpository.findByCourseIdAndHouseBatch(courseId, houseBatch);
	}

	@Override
	public List<Batch> findAllByhouseBatch(String houseBatch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Batch> batchRpository(Long courseId, String houseBatch) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void updateStudentNo() {
		List<Batch> batches = batchRpository.findAll();
        for (Batch batch : batches) {
            int studentCount = studentRepository.countByBatch_Id(batch.getId());
            int maleCount = studentRepository.countByBatch_IdAndGender(batch.getId(), "male");
            int femaleCount = studentRepository.countByBatch_IdAndGender(batch.getId(), "female");
            System.out.println(studentCount);
            batch.setTotalCount(studentCount);
            batch.setMaleCount(maleCount);
            batch.setFemaleCount(femaleCount);
            batchRpository.save(batch); 
        }
        
	}
	
	@Override
	public void addBatch(String batchName, Long courseId, String houseBatch) {
		if (batchRpository.existsByName(batchName)) {
            throw new IllegalArgumentException("Company with name '" + batchName + "' already exists.");
        }
		Course course = courseRpository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Company with ID " + courseId + " not found"));

		Batch batch = new Batch();
		batch.setHouseBatch(houseBatch);
		batch.setName(batchName);
		batch.setCourse(course);
		batchRpository.save(batch);
		
	}
	
}
