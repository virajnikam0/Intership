package com.example.Symbiosis.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Symbiosis.Entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>{

	List<Batch> findAllByhouseBatch(String houseBatch);
	
//	List<Batch> findAllBycourse_id(Long id);

	List<Batch> findAllBycourse_id(Long courseId);

	List<Batch> findByCourseIdAndHouseBatch(Long courseId, String houseBatch);
	
	public int countByCourse_Id(Long id);

	boolean existsByName(String batchName);
}
