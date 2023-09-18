package edu.mum.cs.cs425.demowebapps.elibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/eregistrar/students"})
public class StudentController {

    @GetMapping()
    public String displayStudentList() {
        return "student/index";
    }

    @GetMapping("/register")
    public String registerNewStudent() {
        return "student/register";
    }
}
