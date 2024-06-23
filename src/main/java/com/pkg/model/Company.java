package com.pkg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String companyName;
    private String companyLocation;
    private String webSiteName;
    private String helpMailAddress;
    @Transient
    private String motoCompany;

//    private List<Course> listOfCourse;
}
