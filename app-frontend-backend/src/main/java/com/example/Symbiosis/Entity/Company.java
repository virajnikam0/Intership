package com.example.Symbiosis.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {
	 	@Id 
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private int courseCount;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCourseCount() {
			return courseCount;
		}
		public void setCourseCount(int courseCount) {
			this.courseCount = courseCount;
		}
		public Company(Long id, String name, int courseCount) {
			super();
			this.id = id;
			this.name = name;
			this.courseCount = courseCount;
		}
		public Company() {
			super();
			// TODO Auto-generated constructor stub
		}
		}
