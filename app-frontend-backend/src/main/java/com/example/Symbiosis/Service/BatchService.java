package com.example.Symbiosis.Service;

import java.util.List;

import com.example.Symbiosis.Entity.Batch;

public interface BatchService {
	
	public List<Batch> findAllByhouseBatch(String houseBatch);
	
	public List<Batch> findAllByCourseId(Long CourseId);
	
	List<Batch> batchRpository(Long courseId, String houseBatch);

	List<Batch> findAllByhouseBatch();

	List<Batch> findAllByCourseIdAndHouseBatch(Long courseId, String houseBatch);

	public void updateStudentNo();

	public void addBatch(String batchName, Long courseId, String houseBatch);
	
	
}
