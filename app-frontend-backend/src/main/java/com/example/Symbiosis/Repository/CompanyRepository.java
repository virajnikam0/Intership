package com.example.Symbiosis.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Symbiosis.Entity.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

	boolean existsByName(String comapany);
	
}
