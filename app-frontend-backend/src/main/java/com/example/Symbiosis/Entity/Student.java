package com.example.Symbiosis.Entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String gender;
    
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] aadharCard;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] incomeCertificate;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] twelfthResult;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] tenthResult;
   

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

   

   


	public Student(Long id, String name, String gender, byte[] aadharCard, byte[] incomeCertificate,
			byte[] twelfthResult, byte[] tenthResult, Batch batch) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.aadharCard = aadharCard;
		this.incomeCertificate = incomeCertificate;
		this.twelfthResult = twelfthResult;
		this.tenthResult = tenthResult;
		this.batch = batch;
	}

	
	
	
	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public byte[] getAadharCard() {
		return aadharCard;
	}


	public void setAadharCard(byte[] aadharCard) {
		this.aadharCard = aadharCard;
	}


	public byte[] getIncomeCertificate() {
		return incomeCertificate;
	}


	public void setIncomeCertificate(byte[] incomeCertificate) {
		this.incomeCertificate = incomeCertificate;
	}


	public byte[] getTwelfthResult() {
		return twelfthResult;
	}


	public void setTwelfthResult(byte[] twelfthResult) {
		this.twelfthResult = twelfthResult;
	}


	public byte[] getTenthResult() {
		return tenthResult;
	}


	public void setTenthResult(byte[] tenthResult) {
		this.tenthResult = tenthResult;
	}


	public Student() {
        super();
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

    

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }




	
}
