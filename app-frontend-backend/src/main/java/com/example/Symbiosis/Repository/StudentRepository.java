package com.example.Symbiosis.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Symbiosis.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findAllByBatch_Id(Long batchId);
	
	public int countByBatch_Id(Long id);
	
	public int countByBatch_IdAndGender(Long id, String gender);
}
