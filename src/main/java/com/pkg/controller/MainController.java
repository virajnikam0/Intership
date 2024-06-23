package com.pkg.controller;

import com.pkg.model.Company;
import com.pkg.model.Course;
import com.pkg.model.Trainer;
import com.pkg.service.CompanyService;
import com.pkg.service.CourseService;
import com.pkg.service.StudentService;
import com.pkg.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TrainerService teacherService;

    @GetMapping("/home")
    public String getHome(){
        return"side_nav_bar";
    }

    @GetMapping("/company")
    public String getCompany(Model model) {
        model.addAttribute("listOfCompany",companyService.getAllCompanies());
        return "company";
    }

    @GetMapping("/company/list-of-all-company")
    public String addNewCompany(Model model){
        model.addAttribute("listOfCompany",companyService.getAllCompanies());
        return "company-list";
    }

    @GetMapping("/company/add-new-company")
    public String formForNewCompany() {
        return "add-new-company";
    }

    @PostMapping("/company/add-new-company")
    public String getAllDataOfCompany(@ModelAttribute("companyObject") Company company) {
        companyService.saveCompany(company);
        return "redirect:/company";
    }

    @GetMapping("/courses")
    public String getListOfCourses(){
        return"courses";
    }

    @GetMapping("/courses/list-of-all-courses")
    public String addNewCourses(Model model){
        model.addAttribute("listOfCourses",courseService.getAllCourses());
        return "courses-list";
    }

    @GetMapping("/courses/add-new-courses")
    public String formForNewCourses() {
        return "add-new-courses";
    }

    @PostMapping("/courses/add-new-courses")
    public String getAllDataOfCourses(@ModelAttribute("coursesObject") Course courses) {
        courseService.saveCourse(courses);
        return "redirect:/courses";
    }



}
