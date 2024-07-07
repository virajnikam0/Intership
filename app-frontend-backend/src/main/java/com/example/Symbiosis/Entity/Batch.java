package com.example.Symbiosis.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Batch {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int totalCount;
    private int maleCount;
    private int femaleCount;
    private String houseBatch;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;  // Collection type for one-to-many relationship

    // Constructors, getters, setters, etc.

    public Batch() {
        super();
    }

    

    public Batch(Long id, String name, int totalCount, int maleCount, int femaleCount, String houseBatch, Course course,
			List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.totalCount = totalCount;
		this.maleCount = maleCount;
		this.femaleCount = femaleCount;
		this.houseBatch = houseBatch;
		this.course = course;
		this.students = students;
	}



	// Getters and setters
    
    
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

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(int maleCount) {
        this.maleCount = maleCount;
    }

    public int getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(int femaleCount) {
        this.femaleCount = femaleCount;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



	public String getHouseBatch() {
		return houseBatch;
	}



	public void setHouseBatch(String houseBatch) {
		this.houseBatch = houseBatch;
	}



	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", totalCount=" + totalCount + ", maleCount=" + maleCount
				+ ", femaleCount=" + femaleCount + ", houseBatch=" + houseBatch + ", course=" + course + ", students="
				+ students + "]";
	}
    
    
}
